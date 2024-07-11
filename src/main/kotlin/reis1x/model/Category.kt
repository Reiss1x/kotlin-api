package reis1x.model;

import jakarta.persistence.*


@Entity
class Category() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?=null
    lateinit var name:String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product: Product? = null
}