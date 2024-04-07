package com.example.wikicroissants.models

data class RespuestaAPI(
    val data: List<Estante>,
    val total: Int
)

data class RespuestaLibro(
    val data: List<Libros>,
    val total: Int
)

data class RespuestaCapitulo(
    val data: List<Capitulos>,
    val total: Int
)

