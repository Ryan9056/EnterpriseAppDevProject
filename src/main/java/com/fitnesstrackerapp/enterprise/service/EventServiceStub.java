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
    public void save(Event event) {

    }

    @Override
    public void delete(int eventId) {

    }

    @Override
    public void update(int eventId, Event event) {

    }
}
