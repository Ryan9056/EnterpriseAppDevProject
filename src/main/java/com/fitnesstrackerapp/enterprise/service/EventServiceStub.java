package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dao.IEventDAO;
import com.fitnesstrackerapp.enterprise.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceStub implements IEventService{

    @Autowired
    private IEventDAO eventDAO;

    public EventServiceStub() {

    }

    public EventServiceStub(IEventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public Event fetchById(int eventId) {
        Event foundEvent = eventDAO.fetch(eventId);
        return foundEvent;
    }

    @Override
    public Event save(Event event) throws Exception {
        return eventDAO.save(event);
    }

    @Override
    public Event update(Event event, int eventId) throws Exception {
        return eventDAO.update(event, eventId);
    }

    @Override
    public void delete(int eventId) throws Exception {
        eventDAO.delete(eventId);
    }

    @Override
    public List<Event> fetchAll() {
        return eventDAO.fetchAll();
    }
}
