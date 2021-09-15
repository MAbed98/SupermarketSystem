package com.example.demo.controller;

import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
//import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController //  to building RESTful web services
public class CarController {

    @Autowired
    CarService carService ;

    @Autowired
//    EmailService emailService ;


    // return value from controller:
    @GetMapping(value = "/send")
    public String sendEmail() {


//        emailService.sendPreConfiguredMail("mohmmad");
//        emailService.sendMail("mdarabed@asaltech.com", "test", "test");
        return String.format("sent email to mdarabed@asaltech.com");
    }

        //from service:
    @GetMapping(value = "/printInfo")
    public String printInfo(){
        return carService.printInfo() ;
//        return "BMW-2020" ;
    }

    @GetMapping(value = "/printInfo/{carId}")
    public String writeCArInfoById( @PathVariable int carId) throws ResourceNotFoundException {
        try {
            return carService.getCarById(carId) ;
        }catch (NoSuchElementException ex){
            throw new ResourceNotFoundException(String.format("Error message [ Not found (%s) ID ]")) ;
        }
//        return String.format("Welcome %s in my page",car.get(carNo-1) );
    }

    @PostMapping(value = {"", "/"})
    public Car createCar(@RequestBody  Car car){

        if(carService.save(car))
            return car ;
        return null ;
    }

//    @DeleteMapping(value = "/{id}")
//    public void deleteCarById(@PathVariable int id){
//         carService.deletedCar(id) ;
//    }

    @RequestMapping(method=RequestMethod.DELETE, value = "/{id}")
    public void deleteCarById(@PathVariable int id){
        carService.deletedCar(id) ;
    }

    @PutMapping(value = "/{model}")
    public boolean updateCarInfo(@PathVariable String model, @RequestBody Car car){
        return carService.isUpdatedCar(model,car);
    }

    /////////////////////////////////////////////////////////////
    //*** Storage on DB:

    @RequestMapping(value = "/db/cars" , method = RequestMethod.GET)
    public List<Car> getAllCar(HttpServletRequest request, HttpServletResponse response,
                               Object handler) throws Exception  {
        return carService.getAllCar() ;

    }
    @PostMapping( value = "/add")
    public String  addCar(@Valid @RequestBody Car car)
    {
       return carService.addNewCar(car) ;
//        return new ResponseEntity<>(car , HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteCarByIdInDb( @PathVariable int id) throws ResourceNotFoundException {
        try {
            return carService.deleteCar(id);
        }catch (NoSuchElementException ex){
            throw new ResourceNotFoundException(String.format("Error message [ Not found (%s) ID ]")) ;
        }
    }

    @DeleteMapping(value = "/delete/{id1}/{id2}")
    public String deleteCarsFromToByIdInDb( @PathVariable int id1 , @PathVariable int id2) throws ResourceNotFoundException{
        try {
            return carService.deleteCars(id1 , id2);
        }catch (NoSuchElementException ex){
            throw new ResourceNotFoundException(String.format("Error message [ Not found ID ]")) ;
        }
    }

    @PutMapping(value = "/update/{id}")
    public String updateCar(@PathVariable int id , @RequestBody Car car){
        return carService.updateCar( id , car) ;
    }

}
