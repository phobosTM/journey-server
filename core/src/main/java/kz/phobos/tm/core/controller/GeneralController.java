package kz.phobos.tm.core.controller;


import kz.phobos.tm.core.model.Event;
import kz.phobos.tm.core.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/general")
public class GeneralController {

    @Autowired
    private IGeneralService service;

    @GetMapping("/event")
    public List<Event> getAllEvent() {
        return service.getAllEvent();
    }

    @GetMapping("/event/{id}")
    Event getEventById(@PathVariable(value = "id") Integer id) {
        return service.getEventById(id);
    }



}
