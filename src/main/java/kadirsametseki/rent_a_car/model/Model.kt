package kadirsametseki.rent_a_car.model

import jakarta.persistence.*

@Entity
data class Model(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    val brand: Brand,

    @OneToMany(mappedBy = "model", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val cars: List<Car> = mutableListOf()
)