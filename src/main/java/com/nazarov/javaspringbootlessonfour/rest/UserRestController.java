package com.nazarov.javaspringbootlessonfour.rest;


import com.nazarov.javaspringbootlessonfour.entities.User;
import com.nazarov.javaspringbootlessonfour.services.UserService;
import com.nazarov.javaspringbootlessonfour.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}/id", produces = "application/json")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id).orElseThrow(NotFoundException::new);
    }

    @GetMapping(path = "/list", produces = "application/json")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody User user) {
        userService.createOrUpdate(user);
        return user;
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User user) {
        userService.createOrUpdate(user);
        return user;
    }

    @DeleteMapping("{id}/id")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> notFoundExceptionHandler(NotFoundException exception) {
        return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
    }


}
