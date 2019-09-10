package com.rest.api.business.persona

import com.rest.api.exception.BusinessException
import com.rest.api.exception.NotFoundException
import com.rest.api.model.Archivo

interface IArchivoBusiness {

    @Throws(BusinessException::class,NotFoundException::class)
    fun load(id:Long): Archivo

    @Throws(BusinessException::class)
    fun save(archivo:Archivo): Archivo

    @Throws(BusinessException::class,NotFoundException::class)
    fun delete(id:Long)

    @Throws(BusinessException::class)
    fun list():List<Archivo>
}