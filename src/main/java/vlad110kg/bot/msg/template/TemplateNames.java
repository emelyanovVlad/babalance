package vlad110kg.bot.msg.template;

import vlad110kg.bot.EntityType;
import vlad110kg.bot.cmd.CommandType;

import java.util.Map;

public class TemplateNames {

    private TemplateNames() {}

    public static final String HELP = "help";
    public static final String SETTINGS = "settings";
    public static final String WELCOME = "welcome";

    private static final String PICK = "pick";
    private static final String REMOVE = "rm";
    private static final String STATUS = "status";

    private static final String TAG = "/tag";
    private static final String READER = "/reader";
    private static final String SUCCESS = "/success";
    private static final String INSTRUCTION = "/instruction";

    public static final String PICK_REGION_SUCCESS = "pick_region_success";

    public static final String REMOVE_REGION_SUCCESS = "rm_region_success";


    private static final String NOTIFICATION = "notification/";
    private static final String BALANCE = NOTIFICATION + "balance/";

    public static final String ENABLE = "enable";
    public static final String ENABLE_READER = "enable_reader";
    public static final String PAUSE_READER = "pause_reader";

    public static final String STATUS_READER = STATUS + READER;
    public static final String STATUS_TAG = STATUS + TAG;
    public static final String STATUS_TAG_LIMIT = STATUS + TAG + "/limit";

    private static final String FAILURE = "failure";

    public static final Map<EntityType, String> RM_ENTITY_CONTAINER = Map.of(
        EntityType.RESOURCE,
        REMOVE_REGION_SUCCESS
    );

    public static final Map<EntityType, String> PICK_ENTITY_CONTAINER = Map.of(
        EntityType.RESOURCE,
        PICK_REGION_SUCCESS
    );

    private static final Map<CommandType, Map<EntityType, String>> UPDATE_MSG_CONTAINER =
        Map.of(
            CommandType.PICK, PICK_ENTITY_CONTAINER,
            CommandType.REMOVE, RM_ENTITY_CONTAINER
        );

    public static String getTemplate(CommandType c, EntityType e) {
        return UPDATE_MSG_CONTAINER.get(c).get(e);
    }

}
