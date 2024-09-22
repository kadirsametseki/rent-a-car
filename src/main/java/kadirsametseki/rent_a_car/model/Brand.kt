package kadirsametseki.rent_a_car.model

import jakarta.persistence.*

@Entity
data class Brand(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String?,

    @OneToMany(mappedBy = "brand", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val models: List<Model> = mutableListOf()


) /*{
    constructor(name: String) : this(null, name)
}*/