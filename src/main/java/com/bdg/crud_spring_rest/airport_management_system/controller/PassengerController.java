package com.bdg.crud_spring_rest.airport_management_system.controller;

import com.bdg.crud_spring_rest.airport_management_system.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Nov-20
 */
@RestController
public class PassengerController {
    @Autowired
    PassengerService passengerService;

}
