package com.vehicle.reports.service;

import com.vehicle.reports.model.Vehicle;
import com.vehicle.reports.repository.VehicleRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class CsvExportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvExportService.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    public void writeEmployeesToCsv(Writer writer) throws IOException {

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Vehicle vehicle : vehicleList) {
                csvPrinter.printRecord(vehicle.getId(), vehicle.getVariant(), vehicle.getBrand()
                        , vehicle.getColor(), vehicle.getEngineCapacity());
            }
        } catch (IOException e) {
            LOGGER.error("Error While writing CSV ", e);
        }
    }
}
