package com.vehicle.reports.controller;

import com.vehicle.reports.utility.DateUtility;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vehicle.reports.service.CsvExportService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reports")
public class RecordsController {

    private final CsvExportService csvExportService;

    public RecordsController(CsvExportService csvExportService) {
        this.csvExportService = csvExportService;
    }

    @RequestMapping(path = "/exportVehiclesToCSV")
    public void exportVehiclesToCSV(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; " +
                "filename=\"vehicles_"+ DateUtility.formatDate(DateUtility.getCurrentDate())+".csv\"");
        csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
    }
}
