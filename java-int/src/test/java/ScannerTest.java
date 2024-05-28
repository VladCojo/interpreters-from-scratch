import lox.*
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class ScannerTest {
    @Test
    public void testScanTokensWithEmptyInput() {
        Scanner scanner = new Scanner("");
        List<Token> tokens = scanner.scanTokens();
        List<Token> expectedTokens = List.of(new Token(TokenType.EOF, "", null, 1));
        assertEquals(expectedTokens, tokens);
    }

    @Test
    public void testScanTokensWithSingleCharacter() {
        Scanner scanner = new Scanner("(");
        List<Token> tokens = scanner.scanTokens();
        List<Token> expectedTokens = List.of(
            new Token(TokenType.LEFT_PAREN, "(", null, 1),
            new Token(TokenType.EOF, "", null, 1)
        );
        assertEquals(expectedTokens, tokens);
    }

    @Test
    public void testScanTokensWithKeyword() {
        Scanner scanner = new Scanner("class");
        List<Token> tokens = scanner.scanTokens();
        List<Token> expectedTokens = List.of(
            new Token(TokenType.CLASS, "class", null, 1),
            new Token(TokenType.EOF, "", null, 1)
        );
        assertEquals(expectedTokens, tokens);
    }

    @Test
    public void testScanTokensWithNumber() {
        Scanner scanner = new Scanner("123");
        List<Token> tokens = scanner.scanTokens();
        List<Token> expectedTokens = List.of(
            new Token(TokenType.NUMBER, "123", 123.0, 1),
            new Token(TokenType.EOF, "", null, 1)
        );
        assertEquals(expectedTokens, tokens);
    }

    @Test
    public void testScanTokensWithString() {
        Scanner scanner = new Scanner("\"hello\"");
        List<Token> tokens = scanner.scanTokens();
        List<Token> expectedTokens = List.of(
            new Token(TokenType.STRING, "\"hello\"", "hello", 1),
            new Token(TokenType.EOF, "", null, 1)
        );
        assertEquals(expectedTokens, tokens);
    }
}