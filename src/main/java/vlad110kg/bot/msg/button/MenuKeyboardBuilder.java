package vlad110kg.bot.msg.button;

import lombok.RequiredArgsConstructor;
import vlad110kg.bot.msg.template.ButtonNames;
import org.springframework.stereotype.Component;
import vlad110kg.bot.msg.template.MessageTemplateContext;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuKeyboardBuilder {

    private final MessageTemplateContext templateContext;

    public ReplyMarkupBuilder getMenu() {
        ReplyMarkupBuilder replyMarkup = new ReplyMarkupBuilder();
        var helpText = templateContext.processTemplate(ButtonNames.HELP);
        var tags = templateContext.processTemplate(ButtonNames.TAGS);
        var settings = templateContext.processTemplate(ButtonNames.SETTINGS);
        replyMarkup.addButtons(List.of(tags, settings));
        replyMarkup.addButtons(List.of(helpText));
        return replyMarkup;
    }
}
