package reis1x.repo

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import reis1x.model.Category
import reis1x.model.Product

@ApplicationScoped
class CategoryRepo: PanacheRepository<Category> {
    fun findByName(name: String) = find("name", name).firstResult()
}