package vlad110kg.bot.msg.handler.common;

import vlad110kg.bot.cmd.CallbackCommand;
import vlad110kg.bot.cmd.ChatCommand;
import vlad110kg.bot.cmd.CommandType;
import vlad110kg.bot.msg.SendMessageBuilder;
import vlad110kg.bot.msg.handler.MessageHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class SettingsCommonMessageHandler implements MessageHandler {

    public static final String SETTINGS = "/settings";

    @Override
    public BotApiMethod<Message> handle(ChatCommand cc) {
        CallbackCommand callbackCmd = CallbackCommand.of(CommandType.SETTINGS);
        callbackCmd.setChatId(cc.getChatId());

        return new SendMessageBuilder(cc.getChatId(), "Settings")
            .enableHtml()
            .build();
    }

    @Override
    public String trigger() {
        return SETTINGS;
    }

}
