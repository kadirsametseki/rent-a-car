package kadirsametseki.rent_a_car.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val modelYear: Int?,
    val plate: String?,
    @Enumerated(EnumType.STRING)
    val state: StateType?,
    val dailyPrice: BigDecimal?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    val model: Model
) /*{
    constructor(modelYear: Int, plate: String, dailyPrice: BigDecimal, model: Model) : this(
        id = null,
        modelYear = modelYear,
        plate = plate,
        state = StateType.AVAILABLE,
        dailyPrice = dailyPrice,
        model = model
    )
}*/

enum class StateType {
    AVAILABLE,
    RENTED,
    MAINTENANCE
}