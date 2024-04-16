package com.example.mylaundry.Controller;

import com.example.mylaundry.Api.ApiResponse;
import com.example.mylaundry.Model.Driver;
import com.example.mylaundry.Service.DriverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/driver")
@RequiredArgsConstructor
public class DriverController {

    Logger logger = LoggerFactory.getLogger(DriverController.class);
    private final DriverService driverService;

    @GetMapping("/get")
    public ResponseEntity getDriver(){
        logger.info("inside the get all Driver");
        return ResponseEntity.status(200).body(driverService.getDriver());
    }

    @PostMapping("/add")
    public ResponseEntity addDriver(@RequestBody @Valid Driver driver){
        logger.info("inside add Driver");
        driverService.addDriver(driver);
        return ResponseEntity.ok().body(new ApiResponse("Driver added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateDriver(@PathVariable Integer id, @RequestBody @Valid Driver driver){
        logger.info("inside Update Driver");
        driverService.updateDriver(id,driver);
        return ResponseEntity.ok().body(new ApiResponse("Driver Update"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDriver(@PathVariable Integer id){
        logger.info("inside delete Driver");
        driverService.deleteDriver(id);
        return ResponseEntity.ok().body(new ApiResponse("Driver Deleted"));

    }
}
