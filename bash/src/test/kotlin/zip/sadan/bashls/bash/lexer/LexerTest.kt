package zip.sadan.bashls.bash.lexer

import io.kotest.core.spec.style.DescribeSpec
import zip.sadan.bashls.bash.lexer.SelfieSettings.expectLexResult
import zip.sadan.bashls.bash.lexer.SelfieSettings.expectSelfie

class LexerTest : DescribeSpec({

    describe("plain commands") {
        it("`foo`") {
            expectLexResult("foo").toMatchDisk()
        }
        it("`cmd arg1 arg2`") {
            expectLexResult("cmd arg1 arg2").toMatchDisk_TODO()
        }
    }
})
