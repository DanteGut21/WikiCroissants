package com.example.wikicroissants.models

import com.example.wikicroissants.Pagina

data class Pagina(
    val id: Int,
    val book_id: Int,
    val chapter_id: Int,
    val name: String,
    val slug: String,
    val html: String,
    val raw_html: String

)