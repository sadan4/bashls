package zip.sadan.bashls.bash.lexer

import com.diffplug.selfie.Selfie
import com.diffplug.selfie.kotest.SelfieSettingsAPI
import kotlinx.serialization.json.Json
import zip.sadan.bashls.bash.lexer.tokens.Token

object SelfieSettings : SelfieSettingsAPI() {
    private inline fun <reified T> expectSelfieInternal(obj: T) = Selfie.expectSelfie(Json.encodeToString(obj))
    fun expectSelfie(a: List<Token>) = expectSelfieInternal(a)
    fun expectSelfie(a: String) = Selfie.expectSelfie(a)
    fun expectSelfie(a: Token) = expectSelfieInternal(a)
    fun expectSelfie(a: Lexer) = expectSelfie(a.lex())
}
