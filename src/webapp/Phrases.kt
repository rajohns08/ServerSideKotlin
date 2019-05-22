package com.raywenderlich.emojis.webapp

import com.raywenderlich.emojis.repository.*
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*

const val PHRASES = "/phrases"

fun Route.phrases(db: Repository) {
    get(PHRASES) {
        val phrases = db.phrases()
        call.respond(FreeMarkerContent("phrases.ftl", mapOf("phrases" to phrases)))
    }
}