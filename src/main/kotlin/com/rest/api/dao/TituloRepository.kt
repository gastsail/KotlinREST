package com.rest.api.dao

import com.rest.api.model.Titulo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TituloRepository: JpaRepository<Titulo,Long>