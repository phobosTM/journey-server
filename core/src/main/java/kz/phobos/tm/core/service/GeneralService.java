package kz.phobos.tm.core.service;

import kz.phobos.tm.core.model.Event;
import kz.phobos.tm.core.repository.EventJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GeneralService implements IGeneralService {

    @Autowired
    EventJpaRepo eventJpaRepo;

    @Override
    public List<Event> getAllEvent(){
        return eventJpaRepo.findAll();
    }
    @Override
    public Event getEventById(Integer id) {
        return eventJpaRepo.findOne(id);
    }


}
