package co.usa.computer.computer.repository.crud;

import org.springframework.data.repository.CrudRepository;

import co.usa.computer.computer.model.Reservation;

public interface ReservationCrudRepositorio extends CrudRepository<Reservation,Integer> {
    
}
