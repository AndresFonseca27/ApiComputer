package co.usa.computer.computer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.computer.computer.model.Reservation;
import co.usa.computer.computer.repository.crud.ReservationCrudRepositorio;


@Repository
public class ReservationRepositorio {

    @Autowired
    private ReservationCrudRepositorio reservationCrudRepositorio;

    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrudRepositorio.findAll();
    }

    public Optional<Reservation>getComputer(int id){
        return reservationCrudRepositorio.findById(id);
    }

    public Reservation save(Reservation reserva){
        return reservationCrudRepositorio.save(reserva);
    }

    
}
