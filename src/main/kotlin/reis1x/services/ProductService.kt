package reis1x.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response
import reis1x.model.Product
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
    fun addProduct(prod: Product): Response {
        repo.persist(prod)
        return Response.ok(prod).build()
    }
}