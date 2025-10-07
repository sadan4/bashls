package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** |& Pipes stdout and stderr to stdin */
class PipeErrToken(override val pos: Range) : Token
