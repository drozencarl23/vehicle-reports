package com.vehicle.reports.enums;

enum VehicleEnum {
    CAR("Car"),
    MOTORCYCLE("Motorcycle");

    String variant;

    VehicleEnum(String variant) {
        this.variant = variant;
    }
}
