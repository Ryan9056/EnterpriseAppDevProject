package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.Event;
import com.fitnesstrackerapp.enterprise.service.IEventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class EventServiceTests {

    @Autowired
    private IEventService eventService;
    private Event templateEvent;
    private Event testEvent;
    private Event updateEvent;


    //Test for creating, fetching, and verifying creation of Event using event type and id
    @Test
    void createEvent_returnsTestEvent() {
        createTestEvent();
        fetchTestEvent();
        returnTestEvent("test");
    }
    // Test for creating, fetching, updating, and verifying creation of Event using Event name and id
    @Test
    void updateEvent_returnsUpdatedEvent() {
        createTestEvent();
        fetchTestEvent();
        updateTestEvent();
        returnTestEvent("updated");
    }

    // Test for creating, deleting and verifying deletion of an Event using Event name and id
    @Test
    void deleteEvent_returnsNull() {
        createTestEvent();
        deleteTestEvent();
    }

    // delete Event using Event id then checking is Event is null
    private void deleteTestEvent() {
        eventService.delete(templateEvent.getEventId());
        assertNull(eventService.fetchById(templateEvent.getGoalId(), templateEvent.getEventId()));
    }

    // create new Event then update test Event using new Event
    private void updateTestEvent() {
        updateEvent = new Event();
        updateEvent.setEventId(2);
        updateEvent.setEventType("updated");
        testEvent = eventService.update(updateEvent.getEventId());
    }

    // create new Event and save new Event
    private void createTestEvent() {
        templateEvent = new Event();
        templateEvent.setEventId(1);
        templateEvent.setGoalId(1);
        templateEvent.setEventType("test");
        eventService.save(templateEvent);
    }

    // fetch test Event with id
    private void fetchTestEvent() {
        testEvent = eventService.fetchById(templateEvent.getGoalId(),templateEvent.getEventId());
    }

    // verify Event is the correct
    private void returnTestEvent(String type) {
        String eventType = testEvent.getEventType();
        assertEquals(type,eventType);
    }



}
