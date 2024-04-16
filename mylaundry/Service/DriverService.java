package com.example.mylaundry.Service;

import com.example.mylaundry.Api.ApiException;
import com.example.mylaundry.Model.Driver;
import com.example.mylaundry.Repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;


    public List<Driver> getDriver() {
        return driverRepository.findAll();
    }

    public void addDriver(Driver driver) {

        driverRepository.save(driver);
    }

    public void updateDriver(Integer id, Driver driver) {
        Driver driver1 = driverRepository.findDriversById(id);
        if (driver1 == null) {
            throw new ApiException("id not found");
        }
       driver1.setEmail(driver.getEmail());
        driver1.setPassword(driver.getPassword());
        driver1.setPhoneNumber(driver.getPhoneNumber());
        driverRepository.save(driver1);
    }

    public void deleteDriver(Integer id) {
        Driver driver = driverRepository.findDriversById(id);
        if (driver == null) {
            throw new ApiException("id not found");
        }
        driverRepository.delete(driver);
    }

    //---------------------------  end CRUD  ---------------------------------
}