package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Event;
import org.springframework.stereotype.Component;

@Component
public class EventServiceStub implements IEventService{
    @Override
    public Event fetchById(int goalId, int eventId) {
        return null;
    }

    @Override
    public Event save(Event event) {
        return null;
    }

    @Override
    public void delete(int eventId) {

    }

    @Override
    public Event update(int eventId) {
        return null;
    }
}
