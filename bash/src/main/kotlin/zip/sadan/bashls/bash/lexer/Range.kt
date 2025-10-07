package zip.sadan.bashls.bash.lexer

data class Range(val start: Int, val length: Int) {
    val end = start + length
}