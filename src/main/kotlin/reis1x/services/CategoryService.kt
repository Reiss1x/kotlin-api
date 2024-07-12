package reis1x.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response
import reis1x.model.Category
import reis1x.model.CategoryDTO
import reis1x.repo.CategoryRepo

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
    fun getByName(name: String) = repo.findByName(name)

}