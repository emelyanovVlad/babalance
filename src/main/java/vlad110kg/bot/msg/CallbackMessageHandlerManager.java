package vlad110kg.bot.msg;

import org.springframework.stereotype.Component;
import vlad110kg.bot.EntityType;
import vlad110kg.bot.cmd.CallbackCommand;
import vlad110kg.bot.cmd.CommandType;
import vlad110kg.bot.msg.handler.CallbackMessageHandler;
import vlad110kg.bot.msg.handler.EntityCallbackMessageHandler;
import vlad110kg.bot.msg.handler.UtilMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CallbackMessageHandlerManager {

    private final Map<CommandType, Function<EntityType, CallbackMessageHandler>> functionContainer;
    private final Map<CommandType, UtilMessageHandler> utilHandlers;

    public CallbackMessageHandlerManager(
        List<EntityCallbackMessageHandler> entityMessageHandlers,
        List<UtilMessageHandler> utilMessageHandler
    ) {
        Map<CommandType, Function<EntityType, CallbackMessageHandler>> functionBuilder = new HashMap<>();
        entityMessageHandlers.stream()
            .collect(Collectors.groupingBy(
                EntityCallbackMessageHandler::commandType,
                Collectors.toMap(EntityCallbackMessageHandler::entityType, Function.identity())
            )).forEach((type, handler) -> functionBuilder.put(type, handler::get));
        this.functionContainer = functionBuilder;

        this.utilHandlers = utilMessageHandler.stream()
            .collect(Collectors.toMap(UtilMessageHandler::commandType, Function.identity()));
    }

    public BotApiMethod<Serializable> manageCallback(Message message, String data) {
        var txt = new StringBuilder();
        CallbackMessageHandler.HandleResult handleResult = null;
        for (String cc : data.split(";")) {
            handleResult = handleCallback(message.getChatId(), cc);
            if (handleResult != null && handleResult.getText() != null) {
                txt.append("\n").append(handleResult.getText());
            }
        }
        if (handleResult == null) {
            return null;
        }
        var msg = EditMessageText.builder()
            .chatId(String.valueOf(message.getChatId()))
            .messageId(message.getMessageId())
            .text(txt.toString())
            .disableWebPagePreview(!handleResult.isPreviewPage())
            .replyMarkup(handleResult.getInline())
            .build();
        msg.enableHtml(true);
        return msg;
    }

    private CallbackMessageHandler.HandleResult handleCallback(long chatId, String data) {
        var cc = CallbackCommand.fromText(data);
        cc.setChatId(chatId);
        if (CommandType.UTIL.contains(cc.getCommandType())) {
            return utilHandlers.get(cc.getCommandType()).handle(cc);
        }
        return functionContainer.get(cc.getCommandType()).apply(cc.getEntityType()).handle(cc);
    }

}
