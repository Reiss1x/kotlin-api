package reis1x.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response
import reis1x.model.Category
import reis1x.model.ProdRequestDTO
import reis1x.model.Product
import reis1x.repo.ProductRepo

@ApplicationScoped
class ProductService {

    @Inject
    lateinit var repo: ProductRepo
    @Inject
    lateinit var catService: CategoryService

    @Inject
    lateinit var entityManager: EntityManager

    @Transactional
    fun getAll() = repo.findAll()
    @Transactional
    fun getByName(name: String) = repo.findByName(name)
    @Transactional
    fun addProduct(prodDTO: ProdRequestDTO): Response {
        val prod = Product()
        val categories = prodDTO.categories
        val aux = categories.map { catService.getOrAdd(it) }

        prod.name = prodDTO.name
        prod.prices = prodDTO.prices
        prod.description = prodDTO.description

        prod.categories = aux.toMutableList()
        repo.persist(prod)
        return Response.ok(prod).build()
    }
}