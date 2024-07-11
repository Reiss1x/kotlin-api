package reis1x.model

data class ProdRequestDTO(
    val prices: Double,
    val name: String,
    val description: String,
    val categories: List<String>
) {
}