package com.rest.api.business

import com.rest.api.dao.PersonaRepository
import com.rest.api.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import org.springframework.util.ClassUtils.isPresent

@Service
class PersonaBusiness: IPersonaBusiness {

    @Autowired
    val personaRepository : PersonaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): MutableList<Persona>? {
        try {
            return personaRepository!!.findAll()
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>?
        try {
            op = personaRepository!!.findById(idPersona)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encuentra la persona con id =" + idPersona);
        }

        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(persona: Persona): Persona {
        try {
            return personaRepository!!.save(persona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun remove(idPersona: Long) {
        val op: Optional<Persona>?

        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }


        if (!op.isPresent)
            throw NotFoundException("No se encuentra la persona con id=$idPersona")
        try {
            personaRepository!!.deleteById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

    }
}