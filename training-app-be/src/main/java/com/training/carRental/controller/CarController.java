package com.training.carRental.controller;

import java.util.List;


import com.training.carRental.exception.ResourceNotFoundException;
import com.training.carRental.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.training.carRental.repo.CarRepository;

import javax.validation.Valid;


/*

CarController is a REST Controller which has request mapping methods
for RESTful requests such as: getAllCars, postCars, deleteCar,
deleteAllCars, findById, updateCar.
 */



   /* @RestController è una combinazione di  @Controller e @ResponseBody
   * @Controller è usata per definire un controller
   * @ResponseBody annotazione utilizzata per indicare che il valore restituito
   * dal metodo deve essere usato come "response body" della richiesta
   * */
    @CrossOrigin(origins = "http://localhost:4200")
    @RestController
    @RequestMapping("/api")
    public class CarController {

        @Autowired
        CarRepository carRepository;

        /* Get All Cars
        @GetMapping =  @RequestMapping(value="/cars", method=RequestMethod.GET).
         */


        @GetMapping("/cars")
        public List<Car> getAllNotes() {
            return carRepository.findAll();
        }

        /* Create a new Car
        @Valid annotation check if brand and com.training.carRental.model fields of Car are not null (@NotBlank annotation used in the Car com.training.carRental.model)
        */
        @PostMapping("/cars")
        public Car createNote(@Valid @RequestBody Car car) {
            return carRepository.save(car);
        }

        // Get a Single Car
        @GetMapping("/cars/{id}")
        public Car getCarById(@PathVariable(value = "id") Long carId) {
            return carRepository.findById(carId)
                    //we are throwing a ResourceNotFoundException whenever a Car with the given id is not found.
                    .orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));
        }
        // Update a Car
        @PutMapping("/cars/{id}")
        public Car updateCar(@PathVariable(value = "id") Long carId,
                               @Valid @RequestBody Car carDetails) {

            Car car = carRepository.findById(carId)
                    .orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));

            car.setBrand(carDetails.getBrand());
            car.setModel(carDetails.getModel());
            car.setColour(carDetails.getColour());

            Car updatedCar = carRepository.save(car);
            return updatedCar;
        }

        // Delete a Car

        @DeleteMapping("/cars/{id}")
        public ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long carId) {
            Car note = carRepository.findById(carId)
                    .orElseThrow(() -> new ResourceNotFoundException("Note", "id", carId));

            carRepository.delete(note);

            return ResponseEntity.ok().build();
        }
    }

