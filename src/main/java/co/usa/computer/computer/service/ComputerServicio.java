package co.usa.computer.computer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.computer.computer.model.Computer;
import co.usa.computer.computer.repository.ComputerRepositorio;

@Service
public class ComputerServicio {
    @Autowired
    private ComputerRepositorio computerRepositorio;

    public List<Computer>getAll(){
        return computerRepositorio.getAll();
    }

    public Optional<Computer>getComputer(int id){
        return computerRepositorio.getComputer(id);
    }

    public Computer save(Computer comp){
        //Verificación si el Computador es Nuevo, si es nuevo se Guarda

        if (comp.getId()==null){
            return computerRepositorio.save(comp);
        // Si el objeto vienen con unID Verificamos si existe o no    
        }else{
            Optional<Computer> consulta=computerRepositorio.getComputer(comp.getId());
            if (consulta.isEmpty()) {
                return computerRepositorio.save(comp);

            }else{
                return comp;
            }
        }    
    }
    
}
