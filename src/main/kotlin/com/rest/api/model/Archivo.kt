package com.rest.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
@Table(name="archivos")
data class Archivo(@Column(length = 300,nullable = false)
                   val nombre:String = "",
                   val length: Long = 0,
                   val fecha:Date? = null,
                   @Column(length = 50)
                   val mime:String = "",
                   @JsonIgnore
                   @Lob
                   val contenido: ByteArray? = null) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Archivo

        if (nombre != other.nombre) return false
        if (length != other.length) return false
        if (fecha != other.fecha) return false
        if (mime != other.mime) return false
        if (!Arrays.equals(contenido, other.contenido)) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + length.hashCode()
        result = 31 * result + (fecha?.hashCode() ?: 0)
        result = 31 * result + mime.hashCode()
        result = 31 * result + (contenido?.let { Arrays.hashCode(it) } ?: 0)
        result = 31 * result + id.hashCode()
        return result
    }
}