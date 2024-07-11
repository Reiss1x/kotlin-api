package reis1x.repo

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import reis1x.model.Product

@ApplicationScoped
class ProductRepo: PanacheRepository<Product> {
    fun findByName(name: String) = find("name", name).firstResult()

    fun findAllProducts(): List<Product> {
        return findAll().list()
    }
}