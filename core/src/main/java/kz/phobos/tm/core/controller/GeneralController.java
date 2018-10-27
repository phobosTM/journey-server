package kz.phobos.tm.core.controller;


import kz.phobos.tm.core.model.*;
import kz.phobos.tm.core.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general")
public class GeneralController {

    @Autowired
    private IGeneralService service;




    @GetMapping("/event")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public List<Event> getAllEvent() {
        return service.getAllEvent();
    }

    @GetMapping("/event/{id}")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public Event getEventById(@PathVariable(value = "id") Integer id) {
        return service.getEventById(id);
    }



    @GetMapping("/eventStatus")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public List<EventStatus> getAllEventStatus() {
        return service.getAllEventStatus();
    }

    @GetMapping("/eventStatus/{id}")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    EventStatus getEventStatusById(@PathVariable(value = "id") Integer id) {
        return service.getEventStatusById(id);
    }

    @GetMapping("/eventUserMap")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public List<EventUserMap> getAllEventUserMap() {
        return service.getAllEventUserMap();
    }

    @GetMapping("/eventUserMap/{id}")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public EventUserMap getEventUserMapById(@PathVariable(value = "id") Integer id) {
        return service.getEventUserMapById(id);
    }
    @GetMapping("/eventUserRate")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public List<EventUserRate> getAllEventUserRate() {
        return service.getAllEventUserRate();
    }

    @GetMapping("/eventUserRate/{id}")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
   public EventUserRate getEventUserRateById(@PathVariable(value = "id") Integer id) {
        return service.getEventUserRateById(id);
    }

    @GetMapping("/rateValue")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public List<RateValue> getAllRateValue() {
        return service.getAllRateValue();
    }

    @GetMapping("/rateValue/{id}")
    RateValue getRateValueById(@PathVariable(value = "id") Integer id) {
        return service.getRateValueById(id);
    }

    @GetMapping("/route")
    @CrossOrigin(origins = "http://localhost:4200")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public List<Route> getAllRoute(){
        return service.getAllRoute();
    }

    @GetMapping("/route/{id}")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public Route getRouteById(@PathVariable(value = "id") Integer id) {
        return service.getRouteById(id);
    }
    @GetMapping("/routeLevel")
    @CrossOrigin(origins = "http://localhost:4200")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public List<RouteLevel> getAllRouteLevel(){
        return service.getAllRouteLevel();
    }
    @GetMapping("/routeLevel/{id}")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
   public RouteLevel getRouteLevelById(@PathVariable(value = "id") Integer id) {
        return service.getRouteLevelById(id);
    }
    @GetMapping("/routeStatus")
    @CrossOrigin(origins = "http://localhost:4200")
    @PreAuthorize("hasRole(@role.ADMIN) AND hasRole(@role.USER_ADMIN)")
    public List<RouteStatus> getAllRouteStatus(){
        return service.getAllRouteStatus();
    }
    @GetMapping("/routeStatus/{id}")
    public RouteStatus getRouteStatusById(@PathVariable(value = "id") Integer id) {
        return service.getRouteStatusById(id);
    }























}
