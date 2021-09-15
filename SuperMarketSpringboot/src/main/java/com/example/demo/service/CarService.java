package com.example.demo.service;

import com.example.demo.error.ConflictException;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class CarService {


    public ArrayList<Car> car = new ArrayList<Car>(Arrays.asList(
            new Car(1, "KIA","m@gmail.com"), new Car(2, "BMW","A@gmail.com"),
            new Car(3, "Ferare","B@gmail.com")
    )) ;

    public String printInfo() {

        return String.format("%s" , car) ;
//        return  "BMW-2020(inService)" ;
    }

    public String getCarById(int carId) {
        if(carId <= car.size())
        return String.format(" %s ",car.get(carId-1) );

        return "Not found this car" ;
    }

//    public Car createCar() {
//        car.remove(1) ;
//        return String.format(" %s ",car) ;
//    }

//    public Car deleteCarById(int id) {
//         car.remove(1) ;
//        return String.format(" %s ",car) ;
//    }

    public boolean save( Car newCar) {
            if(carRepo.findById(newCar.getId() ).get() != null)
                throw new ConflictException("Another record eith same this ") ;
        return car.add(newCar) ;
      }

    public void deletedCar(int id){

      for(Car deleteCar:car ){
        if(deleteCar.getId() == id){
            car.remove(deleteCar) ;
        }
      }


    }

    public boolean isUpdatedCar(String model,Car newCAr) {
        for (Car updatedCare:car){
            if(updatedCare.getModel().equals(model)){
               updatedCare.setId(newCAr.getId());
               updatedCare.setModel(newCAr.getModel());
               return true ;
            }
        }
        return false ;
    }
/////////////////////////////////////////////////////////////
    ////// Storage on DB:
    @Autowired
    CarRepo carRepo ;
    public List<Car> getAllCar() {
        return carRepo.findAll() ;
    }

    public String addNewCar(Car car) {

//        if(carRepo.findById(car.getId() ).get() != null)
//            throw new ConflictException("Another record the same this ") ;

        AtomicBoolean y = new AtomicBoolean(true);
        List<Car> carsList = carRepo.findAll();
        carsList.forEach( carIndex -> {
            if (carIndex.getEmailUser().equals(car.getEmailUser())){
             y.set(false);
            }
        } ) ;

        if(y.get())
        {
            carRepo.save(car) ;
            return "success" ;
        }
        return "failed the email is duplicated" ;
    }

    public String deleteCar(int id) {
//        System.out.println(carRepo.getOne(id));
//        if(carRepo.getOne(id) != null) {
//          Car delted = carRepo.getOne(id) ;
//          carRepo.deleteById(id) ;
//            return delted;
//        }
//        return null ;
        ;
        String deletedCar =  "this car : "+carRepo.getOne(id)+" is deleted" ;
        carRepo.deleteById(id) ;

        return  deletedCar;
    }

    public String updateCar(int id, Car car)
    {
        Car updatedCar = carRepo.getOne(id) ;
        carRepo.deleteById(id);
        updatedCar.setModel(car.getModel());
        updatedCar.setId(car.getId());
        carRepo.save(updatedCar) ;

        return ""+updatedCar ;
    }

    public String deleteCars(int id1, int id2) {

        String deletedCar = "this cars : ";
        for(int x = id1 ; x<= id2 ; x++) {
            deletedCar +=   carRepo.getOne(x) ;
            carRepo.deleteById(x);
        }
        deletedCar+= " is deleted";
        return  deletedCar;
    }
}
