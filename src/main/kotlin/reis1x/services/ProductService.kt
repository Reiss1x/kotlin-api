package reis1x.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response
import reis1x.model.*
import reis1x.repo.ProductRepo

@ApplicationScoped
class ProductService {
    @Inject
    lateinit var repo: ProductRepo

    @Transactional
    fun getAll() = repo.findAll()
    @Transactional
    fun getByName(name: String) = repo.findByName(name)

    @Transactional
    fun createProduct(productDTO: ProductRequest): Product {
        val categories = productDTO.categories
        val cats = ArrayList<Category>()

        categories.forEach{
            val cat = Category()
            cat.name = it.name
            cats.add(cat)
        }

        val prod = Product()
        prod.prices = productDTO.prices
        prod.name = productDTO.name
        prod.categories = cats

        repo.persist(prod)
        return prod
    }

    @Transactional
    fun listProducts(): Response {
        val products = repo.findAllProducts()
        val productDTOs = products.map { product ->
            ProductResponse(
                id = product.id,
                name = product.name ?: "",
                prices = product.prices,
                categories = product.categories.map { category ->
                    CategoryDTO(
                        id = category.id,
                        name = category.name ?: ""
                    )
                }
            )
        }
        return Response.ok(productDTOs).build()
    }
    @Transactional
    fun listProductsByCategory(category: String): Response {
        val bruteProds = repo.findByCategoryName(category)

        val productDTOs = bruteProds.map { product ->
            ProductResponse(
                id = product.id,
                name = product.name ?: "",
                prices = product.prices,
                categories = product.categories.map { category ->
                    CategoryDTO(
                        id = category.id,
                        name = category.name ?: ""
                    )
                }
            )
        }
        return Response.ok(productDTOs).build()

    }
}