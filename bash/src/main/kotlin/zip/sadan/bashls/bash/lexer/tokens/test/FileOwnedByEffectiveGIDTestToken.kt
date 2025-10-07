package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -G /file ]
 * ```
 */
class FileOwnedByEffectiveGIDTestToken(override val pos: Range) : TestToken {
}

