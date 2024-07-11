package reis1x.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response
import reis1x.model.Category
import reis1x.model.Product
import reis1x.repo.CategoryRepo
import reis1x.repo.ProductRepo

@ApplicationScoped
class CategoryService {

    @Inject
    lateinit var repo: CategoryRepo

    @Inject
    lateinit var prodRepo: ProductRepo

    @Transactional
    fun addCategory(cat: Category): Response{
        repo.persist(cat)
        return Response.ok(cat).build()
    }

    @Transactional
    fun getOrAdd(name:String): Category {
        val cat = getByName(name)

        if (cat != null){
            return cat
        } else {
            val category = Category()
            category.name = name
            addCategory(category)
            return category;
        }
    }

    @Transactional
    fun getAllCategories() = repo.findAll()

    @Transactional
    fun getByName(name: String) = repo.findByName(name)

}