package com.cs393Project.cs393Project;

import com.cs393Project.cs393Project.models.*;
import com.cs393Project.cs393Project.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CarRepository carRepository;
    private final MemberRepository memberRepository;
    private final EquipmentRepository equipmentRepository;
    private final ServiceRepository serviceRepository;
    private final ReservationRepository reservationRepository;

    public DataInitializer(CarRepository carRepository, MemberRepository memberRepository,
                           EquipmentRepository equipmentRepository, ServiceRepository serviceRepository,
                           ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.equipmentRepository = equipmentRepository;
        this.serviceRepository = serviceRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add Cars
        Car car1 = new Car("CAR123", "34XYZ123", 5, "Toyota", "Corolla", 20000, "Automatic", 50.0, "AVAILABLE", "Standard");
        Car car2 = new Car("CAR456", "56ABC456", 7, "Honda", "Civic", 15000, "Manual", 60.0, "AVAILABLE", "SUV");
        carRepository.saveAll(List.of(car1, car2));

        // Add Members
        Member member1 = new Member("John Doe", "123 Elm St", "john@example.com", "555-1234", "DL12345");
        Member member2 = new Member("Jane Doe", "456 Oak St", "jane@example.com", "555-5678", "DL56789");
        memberRepository.saveAll(List.of(member1, member2));

        // Add Equipment
        Equipment gps = new Equipment("GPS", 15.0);
        Equipment babySeat = new Equipment("Baby Seat", 10.0);
        equipmentRepository.saveAll(List.of(gps, babySeat));

        // Add Services
        Service roadsideAssistance = new Service("Roadside Assistance", 20.0);
        Service additionalDriver = new Service("Additional Driver", 25.0);
        serviceRepository.saveAll(List.of(roadsideAssistance, additionalDriver));

        // Add Reservations
        Reservation reservation = new Reservation("R12345678", LocalDateTime.now(), LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(5), null, "CONFIRMED");
        reservation.setMember(member1);
        reservation.setCar(car1);
        reservation.setEquipmentList(List.of(gps));
        reservation.setServiceList(List.of(roadsideAssistance));
        reservationRepository.save(reservation);

        car1.setReservations(List.of(reservation));
        carRepository.save(car1);
    }
}
