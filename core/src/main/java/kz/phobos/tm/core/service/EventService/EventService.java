package kz.phobos.tm.core.service.EventService;


import kz.phobos.tm.core.model.Event;
import kz.phobos.tm.core.model.User;
import kz.phobos.tm.core.repository.EventJpaRepo;
import kz.phobos.tm.core.repository.UserJpaRepo;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService implements IEventService{
    @Autowired
    EventJpaRepo eventJpaRepo;

    @Override
    public List<Event> getAllEvent() {

        return eventJpaRepo.findAll();
    }

    @Override
    public Event getEventById(Integer id) {

        return eventJpaRepo.findOne(id);
    }

    @Override
    public void addEvent(Event event) throws DataException {
        eventJpaRepo.save(event);
    }

    @Override
    @Transactional
    public void deleteEvent(Event event) throws DataAccessException {
        eventJpaRepo.delete(event);
    }



}
