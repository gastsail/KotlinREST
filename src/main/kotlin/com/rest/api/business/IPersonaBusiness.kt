package com.rest.api.business

import com.rest.api.model.Persona

interface IPersonaBusiness {

    fun list(): MutableList<Persona>?
    fun load(idPersona:Long): Persona
    fun save(persona: Persona): Persona
    fun remove(idPersona: Long)
}