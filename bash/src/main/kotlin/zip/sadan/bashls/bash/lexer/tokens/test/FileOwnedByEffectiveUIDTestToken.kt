package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -O /file ]
 * ```
 */
class FileOwnedByEffectiveUIDTestToken(override val pos: Range) : TestToken {
}

