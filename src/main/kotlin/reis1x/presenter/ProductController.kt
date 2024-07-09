package reis1x.presenter

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import reis1x.model.Product
import java.util.ArrayList


@Path("/prod")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ProductController {

    private val prodList: ArrayList<Product> = ArrayList();

    @POST
    fun addProduct(product: Product): Product {
        prodList.add(product)
        return product;
    }

    @GET
    @Path("/{name}")
    fun getProdByName(@PathParam("name") name: String) : Product? {
        println(prodList)
        val prod:Product? = prodList.find{it.name == name};
        return prod;
    }
    @GET
    fun getAllProd() : ArrayList<Product> {
        return prodList;
    }
}