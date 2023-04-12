package vlad110kg.bot.msg;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vlad110kg.bot.cmd.CommandTranslator;
import vlad110kg.bot.msg.handler.common.HelpMessageHandler;
import vlad110kg.bot.msg.handler.common.SettingsCommonMessageHandler;
import vlad110kg.bot.msg.template.ButtonNames;
import vlad110kg.bot.msg.template.MessageTemplateContext;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MessageToCommandTranslator implements CommandTranslator {

    private final Map<String, String> msg2cmd = new HashMap<>();

    private final MessageTemplateContext t;

    @PostConstruct
    public void initContainer() {
        LangUtils.SUPPORTED.forEach(l -> {
            msg2cmd.put(t.processTemplate(ButtonNames.HELP), HelpMessageHandler.HELP);
            msg2cmd.put(
                t.processTemplate(ButtonNames.SETTINGS),
                SettingsCommonMessageHandler.SETTINGS
            );
            }
        );
    }

    @Override
    public String translate(String text) {
        return msg2cmd.get(text);
    }
}
