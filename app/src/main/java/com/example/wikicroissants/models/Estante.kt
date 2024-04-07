package com.example.wikicroissants.models;

data class Estante(
    val id: Int,
    val name: String, // Asume que esto debería ser "titulo" en tu clase
    val slug: String,
    val description: String,
    // Incluye las demás propiedades según sean necesarias
)