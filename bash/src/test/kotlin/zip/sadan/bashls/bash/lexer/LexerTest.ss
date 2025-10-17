╔═ `cmd arg1 arg2` ═╗
[
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 0,
      "length": 3
    },
    "contents": "cmd"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 3,
      "length": 1
    },
    "contents": " "
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 4,
      "length": 4
    },
    "contents": "arg1"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 8,
      "length": 1
    },
    "contents": " "
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 9,
      "length": 4
    },
    "contents": "arg2"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.EofToken",
    "pos": {
      "start": 13,
      "length": 0
    },
    "contents": ""
  }
]
╔═ `echo "foo bar"` ═╗
[
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 0,
      "length": 3
    },
    "contents": "cmd"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 3,
      "length": 1
    },
    "contents": " "
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.DoubleQuoteToken",
    "pos": {
      "start": 4,
      "length": 1
    },
    "contents": "\""
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 5,
      "length": 3
    },
    "contents": "foo"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 8,
      "length": 1
    },
    "contents": " "
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 9,
      "length": 3
    },
    "contents": "bar"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.DoubleQuoteToken",
    "pos": {
      "start": 12,
      "length": 1
    },
    "contents": "\""
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.EofToken",
    "pos": {
      "start": 13,
      "length": 0
    },
    "contents": ""
  }
]
╔═ `foo` ═╗
[
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 0,
      "length": 3
    },
    "contents": "foo"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.EofToken",
    "pos": {
      "start": 3,
      "length": 0
    },
    "contents": ""
  }
]
╔═ `ls -alh` ═╗
[
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 0,
      "length": 2
    },
    "contents": "ls"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 2,
      "length": 1
    },
    "contents": " "
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.MinusToken",
    "pos": {
      "start": 3,
      "length": 1
    },
    "contents": "-"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 4,
      "length": 3
    },
    "contents": "alh"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.EofToken",
    "pos": {
      "start": 7,
      "length": 0
    },
    "contents": ""
  }
]
╔═ handles more than one line ═╗
[
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 0,
      "length": 3
    },
    "contents": "foo"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 3,
      "length": 1
    },
    "contents": "\n"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 4,
      "length": 3
    },
    "contents": "bar"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.EofToken",
    "pos": {
      "start": 7,
      "length": 0
    },
    "contents": ""
  }
]
╔═ handles more than one line 2 ═╗
[
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 0,
      "length": 3
    },
    "contents": "foo"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 3,
      "length": 1
    },
    "contents": " "
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.DoubleQuoteToken",
    "pos": {
      "start": 4,
      "length": 1
    },
    "contents": "\""
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 5,
      "length": 6
    },
    "contents": "quoted"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.DoubleQuoteToken",
    "pos": {
      "start": 11,
      "length": 1
    },
    "contents": "\""
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 12,
      "length": 1
    },
    "contents": "\n"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 13,
      "length": 3
    },
    "contents": "bar"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 16,
      "length": 1
    },
    "contents": " "
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.DoubleQuoteToken",
    "pos": {
      "start": 17,
      "length": 1
    },
    "contents": "\""
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 18,
      "length": 6
    },
    "contents": "quoted"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.DoubleQuoteToken",
    "pos": {
      "start": 24,
      "length": 1
    },
    "contents": "\""
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken",
    "pos": {
      "start": 25,
      "length": 1
    },
    "contents": " "
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.LiteralToken",
    "pos": {
      "start": 26,
      "length": 3
    },
    "contents": "guh"
  },
  {
    "type": "zip.sadan.bashls.bash.lexer.tokens.EofToken",
    "pos": {
      "start": 29,
      "length": 0
    },
    "contents": ""
  }
]
╔═ [end of file] ═╗
