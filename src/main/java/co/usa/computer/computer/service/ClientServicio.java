package co.usa.computer.computer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.computer.computer.model.Client;
import co.usa.computer.computer.repository.ClientRepositorio;

@Service
public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepositorio;

    public List<Client>getAll(){
        return clientRepositorio.getAll();
    }
    
    public Optional<Client>getClient(int id){
        return clientRepositorio.getClient(id);
    }

    public Client save(Client cliente){
        //Verificación si el Computador es Nuevo, si es nuevo se Guarda

        if (cliente.getIdclient()==null){
            return clientRepositorio.save(cliente);
        // Si el objeto vienen con unID Verificamos si existe o no    
        }else{
            Optional<Client> consulta=clientRepositorio.getClient(cliente.getIdclient());
            if (consulta.isEmpty()) {
                return clientRepositorio.save(cliente);

            }else{
                return cliente;
            }
        }    
    }
    
}
