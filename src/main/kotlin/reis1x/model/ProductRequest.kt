package reis1x.model

data class ProductRequest(
    val prices: Double,
    val name: String,
    val categories: List<CategoryDTO>
)