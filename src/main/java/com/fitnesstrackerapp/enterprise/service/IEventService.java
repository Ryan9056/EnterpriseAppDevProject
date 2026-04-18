package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Event;

import java.util.List;

public interface IEventService {

    Event fetchById(int eventId);

    Event save(Event event) throws Exception;

    void delete(int eventId) throws Exception;

    Event update(Event event, int eventId) throws Exception;

    List<Event> fetchAll();
}
