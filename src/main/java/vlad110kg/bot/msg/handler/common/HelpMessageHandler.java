package vlad110kg.bot.msg.handler.common;

import lombok.RequiredArgsConstructor;
import vlad110kg.bot.msg.button.MenuKeyboardBuilder;
import vlad110kg.bot.msg.template.TemplateNames;
import vlad110kg.bot.cmd.ChatCommand;
import vlad110kg.bot.msg.SendMessageBuilder;
import vlad110kg.bot.msg.handler.MessageHandler;
import vlad110kg.bot.msg.template.MessageTemplateContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import vlad110kg.core.service.IClientService;

@Component
@RequiredArgsConstructor
public class HelpMessageHandler implements MessageHandler {

    public static final String HELP = "/help";

    private final MessageTemplateContext templateContext;
    private final MenuKeyboardBuilder menuKeyboardBuilder;
    private final IClientService readerService;

    @Override
    public BotApiMethod<Message> handle(ChatCommand cc) {
        var reader = readerService.get(cc.getChatId()).orElseThrow();
        var text = templateContext.processTemplate(TemplateNames.HELP);
        return new SendMessageBuilder(cc.getChatId(), text)
            .replyMarkup(menuKeyboardBuilder.getMenu().build())
            .build();
    }

    @Override
    public String trigger() {
        return HELP;
    }
}
