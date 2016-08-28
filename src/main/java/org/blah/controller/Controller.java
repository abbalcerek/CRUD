package org.blah.controller;

import org.blah.entity.User;
import org.blah.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by adam on 24.08.16.
 */
@RestController
class Controller {

    @Autowired
    private Service service;

    @RequestMapping("/")
    String index() {
        return "hello world";
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsers() {
        return service.getUsers();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @RequestMapping(value = "/saveUser", consumes="application/json", produces="application/json")
    public User saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

}