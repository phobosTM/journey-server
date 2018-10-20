package kz.phobos.tm.core.controller;


import java.util.List;
import kz.phobos.tm.core.model.*;
import kz.phobos.tm.core.model.User;
import kz.phobos.tm.core.model.Event;
import kz.phobos.tm.core.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import kz.phobos.tm.core.service.IGeneralService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


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
    public Event getEventById(@PathVariable(value = "id") Integer id) {
        return service.getEventById(id);
    }


    @GetMapping("/eventStatus")
    public List<EventStatus> getAllEventStatus() {
        return service.getAllEventStatus();
    }
    @GetMapping("/eventStatus/{id}")
    EventStatus getEventStatusById(@PathVariable(value = "id") Integer id) {
        return service.getEventStatusById(id);
    }

    @GetMapping("/eventUserMap")
    public List<EventUserMap> getAllEventUserMap() {
        return service.getAllEventUserMap();
    }

    @GetMapping("/eventUserMap/{id}")
    public EventUserMap getEventUserMapById(@PathVariable(value = "id") Integer id) {
        return service.getEventUserMapById(id);
    }
    @GetMapping("/eventUserRate")
    public List<EventUserRate> getAllEventUserRate() {
        return service.getAllEventUserRate();
    }

    @GetMapping("/eventUserRate/{id}")
   public EventUserRate getEventUserRateById(@PathVariable(value = "id") Integer id) {
        return service.getEventUserRateById(id);
    }

    @GetMapping("/rateValue")
    public List<RateValue> getAllRateValue() {
        return service.getAllRateValue();
    }

    @GetMapping("/rateValue/{id}")
    RateValue getRateValueById(@PathVariable(value = "id") Integer id) {
        return service.getRateValueById(id);
    }

    @GetMapping("/route")
    public List<Route> getAllRoute(){
        return service.getAllRoute();
    }
    @GetMapping("/route/{id}")
   public Route getRouteById(@PathVariable(value = "id") Integer id) {
        return service.getRouteById(id);
    }
    @GetMapping("/routeLevel")
    public List<RouteLevel> getAllRouteLevel(){
        return service.getAllRouteLevel();
    }
    @GetMapping("/routeLevel/{id}")
   public RouteLevel getRouteLevelById(@PathVariable(value = "id") Integer id) {
        return service.getRouteLevelById(id);
    }
    @GetMapping("/routeStatus")
    public List<RouteStatus> getAllRouteStatus(){
        return service.getAllRouteStatus();
    }
    @GetMapping("/routeStatus/{id}")
    public RouteStatus getRouteStatusById(@PathVariable(value = "id") Integer id) {
        return service.getRouteStatusById(id);
    }























}
