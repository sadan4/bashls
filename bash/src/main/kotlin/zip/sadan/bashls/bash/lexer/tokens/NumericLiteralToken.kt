package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.LiteralToken

class NumericLiteralToken(pos: Range, contents: String) : LiteralToken(pos, contents)