package com.cs393Project.cs393Project.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String barcode;
    private String licensePlateNumber;
    private int passengerCapacity;
    private String brand;
    private String model;
    private int mileage;
    private String transmissionType;
    private double dailyPrice;
    private String status;
    private String carType;

    @OneToMany(mappedBy = "car", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    public Car() {}

    public Car(String barcode, String licensePlateNumber, int passengerCapacity, String brand, String model, int mileage, String transmissionType, double dailyPrice, String status, String carType) {
        this.barcode = barcode;
        this.licensePlateNumber = licensePlateNumber;
        this.passengerCapacity = passengerCapacity;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.transmissionType = transmissionType;
        this.dailyPrice = dailyPrice;
        this.status = status;
        this.carType = carType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
