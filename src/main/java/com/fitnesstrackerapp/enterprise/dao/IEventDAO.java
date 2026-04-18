package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Event;

import java.util.List;

public interface IEventDAO {
    Event save(Event event) throws Exception;

    Event fetch(int eventId);

    void delete(int eventId) throws Exception;

    List<Event> fetchAll();

    Event update(Event event, int eventId) throws Exception;
}
