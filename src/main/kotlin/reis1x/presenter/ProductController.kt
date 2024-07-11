package reis1x.presenter

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import reis1x.model.ProdRequestDTO
import reis1x.model.Product
import reis1x.repo.ProductRepo
import reis1x.services.ProductService
import java.util.ArrayList


@Path("/prod")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ProductController {
    @Inject
    lateinit var ps: ProductService
    @POST
    fun addProduct(proddto: ProdRequestDTO) = ps.createProduct(proddto)
    @GET
    @Path("/getProd/{name}")
    fun getProdByName(@PathParam("name") name: String) = ps.getByName(name)


    @GET
    fun getAllProd() = ps.listProducts()

}