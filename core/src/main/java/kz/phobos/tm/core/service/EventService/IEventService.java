package kz.phobos.tm.core.service.EventService;

import kz.phobos.tm.core.model.Event;
import org.hibernate.exception.DataException;

import java.util.List;

public interface IEventService {

    List<Event> getAllEvent();
    Event getEventById(Integer id);

    //Post Method
    void addEvent(Event event) throws DataException;

    void deleteEvent(Event event) throws DataException;



}
