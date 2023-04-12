package vlad110kg.bot.msg.handler.common;

import lombok.RequiredArgsConstructor;
import vlad110kg.bot.msg.button.MenuKeyboardBuilder;
import vlad110kg.bot.cmd.ChatCommand;
import vlad110kg.bot.msg.SendMessageBuilder;
import vlad110kg.bot.msg.handler.MessageHandler;
import vlad110kg.bot.msg.template.MessageTemplateContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import vlad110kg.core.entity.Client;
import vlad110kg.core.service.IClientService;

import static vlad110kg.bot.msg.template.TemplateNames.WELCOME;

@Component
@Slf4j
@RequiredArgsConstructor
public class WelcomeMessageHandler implements MessageHandler {

    private final MessageTemplateContext templateContext;
    private final IClientService clientService;
    private final MenuKeyboardBuilder menuKeyboardBuilder;

    @Override
    public BotApiMethod<Message> handle(ChatCommand cc) {
        var reader = clientService.create(new Client(cc.getChatId()));
        log.info("New reader: {}", reader);
        var text = templateContext.processTemplate(WELCOME);
        return new SendMessageBuilder(cc.getChatId(), text)
            .replyMarkup(menuKeyboardBuilder.getMenu().build())
            .enableHtml()
            .build();
    }

    @Override
    public String trigger() {
        return "/start";
    }
}
