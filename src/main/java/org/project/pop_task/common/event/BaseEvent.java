package org.project.pop_task.common.event;

public abstract class BaseEvent {
    private final long timestamp;

    public BaseEvent() {
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }
}
