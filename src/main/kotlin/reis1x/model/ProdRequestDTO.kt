package reis1x.model

data class ProdRequestDTO(
    val prices: Double,
    val name: String,
    val categories: List<CategoryDTO>
)