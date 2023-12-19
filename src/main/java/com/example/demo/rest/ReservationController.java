package com.example.demo.rest;

import com.example.demo.domain.Reservation;
import com.example.demo.domain.Room;
import com.example.demo.domain.User;
import com.example.demo.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservation/api")
public class ReservationController {
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/")
    private List<Reservation> getReservationList(){
        List<Reservation> reservationList= reservationRepository.getReservationList();
        return reservationList;
    }

    @GetMapping("/{id}")
    private Reservation getReservationById(@PathVariable(name = "id") long id){
        Optional<Reservation> reservationOptional= reservationRepository.getReservationById(id);
        if(reservationOptional.isPresent()){
            Reservation reservation= reservationOptional.get();
            return reservation;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("We can find your fucking room with %s id",id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    private Reservation addReservation(@RequestBody Reservation reservation){
        System.out.println(reservation);
        Reservation reservation1 = reservationRepository.add(reservation);
        return reservation1;
    }

    @PutMapping("/{id}")
    private Reservation updateReservation(@PathVariable(name = "id") long id, @RequestBody Reservation reservation){
        Optional<Reservation> reservationOptional = reservationRepository.getReservationById(id);
        if(reservationOptional.isPresent()){
            Reservation reservationDB = reservationOptional.get();
            reservationDB.setStart(reservation.getStart());
            reservationDB.setFinish(reservation.getFinish());
            reservationDB.setInfo(reservation.getInfo());
            reservationDB.setRoom(reservation.getRoom());
            reservationDB.setRoom(reservation.getRoom());
            reservationDB=reservationRepository.update(reservation);
            return reservationDB;
        }
        else {
            System.out.println(reservation);
            Reservation reservation1 = reservationRepository.add(reservation);
            return reservation1;
        }
    }

}
