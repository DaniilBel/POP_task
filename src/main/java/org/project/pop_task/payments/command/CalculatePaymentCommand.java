package org.project.pop_task.payments.command;

import org.project.pop_task.common.command.BaseCommand;
import org.project.pop_task.common.event.EventPublisher;
import org.project.pop_task.payments.events.PaymentProcessedEvent;

public class CalculatePaymentCommand implements BaseCommand {

    private final int ticketCount;

    public CalculatePaymentCommand(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public void execute() {
        double discount = calculateDiscount(ticketCount);
        EventPublisher.publish(new PaymentProcessedEvent(ticketCount, discount));
    }

    private double calculateDiscount(int count) {
        if (count > 1000) return 0.3;
        if (count > 750) return 0.2;
        if (count > 500) return 0.1;
        return 0.0;
    }
}
