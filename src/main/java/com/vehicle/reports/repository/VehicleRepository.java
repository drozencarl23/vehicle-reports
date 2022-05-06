package com.vehicle.reports.repository;

import com.vehicle.reports.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle,  Integer> {
    Page<Vehicle> findAllById(Long id, Pageable pageable);
    Page<Vehicle> findAllByVariantIgnoreCase(String variant, Pageable pageable);
    Page<Vehicle> findAllByBrandIgnoreCase(String brand, Pageable pageable);
    Page<Vehicle> findAllByColorIgnoreCase(String color, Pageable pageable);
    Page<Vehicle> findAllByEngineCapacity(Long engineCapacity, Pageable pageable);

    List<Vehicle> findAll();

}
