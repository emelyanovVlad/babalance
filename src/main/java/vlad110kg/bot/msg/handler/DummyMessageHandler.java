package vlad110kg.bot.msg.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import vlad110kg.bot.cmd.ChatCommand;

@Component
public class DummyMessageHandler implements IDefaultMessageHandler {

    @Override
    public BotApiMethod<Message> handle(ChatCommand cc) {
        return null;
    }

    @Override
    public String trigger() {
        return null;
    }
}
