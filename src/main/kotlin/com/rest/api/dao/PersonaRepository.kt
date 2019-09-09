package com.rest.api.dao

import com.rest.api.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonaRepository: JpaRepository<Persona,Long> {

    fun findByNombre(nombre:String): Optional<List<Persona>>
}