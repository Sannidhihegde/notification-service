package com.notification.listener;

import com.notification.event.LowStockEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LowStockNotificationListener {

    @KafkaListener(topics = "low-stock-alerts", groupId = "notification-service")
    public void handle(LowStockEvent event) {
        log.warn("ALERT: {} is low on stock — {} units left (threshold {}). Notifying procurement.",
                event.name(), event.quantity(), event.threshold());
    }
}