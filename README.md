# notification-service

Consumes low-stock alerts from Kafka and simulates notifying a procurement team.
Exists to demonstrate Kafka fan-out: the same event, consumed independently by
multiple services in different consumer groups.

## Responsibilities
- Consumes `low-stock-alerts` topic (own consumer group: `notification-service`)
- Logs an alert for each low-stock event received

## Run
    mvn spring-boot:run
Runs on port 8085. Requires `eureka-server` and `kafka-local` running.

## Tech
Spring Boot 4.1, Spring Kafka, Spring Cloud 2025.1.2 (Eureka client).

## Related services
Consumes events from: [inventory-service](https://github.com/Sannidhihegde/inventory-service) — same topic as [audit-service](https://github.com/Sannidhihegde/audit-service), different consumer group, both receive every event.
