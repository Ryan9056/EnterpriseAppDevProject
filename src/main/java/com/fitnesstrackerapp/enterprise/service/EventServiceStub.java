package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Event;
import org.springframework.stereotype.Component;

@Component
public class EventServiceStub implements IEventService{
    @Override
    public Event fetchById(int eventId) {
        return null;
    }

    @Override
    public Event save(Event event) {
        return null;
    }
}
