package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dao.EventDAOStub;
import com.fitnesstrackerapp.enterprise.dao.IEventDAO;
import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.Event;
import com.fitnesstrackerapp.enterprise.service.AccountServiceStub;
import com.fitnesstrackerapp.enterprise.service.EventServiceStub;
import com.fitnesstrackerapp.enterprise.service.IEventService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EventServiceTests {

    private IEventService eventService;
    private Event testEvent;
    private Event updateEvent;

    @MockitoBean
    private IEventDAO eventDAO;


    //Test for creating, fetching, and verifying creation of Event using event type and id
    @Test
    void createEvent_returnsTestEvent() throws Exception {
        createTestEvent();
        fetchTestEvent();
        returnTestEvent("test");
    }
    // Test for creating, fetching, updating, and verifying creation of Event using Event name and id
    @Test
    void updateEvent_returnsUpdatedEvent() throws Exception {
        createTestEvent();
        fetchTestEvent();
        updateTestEvent();
        returnTestEvent("updated");
    }

    // Test for creating, deleting and verifying deletion of an Event using Event name and id
    @Test
    void deleteEvent_returnsNull() throws Exception {
        createTestEvent();
        deleteTestEvent();
    }

    // delete Event using Event id then checking is Event is null
    private void deleteTestEvent() throws Exception {
        eventService.delete(testEvent.getEventId());
        assertNull(eventService.fetchById(1));
    }

    // create new Event then update test Event using new Event
    private void updateTestEvent() throws Exception {
        updateEvent = new Event();
        updateEvent.setEventId(2);
        updateEvent.setEventType("updated");
        testEvent = eventService.update(updateEvent, testEvent.getEventId());
    }

    // create new Event and save new Event
    private void createTestEvent() throws Exception {
        testEvent = new Event();
        testEvent.setEventId(1);
        testEvent.setEventType("test");
        eventDAO = new EventDAOStub();
        eventService = new EventServiceStub(eventDAO);
        eventService.save(testEvent);
    }

    // fetch test Event with id
    private void fetchTestEvent() {
        testEvent = eventService.fetchById(1);
    }

    // verify Event is the correct
    private void returnTestEvent(String name) throws  Exception {
        Event createdEvent = eventService.save(testEvent);
        assertEquals(name, createdEvent.getEventType());
    }



}
