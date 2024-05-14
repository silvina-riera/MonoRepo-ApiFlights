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

    @GetMapping(value = "/flights/search/{flight_id}")
    public FlightsDto getFlightById(@PathVariable Long flight_id){
        return flightsClient.getFlightById(flight_id);
    }

    @GetMapping(value = "/search/{user_id}")
    public Optional<User> getUserById(@PathVariable Long user_id){
        return userService.getUserById(user_id);
    }
    @PostMapping(value = "/create")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping(value = "/update/{user_id}")
    public User updateUser(@PathVariable Long user_id, @RequestBody User user){
        return userService.updateUser(user_id, user);
    }
    @DeleteMapping(value = "/delete/{user_id}")
    public void deleteUser(@PathVariable Long user_id){
        userService.deleteUser(user_id);
    }

    @PutMapping("/add/flightPoints")
    public User addPoints(@RequestParam Long user_id, @RequestParam Long flight_id) {
        return userService.addPoints(user_id, flight_id);
    }

    @PutMapping("/subtract/flightPoints")
    public User subtractPoints(@RequestParam Long user_id, @RequestParam Long flight_id) {
        return userService.subtractPoints(user_id, flight_id);
    }
}
