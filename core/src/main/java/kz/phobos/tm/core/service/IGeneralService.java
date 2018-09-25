package kz.phobos.tm.core.service;

import kz.phobos.tm.core.model.Event;

import java.util.List;

public interface IGeneralService {

    List<Event> getAllEvent();
    Event getEventById(Integer id);

}
