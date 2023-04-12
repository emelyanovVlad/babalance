package vlad110kg.bot.cmd;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChatCommandParserTest {

    @Test
    void When_ParsingTextWithHash_Then_ReturnsHashAndText() {
        // Arrange
        var inputText = "#test";
        var user = new User();
        var chatId = 12345L;

        // Act
        var result = ChatCommandParser.parse(inputText, chatId, user);

        // Assert
        assertEquals("#", result.getTrigger());
        assertEquals("test", result.getKey());
    }

    @Test
    void When_ParsingTextWithSlashAndOneWord_Then_ReturnsSlashAndText() {
        // Arrange
        var inputText = "/test";
        var user = new User();
        var chatId = 12345L;

        // Act
        var result = ChatCommandParser.parse(inputText, chatId, user);

        // Assert
        assertEquals("/test", result.getTrigger());
        assertEquals("", result.getKey());
    }

    @Test
    void When_ParsingTextWithSlashAndMultipleWords_Then_ReturnsSlashAndJoinedWords() {
        // Arrange
        var inputText = "/test_one_two_three";
        var user = new User();
        var chatId = 12345L;

        // Act
        var result = ChatCommandParser.parse(inputText, chatId, user);

        // Assert
        assertEquals("/test", result.getTrigger());
        assertEquals("onetwothree", result.getKey());
    }

    @Test
    void When_ParsingTextWithNoSpecialCharacter_Then_ReturnsTextAsKeyAndData() {
        // Arrange
        var inputText = "test";
        var user = new User();
        var chatId = 12345L;

        // Act
        var result = ChatCommandParser.parse(inputText, chatId, user);

        // Assert
        assertEquals("test", result.getTrigger());
        assertEquals("test", result.getKey());
    }
}
