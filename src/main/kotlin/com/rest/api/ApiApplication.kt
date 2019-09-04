package com.rest.api

import com.rest.api.dao.PersonaRepository
import com.rest.api.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class ApiApplication : CommandLineRunner {

    @Autowired
    val personaRepository: PersonaRepository? = null

    override fun run(vararg args: String?) {
        val persona1 = Persona(38732588, "Gaston",
                "Saillen", Date(1995,5,29))
        val persona2 = Persona(25608394, "John",
                "Doe", Date(1990,3,4))

        personaRepository!!.save(persona1)
        personaRepository!!.save(persona2)
    }
}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}










