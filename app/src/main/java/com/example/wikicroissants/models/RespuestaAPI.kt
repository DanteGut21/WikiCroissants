package com.example.wikicroissants.models

data class RespuestaEstante(
    val data: List<Estante>,
    val total: Int
)

data class RespuestaLibro(
    val books: List<Libros>
)

data class RespuestaCapitulo(
    val data: List<Capitulos>,
    val total: Int
)