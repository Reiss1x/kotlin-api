package reis1x.presenter

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import reis1x.model.ProductRequest
import reis1x.services.ProductService


@Path("/prod")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ProductController {
    @Inject
    lateinit var ps: ProductService
    @POST
    fun addProduct(proddto: ProductRequest) = ps.createProduct(proddto)
    @GET
    @Path("/{name}")
    fun getProdByName(@PathParam("name") name: String) = ps.getByName(name)
    @GET
    @Path("categories/{name}")
    fun getProductsByCat(@PathParam("name") category: String) = ps.listProductsByCategory(category)
    @GET
    fun getAllProd() = ps.listProducts()

}