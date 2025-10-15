package zip.sadan.bashls.bash.lexer

import com.diffplug.selfie.coroutines.expectSelfie as ExpectSelfie
import com.diffplug.selfie.kotest.SelfieSettingsAPI
import kotlinx.serialization.json.Json
import zip.sadan.bashls.bash.lexer.tokens.Token

object SelfieSettings : SelfieSettingsAPI() {
    @PublishedApi
    internal suspend inline fun <reified T> expectSelfieInternal(obj: T) = ExpectSelfie(Json.encodeToString(obj))
    suspend inline fun expectSelfie(a: List<Token>) = expectSelfieInternal(a)
    suspend inline fun expectSelfie(a: String) = ExpectSelfie(a)
    suspend inline fun expectSelfie(a: Token) = expectSelfieInternal(a)
    suspend inline fun expectSelfie(a: Lexer) = expectSelfie(a.lex())
    suspend inline fun expectLexResult(code: String) = expectSelfie(Lexer(code))
}
