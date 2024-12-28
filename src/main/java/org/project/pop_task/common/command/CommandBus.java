package org.project.pop_task.common.command;

import java.util.HashMap;
import java.util.Map;

public class CommandBus {
    private static final Map<Class<? extends BaseCommand>, CommandHandler> handlers = new HashMap<>();

    public static void registerHandler(Class<? extends BaseCommand> commandType, CommandHandler handler) {
        handlers.put(commandType, handler);
    }

    public static void dispatch(BaseCommand command) {
        CommandHandler handler = handlers.get(command.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("No handler found for command: " + command.getClass());
        }
        handler.handle(command);
    }
}
