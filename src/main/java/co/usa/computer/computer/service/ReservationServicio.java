package co.usa.computer.computer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.computer.computer.model.Reservation;
import co.usa.computer.computer.repository.ReservationRepositorio;

@Service
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepositorio;

    public List<Reservation>getAll(){
        return reservationRepositorio.getAll();
    }
    
    public Optional<Reservation>getComputer(int id){
        return reservationRepositorio.getComputer(id);
    }

    public Reservation save(Reservation reserva){
        //Verificación si el Computador es Nuevo, si es nuevo se Guarda

        if (reserva.getIdReservation()==null){
            return reservationRepositorio.save(reserva);
        // Si el objeto vienen con unID Verificamos si existe o no    
        }else{
            Optional<Reservation> consulta=reservationRepositorio.getComputer(reserva.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepositorio.save(reserva);

            }else{
                return reserva;
            }
        }    
    }
}
