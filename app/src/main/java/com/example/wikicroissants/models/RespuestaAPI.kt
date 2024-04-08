package com.example.wikicroissants.models

data class RespuestaEstante(
    val data: List<Estante>,
    val total: Int
)

data class RespuestaLibro(
    val books: List<Libros>
)

data class RespuestaCapitulo(
    val contents: List<Capitulos>,

    )

data class RespuestaPagina(
    val data: List<Pagina>
)