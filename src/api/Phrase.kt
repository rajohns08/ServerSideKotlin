package com.raywenderlich.emojis.api

import com.raywenderlich.emojis.*
import com.raywenderlich.emojis.model.*
import com.raywenderlich.emojis.repository.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

const val PHRASE_ENDPOINT = "$API_VERSION/phrase"

fun Route.phrase(db: Repository) {
    post(PHRASE_ENDPOINT) {
        val request = call.receive<Request>()
        val phrase = db.add(EmojiPhrase(request.emoji, request.phrase))
        call.respond(phrase)
    }
}
