package reis1x.model

data class ProductResponse(
    val id: Long,
    val prices: Double,
    val name: String,
    val categories: List<CategoryDTO>
)