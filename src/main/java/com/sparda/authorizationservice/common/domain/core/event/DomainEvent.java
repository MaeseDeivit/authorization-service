package com.sparda.authorizationservice.common.domain.core.event;

public interface DomainEvent<T> {
    void fire();
}
