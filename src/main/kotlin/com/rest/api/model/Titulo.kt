package com.rest.api.model

import javax.persistence.*

@Entity
@Table(name = "titulos")
data class Titulo(val titulo:String = "") {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0

}