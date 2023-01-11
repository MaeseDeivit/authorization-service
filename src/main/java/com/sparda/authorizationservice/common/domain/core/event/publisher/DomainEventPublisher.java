package com.sparda.authorizationservice.common.domain.core.event.publisher;

import com.sparda.authorizationservice.common.domain.core.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
