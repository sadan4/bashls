package zip.sadan.bashls.bash.lexer

import io.kotest.core.spec.style.DescribeSpec
import kotlinx.serialization.Serializable
import zip.sadan.bashls.bash.SelfieSettings.expectLexResult
import zip.sadan.bashls.bash.SelfieSettings.expectSelfie


class LexerTest : DescribeSpec({

    describe("plain commands") {
        it("`foo`") {
            expectLexResult("foo").toMatchDisk()
        }
        it("`cmd arg1 arg2`") {
            expectLexResult("cmd arg1 arg2").toMatchDisk()
        }
        it("`ls -alh`") {
            expectLexResult("ls -alh").toMatchDisk()
        }
        it("`echo \"foo bar\"`") {
            expectLexResult("cmd \"foo bar\"").toMatchDisk_TODO()
        }
    }
})
