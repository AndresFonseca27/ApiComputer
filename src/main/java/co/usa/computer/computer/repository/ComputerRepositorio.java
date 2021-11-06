package co.usa.computer.computer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.computer.computer.model.Computer;
import co.usa.computer.computer.repository.crud.ComputerCrudRepositorio;


@Repository
public class ComputerRepositorio {

    @Autowired
    private ComputerCrudRepositorio computerCrudRepositorio;

    public List<Computer> getAll(){
        return (List<Computer>)computerCrudRepositorio.findAll();
    }

    public Optional<Computer>getComputer(int id){
        return computerCrudRepositorio.findById(id);
    }

    public Computer save(Computer comp){
        return computerCrudRepositorio.save(comp);
    }


    
}
