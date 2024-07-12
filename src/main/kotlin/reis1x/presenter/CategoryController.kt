package reis1x.presenter

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import reis1x.model.Category
import reis1x.services.CategoryService

@Path("/cat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CategoryController {

    @Inject
    lateinit var cs: CategoryService
    @POST
    fun addCategory(category: Category) = cs.addCategory(category)
    @GET
    fun getAllCategory() = cs.getAllCategories()
}
