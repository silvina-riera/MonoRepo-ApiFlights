package com.ar.bootcampJava.ApiMilesProgram.services;

import com.ar.bootcampJava.ApiMilesProgram.exceptions.ResourceNotExistsException;
import com.ar.bootcampJava.ApiMilesProgram.models.FlightsDto;
import com.ar.bootcampJava.ApiMilesProgram.models.User;
import com.ar.bootcampJava.ApiMilesProgram.repositories.UserRepository;
import com.ar.bootcampJava.ApiMilesProgram.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FlightsClient flightsClient;

    @Autowired
    UserUtils userUtils;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {

        user.setPoints(BigDecimal.ZERO);

        userRepository.save(user);}

    public Optional<User> getUserById(Long user_id) {
        return userRepository.findById(user_id);
    }

    public String deleteUser(Long user_id){
        if (userRepository.existsById(user_id)){
            userRepository.deleteById(user_id);
            return "El usuario con id: " + user_id + " ha sido eliminado";
        } else {
            throw new ResourceNotExistsException("El usuario a eliminar elegido no existe");
        }

    }

    public User updateUser(Long user_id, User user) {
        if (userRepository.existsById(user_id)){
            User userToModify = userRepository.findById(user_id).get();

            if (user.getPassengerName() != null){
                userToModify.setPassengerName(user.getPassengerName());
            }

            if (user.getPassengerEmail() != null){
                userToModify.setPassengerEmail(user.getPassengerEmail());
            }

            if (user.getPassengerPassport() != null){
                userToModify.setPassengerPassport(user.getPassengerPassport());
            }

            if (user.getPoints() != null){
                userToModify.setPoints(user.getPoints());
            }

            User userModified = userRepository.save(userToModify);

            return userModified;
        }

        return null;
    }

    public User addPoints(Long user_id, Long flight_id) {

        User user = this.getUserById(user_id).get();

        FlightsDto flight = flightsClient.getFlightById(flight_id);

        user.setPoints(user.getPoints().add(BigDecimal.valueOf(userUtils.getPointsEarned(flight.getConvertedPrice()))));

        User userModified = userRepository.save(user);

        return userModified;
    }

    public User subtractPoints(Long user_id, Long flight_id) {

        User user = this.getUserById(user_id).get();

        FlightsDto flight = flightsClient.getFlightById(flight_id);

        if(user.getPoints().subtract(BigDecimal.valueOf(flight.getConvertedPrice())).compareTo(BigDecimal.ZERO)>0) {
        user.setPoints(user.getPoints().subtract(BigDecimal.valueOf(flight.getConvertedPrice())));

        User userModified = userRepository.save(user);

        return userModified;
        } else {
            throw  new ResourceNotExistsException("Puntos insuficientes");
        }
    }

}

