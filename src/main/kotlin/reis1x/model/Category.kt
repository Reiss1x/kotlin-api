package reis1x.model;

import jakarta.persistence.*


@Entity
@Table(name = "category")
class Category() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?=null
    lateinit var name:String

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    var products: MutableList<Product> = ArrayList()
}