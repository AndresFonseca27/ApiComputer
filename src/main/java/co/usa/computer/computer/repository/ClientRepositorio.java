package co.usa.computer.computer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.computer.computer.model.Client;
import co.usa.computer.computer.repository.crud.ClientCrudRepositorio;

@Repository
public class ClientRepositorio {
    @Autowired
    private ClientCrudRepositorio clientCrudRepositorio;

    public List<Client> getAll(){
        return (List<Client>)clientCrudRepositorio.findAll();
    }

    public Optional<Client>getClient(int id){
        return clientCrudRepositorio.findById(id);
    }

    public Client save(Client cliente){
        return clientCrudRepositorio.save(cliente);
    } 
}
