package com.rest.api.dao

import com.rest.api.model.Archivo
import com.rest.api.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface ArchivoRepository:JpaRepository<Archivo, Long>  {

}