package vlad110kg.bot.msg.handler;


import vlad110kg.bot.EntityType;

public interface EntityCallbackMessageHandler extends CallbackMessageHandler {

    EntityType entityType();
}
