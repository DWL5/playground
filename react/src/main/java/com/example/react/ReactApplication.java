package com.example.react;

import com.example.react.domain.Car;
import com.example.react.domain.Owner;
import com.example.react.repository.CarRepository;
import com.example.react.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class ReactApplication implements CommandLineRunner {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        ownerRepository.saveAll(List.of(owner1, owner2));


        carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, Set.of(owner1)));
        carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, Set.of(owner1)));
        carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, Set.of(owner2)));


        for (Car car : carRepository.findAll()) {
            log.info(car.getBrand() + " " + car.getModel() + " " + car.getOwners().size());
        }
    }
}
