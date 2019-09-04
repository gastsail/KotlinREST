package com.rest.api.web

import com.rest.api.business.titulo.ITituloBusiness
import com.rest.api.exception.BusinessException
import com.rest.api.exception.NotFoundException
import com.rest.api.model.Titulo
import com.rest.api.utils.Constantes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constantes.URL_BASE_TITULOS)
class TituloRestController {

    @Autowired
    val tituloBusiness: ITituloBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Titulo>> {
        return try {
            ResponseEntity(tituloBusiness!!.list(), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idTitulo: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(tituloBusiness!!.load(idTitulo), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody titulo: Titulo): ResponseEntity<Any> {
        return try {
            tituloBusiness!!.save(titulo)
            val responseHeaders = HttpHeaders()
            responseHeaders.set("location", Constantes.URL_BASE_PERSONAS + "/" + titulo.id)
            ResponseEntity(responseHeaders, HttpStatus.CREATED)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @PutMapping("")
    fun update(@RequestBody titulo: Titulo): ResponseEntity<Any> {
        return try {
            tituloBusiness!!.save(titulo)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idTitulo: Long): ResponseEntity<Any> {
        return try {
            tituloBusiness!!.remove(idTitulo)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }
}