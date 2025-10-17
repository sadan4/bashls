package zip.sadan.bashls.bash.lexer

enum class Context {
    ARITHMETIC,
    QUOTE,
    SLASH,
    TEST,
    VAR_EXPANSION;
}