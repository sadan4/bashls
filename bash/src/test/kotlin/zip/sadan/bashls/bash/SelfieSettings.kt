package zip.sadan.bashls.bash

import com.diffplug.selfie.kotest.SelfieSettingsAPI
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import zip.sadan.bashls.bash.lexer.Lexer
import zip.sadan.bashls.bash.lexer.tokens.Token

object SelfieSettings : SelfieSettingsAPI() {
    @PublishedApi
    internal val json = Json {
        prettyPrint = true
        @OptIn(ExperimentalSerializationApi::class)
        prettyPrintIndent = "  "
    }

    @PublishedApi
    internal suspend inline fun <reified T> expectSelfieInternal(obj: T) =
        com.diffplug.selfie.coroutines.expectSelfie(json.encodeToString(obj))
    suspend inline fun expectSelfie(a: List<Token>) = expectSelfieInternal(a)
    suspend inline fun expectSelfie(a: String) = com.diffplug.selfie.coroutines.expectSelfie(a)
    suspend inline fun expectSelfie(a: Token) = expectSelfieInternal(a)
    suspend inline fun expectSelfie(a: Lexer) = expectSelfie(a.lex())
    suspend inline fun expectLexResult(code: String) = expectSelfie(Lexer(code))
}