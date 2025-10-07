package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * foo1=bar
 * foo2=baz
 * echo ${!foo@}   # Output: foo1 foo2
 * ```
 *
 * ```bash
 * arr=(a b c)
 * echo "${arr[@]}"      # Output: a b c
 * ```
 *
 * ```bash
 * for arg in "$@"; do
 *   echo "$arg"
 * done
 * ```
 */
class AtToken(override val pos: Range) : Token {
}