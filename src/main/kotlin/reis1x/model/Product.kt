package reis1x.model

class Product(val id: Long? = null,
              val name: String? = null,
              val prices: Double? = null,
              val description: String? = null) {

    override fun toString(): String {
        return "Product(id=$id, name=$name, prices=$prices, description=$description)"
    }
}