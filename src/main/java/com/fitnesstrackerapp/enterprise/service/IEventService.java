package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Event;

public interface IEventService {

    Event fetchById(int eventId);

    void save(Event event);

    void delete(int eventId);

    void update(int eventId, Event event);
}
