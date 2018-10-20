package kz.phobos.tm.core.controller;


import kz.phobos.tm.core.model.Event;
import kz.phobos.tm.core.model.Event;
import kz.phobos.tm.core.service.EventService.IEventService;
import kz.phobos.tm.core.service.EventService.IEventService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/general")
public class EventRestController {

    @Autowired
    private IEventService eventService;

    @GetMapping("/event")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Event> getAllEvent() {
        return  eventService.getAllEvent();
    }

    @GetMapping("/event/{id}")
    public Event getEventById(@PathVariable(value = "id") Integer id) {
        return eventService.getEventById(id);
    }



    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Event> addEvent(@RequestBody @Valid Event event, BindingResult bindingResult) throws DataException{

        HttpHeaders headers = new HttpHeaders();
        if(event == null) {
            return new ResponseEntity<Event>(event, headers, HttpStatus.BAD_REQUEST);

        }

        this.eventService.addEvent(event);
        return new ResponseEntity<Event>(event, headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/event/{eventId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Event> deleteEvent(@PathVariable("eventId") int eventId){
        Event event = this.eventService.getEventById(eventId);

        if(event ==null) {
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        this.eventService.deleteEvent(event);
        return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/event/{eventId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Event> updateEvent(@PathVariable("eventId") int eventId, @RequestBody @Valid Event event,
                                           BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
        HttpHeaders headers = new HttpHeaders();
        if (event == null) {
            return new ResponseEntity<Event>(headers, HttpStatus.BAD_REQUEST);
        }
        Event currentEvent = this.eventService.getEventById(eventId);
        if (currentEvent == null) {
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        currentEvent.setStatusId(event.getStatusId());
        currentEvent.setName(event.getName());
        currentEvent.setMaxParticipants(event.getMaxParticipants());
        currentEvent.setStartDate(event.getStartDate());

        this.eventService.addEvent(currentEvent);
        return new ResponseEntity<Event>(currentEvent, HttpStatus.NO_CONTENT);
    }


}
