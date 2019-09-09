package com.rest.api.business.persona

import com.rest.api.exception.BusinessException
import com.rest.api.exception.NotFoundException
import com.rest.api.dao.PersonaRepository
import com.rest.api.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

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

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>
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

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idPersona: Long) {
        val op: Optional<Persona>

        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent){
            throw NotFoundException("No se encuentra la persona con id=$idPersona")
        }else{
            try {
                personaRepository!!.deleteById(idPersona)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun findByNombre(nombre: String): List<Persona> {
        val op: Optional<List<Persona>>

        try{
            op = personaRepository!!.findByNombreIgnoreCase(nombre)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encuentra la persona con el nombre = $nombre")
        }

        return op.get()
    }
}