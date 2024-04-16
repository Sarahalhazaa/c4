package com.example.mylaundry.Repository;

import com.example.mylaundry.Model.Branch;
import com.example.mylaundry.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
    Driver findDriversById(Integer id);
}
