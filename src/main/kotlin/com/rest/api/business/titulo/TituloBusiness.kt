package com.rest.api.business.titulo

import com.rest.api.dao.TituloRepository
import com.rest.api.exception.BusinessException
import com.rest.api.exception.NotFoundException
import com.rest.api.model.Titulo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TituloBusiness : ITituloBusiness {

    @Autowired
    val tituloRepository: TituloRepository? = null

    override fun list(): MutableList<Titulo>? {
        try {
            return tituloRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idTitulo: Long): Titulo {
        val op: Optional<Titulo>?
        try {
            op = tituloRepository!!.findById(idTitulo)
        } catch (e: Exception) {
            throw NotFoundException(e.message)
        }

        if (!op.isPresent) {
            throw BusinessException("No se encontro el titulo con id = $idTitulo")
        }

        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(titulo: Titulo): Titulo {
        try {
            return tituloRepository!!.save(titulo)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idTitulo: Long) {
        val op:Optional<Titulo>

        try {
            op = tituloRepository!!.findById(idTitulo)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontro el titulo con id $idTitulo")
        }else{
            try {
                tituloRepository!!.deleteById(idTitulo)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }
}