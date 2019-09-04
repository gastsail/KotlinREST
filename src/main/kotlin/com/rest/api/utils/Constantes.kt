package com.rest.api.utils

class Constantes{

    companion object {
        private const val URL_API_BASE = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION
        //Base API endpoint para personas
        const val URL_BASE_PERSONAS = "$URL_BASE/personas"
        //Base API endpoint para titulos
        const val URL_BASE_TITULOS = "$URL_BASE/titulos"

    }

}