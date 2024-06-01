package lox.syntax_tree;

import lox.parser.Token;

public abstract class Exprbck {
    static class Binary extends Exprbck {
        final Exprbck left;
        final Token operator;
        final Exprbck right;

        Binary(Exprbck left, Token operator, Exprbck right){
            this.left = left;
            this.operator = operator;
            this.right = right;
        }
    }
}
