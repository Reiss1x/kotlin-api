package reis1x.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*

@Entity(name = "product")
class Product(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var prices: Double? = null
    lateinit var name: String
    lateinit var description: String

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var categories: MutableList<Category> = ArrayList()
}