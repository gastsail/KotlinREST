package com.rest.api.business.titulo

import com.rest.api.model.Titulo

interface ITituloBusiness {

    fun list(): MutableList<Titulo>?
    fun load(idTitulo:Long): Titulo
    fun save(titulo: Titulo): Titulo
    fun remove(idTitulo: Long)
}