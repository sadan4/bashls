package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * str="abcdef"
 * echo "${str:2:3}"  # Output: cde
 * ```
 *
 * ```bash
 * # noop
 * :
 * echo $?
 * # 0
 * ```
 */
class ColonToken(override val pos: Range): Token() {
    override val contents: String = ":"
}