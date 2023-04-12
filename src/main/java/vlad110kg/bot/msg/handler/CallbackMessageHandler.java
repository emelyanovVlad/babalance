package vlad110kg.bot.msg.handler;

import vlad110kg.bot.cmd.CallbackCommand;
import vlad110kg.bot.cmd.CommandType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface CallbackMessageHandler {

    HandleResult handle(CallbackCommand command);

    CommandType commandType();

    @Getter
    @AllArgsConstructor
    class HandleResult {

        private final String text;
        private final InlineKeyboardMarkup inline;
        private final boolean previewPage;

        public HandleResult() {
            this.text = null;
            this.inline = null;
            this.previewPage = true;
        }

        public HandleResult(String text, InlineKeyboardMarkup inline) {
            this.text = text;
            this.inline = inline;
            this.previewPage = true;
        }
    }
}
