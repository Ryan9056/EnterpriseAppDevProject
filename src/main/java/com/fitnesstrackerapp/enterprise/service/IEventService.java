package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Event;

public interface IEventService {

    Event fetchById(int goalId, int eventId);

    Event save(Event event);

    void delete(int eventId);

    Event update(int eventId);
}
