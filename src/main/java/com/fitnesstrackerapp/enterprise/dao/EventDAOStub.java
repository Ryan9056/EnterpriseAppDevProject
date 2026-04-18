package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EventDAOStub implements IEventDAO {
    Map<Integer, Event> allEvents = new HashMap<>();

    @Override
    public Event save(Event event) throws Exception {
        int eventId = event.getEventId();
        allEvents.put(eventId,event);
        return event;
    }

    @Override
    public Event fetch(int eventId) {
        return allEvents.get(eventId);
    }

    @Override
    public void delete(int eventId) throws Exception {
        allEvents.remove(eventId);
    }

    @Override
    public List<Event> fetchAll() {
        List<Event> returnevents = new ArrayList(allEvents.values());
        return returnevents;
    }

    @Override
    public Event update(Event event, int eventId) throws Exception {
        allEvents.put(eventId, event);
        return event;
    }
}
