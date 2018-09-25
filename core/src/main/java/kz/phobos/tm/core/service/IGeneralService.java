package kz.phobos.tm.core.service;

import kz.phobos.tm.core.model.*;

import java.util.List;


public interface IGeneralService {

    List<Event> getAllEvent();
    Event getEventById(Integer id);

    List<EventStatus> getAllEventStatus();
    EventStatus getEventStatusById(Integer id);

    List<EventUserMap> getAllEventUserMap();
    EventUserMap getEventUserMapById(Integer id);

    List<EventUserRate> getAllEventUserRte();
    EventUserRate getEventUserRateById(Integer id);

    List<RateValue> getAllRateValue();
    RateValue getRateValueById(Integer id);

    List<Route> getAllRoute();
    Route getRouteById(Integer id);

    List<RouteLevel> getAllRouteLevel();
    RouteLevel getRouteLevelById(Integer id);

    List<RouteStatus> getAllRouteStatus();
    RouteStatus getRouteStatusById(Integer id);

    List<User> getAllUser();
    User getUserById(Integer id);


}
