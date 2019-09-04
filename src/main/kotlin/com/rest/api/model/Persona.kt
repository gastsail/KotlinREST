package com.rest.api.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "personas")
data class Persona(val dni: Long = 0, val nombre: String = "",
                   val apellido: String = "",
                   val fechaNac: Date? = null) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0

}