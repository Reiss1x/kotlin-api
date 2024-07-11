package reis1x.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response
import reis1x.model.Category
import reis1x.model.CategoryDTO
import reis1x.model.ProdResponseDTO
import reis1x.model.Product
import reis1x.repo.CategoryRepo
import reis1x.repo.ProductRepo

@ApplicationScoped
class CategoryService {

    @Inject
    lateinit var repo: CategoryRepo

    @Transactional
    fun addCategory(cat: Category): Response{
        repo.persist(cat)
        return Response.ok(cat).build()
    }

    @Transactional
    fun getAllCategories(): Response? {
        val categories = repo.findAllCategory()
        val categoryDTOs = categories.map { category ->
            CategoryDTO(
                id = category.id,
                name = category.name ?: ""
            )
        }
        return Response.ok(categoryDTOs).build()
    }
    @Transactional
    fun listProductsByCategory(category: String): Response {
        val cat = repo.findByName(category)
        return if (cat != null) {
            val productIds = cat.products.map { product -> product.id }
            Response.ok(productIds).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @Transactional
    fun getByName(name: String) = repo.findByName(name)

}