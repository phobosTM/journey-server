package kz.phobos.tm.core.service;

import kz.phobos.tm.core.model.*;
import kz.phobos.tm.core.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GeneralService implements IGeneralService {

    @Autowired
    EventJpaRepo eventJpaRepo;

    @Autowired
    EventUserMapJpaRepo eventUserMapJpaRepo;

    @Autowired
    EventStatusJpaRepo eventStatusJpaRepo;

    @Autowired
    EventUserRateJpaRepo eventUserRateJpaRepo;

    @Autowired
    RateValueJpaRepo rateValueJpaRepo;

    @Autowired
    RouteJpaRepo routeJpaRepo;

    @Autowired
    RouteStatusJpaRepo routeStatusJpaRepo;

    @Autowired
    RouteLevelJpaRepo routeLevelJpaRepo;

    @Autowired
    UserJpaRepo userJpaRepo;


    @Override
    public List<Event> getAllEvent(){
        return eventJpaRepo.findAll();
    }
    @Override
    public Event getEventById(Integer id) {
        return eventJpaRepo.findOne(id);
    }

    @Override
    public List<EventStatus> getAllEventStatus() {
        return eventStatusJpaRepo.findAll();
    }

    @Override
    public EventStatus getEventStatusById(Integer id)    {
        return eventStatusJpaRepo.findOne(id);
    }

    @Override
    public List<EventUserMap> getAllEventUserMap() {
        return eventUserMapJpaRepo.findAll();
    }

    @Override
    public EventUserMap getEventUserMapById(Integer id) {
        return eventUserMapJpaRepo.findOne(id);
    }

    @Override
    public List<EventUserRate> getAllEventUserRate() {
        return eventUserRateJpaRepo.findAll();
    }

    @Override
    public EventUserRate getEventUserRateById(Integer id) {
        return eventUserRateJpaRepo.findOne(id);
    }

    @Override
    public List<RateValue> getAllRateValue() {
        return rateValueJpaRepo.findAll();
    }

    @Override
    public RateValue getRateValueById(Integer id) {
        return rateValueJpaRepo.findOne(id);
    }

    @Override
    public List<Route> getAllRoute() {
        return routeJpaRepo.findAll();
    }

    @Override
    public Route getRouteById(Integer id) {
        return routeJpaRepo.findOne(id);
    }

    @Override
    public List<RouteLevel> getAllRouteLevel() {
        return routeLevelJpaRepo.findAll();
    }

    @Override
    public RouteLevel getRouteLevelById(Integer id) {
        return routeLevelJpaRepo.findOne(id);
    }

    @Override
    public List<RouteStatus> getAllRouteStatus() {
        return routeStatusJpaRepo.findAll();
    }

    @Override
    public RouteStatus getRouteStatusById(Integer id) {
        return routeStatusJpaRepo.findOne(id);
    }

    @Override
    public List<User> getAllUser() {
        return userJpaRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userJpaRepo.findOne(id);
    }

    @Override
    public void addUser(User user) {
        userJpaRepo.save(user);
    }
}
