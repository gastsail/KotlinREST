package com.rest.api

import com.rest.api.dao.PersonaRepository
import com.rest.api.dao.TituloRepository
import com.rest.api.model.Persona
import com.rest.api.model.Titulo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class ApiApplication : CommandLineRunner {

    @Autowired
    val personaRepository: PersonaRepository? = null

    @Autowired
    val tituloRepository: TituloRepository? = null

    override fun run(vararg args: String?) {

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val persona1 = Persona(38732588, "Gaston",
                "Saillen", LocalDate.parse("29-05-1995", formatter))
        val persona2 = Persona(25608394, "John",
                "Doe", LocalDate.parse("21-03-1990", formatter))

        personaRepository!!.save(persona1)
        personaRepository!!.save(persona2)

        val titulo1 = Titulo("Ingeniero en informatica")
        val titulo2 = Titulo("Ingeniero aeronautico")

        tituloRepository!!.save(titulo1)
        tituloRepository!!.save(titulo2)

    }
}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}










