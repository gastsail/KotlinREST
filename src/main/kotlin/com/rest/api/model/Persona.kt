package com.rest.api.model

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "personas")
data class Persona(val dni: Long = 0, val nombre: String = "",
                   val apellido: String = "",
                   val fechaNac: LocalDate? = null) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    var id:Long = 0

}