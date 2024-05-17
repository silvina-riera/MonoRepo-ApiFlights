package com.ar.bootcampJava.ApiMilesProgram.controllers;

import com.ar.bootcampJava.ApiMilesProgram.models.FlightsDto;
import com.ar.bootcampJava.ApiMilesProgram.models.User;
import com.ar.bootcampJava.ApiMilesProgram.services.FlightsClient;
import com.ar.bootcampJava.ApiMilesProgram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    FlightsClient flightsClient;

    @GetMapping(value = "/view")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(value = "/flights/view")
    public List<FlightsDto> getFlights(){
        return flightsClient.getFlights();
    }

    @GetMapping(value = "/flights/search/{flightId}")
    public FlightsDto getFlightById(@PathVariable Long flightId){
        return flightsClient.getFlightById(flightId);
    }

    @GetMapping(value = "/search/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
    @PostMapping(value = "/create")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping(value = "/update/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }
    @DeleteMapping(value = "/delete/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/add/flightPoints")
    public User addPoints(@RequestParam Long userId, @RequestParam Long flightId) {
        return userService.addPoints(userId, flightId);
    }

    @PutMapping("/subtract/flightPoints")
    public User subtractPoints(@RequestParam Long userId, @RequestParam Long flightId) {
        return userService.subtractPoints(userId, flightId);
    }
}
