package org.project.pop_task.common.event;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {
    private static final List<BaseEvent> events = new ArrayList<>();

    public static void publish(BaseEvent event) {
        events.add(event);
        System.out.println("Published event: " + event.getClass().getSimpleName());
    }

    public static List<BaseEvent> getPublishedEvents() {
        return events;
    }
}
