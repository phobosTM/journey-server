package kz.phobos.tm.core.controller;


import kz.phobos.tm.core.model.User;
import kz.phobos.tm.core.service.UserService.IUserService;
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
public class UserRestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<User> getAllUser() {
        return  userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id) {
        return userService.getUserById(id);
    }



    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> addUser(@RequestBody @Valid User user, BindingResult bindingResult) throws DataException{

        HttpHeaders headers = new HttpHeaders();
        if(user == null) {
            return new ResponseEntity<User>(user, headers, HttpStatus.BAD_REQUEST);

        }

        this.userService.addUser(user);
        return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable("userId") int userId){
        User user = this.userService.getUserById(userId);

        if(user ==null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        this.userService.deleteUser(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @RequestBody @Valid User user,
                                             BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
        HttpHeaders headers = new HttpHeaders();
        if (user == null) {
            return new ResponseEntity<User>(headers, HttpStatus.BAD_REQUEST);
        }
        User currentUser = this.userService.getUserById(userId);
        if (currentUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        currentUser.setEmail(user.getEmail());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setbDate(user.getbDate());

        this.userService.addUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.NO_CONTENT);
    }


}
