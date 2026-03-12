package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Event;

public interface IEventService {

    Event fetchById(int eventId);

    Event save(Event event);
}
