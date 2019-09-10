package com.rest.api.business.persona

import com.rest.api.dao.ArchivoRepository
import com.rest.api.exception.BusinessException
import com.rest.api.exception.NotFoundException
import com.rest.api.model.Archivo
import com.rest.api.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArchivoBusiness: IArchivoBusiness {

    @Autowired
    val archivoRepository : ArchivoRepository? = null

    override fun load(id: Long): Archivo {
        val op: Optional<Archivo>
        try {
            op = archivoRepository!!.findById(id)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encuentra el archivo con id =$id")
        }

        return op.get()
    }

    override fun save(archivo: Archivo): Archivo {
        try {
            return archivoRepository!!.save(archivo)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun delete(id: Long) {
        val op: Optional<Archivo>

        try {
            op = archivoRepository!!.findById(id)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent){
            throw NotFoundException("No se encuentra el archivo con id=$id")
        }else{
            try {
                archivoRepository!!.deleteById(id)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }

    override fun list(): List<Archivo> {
        try {
            return archivoRepository!!.findAll()
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }
}