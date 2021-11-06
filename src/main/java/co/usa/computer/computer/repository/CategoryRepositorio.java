package co.usa.computer.computer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.computer.computer.model.Category;
import co.usa.computer.computer.repository.crud.CategoryCrudRepositorio;

@Repository
public class CategoryRepositorio {
    @Autowired
    private CategoryCrudRepositorio categoryCrudRepositorio;

    public List<Category> getAll(){
        return (List<Category>)categoryCrudRepositorio.findAll();
    }

    public Optional<Category>getCategory(int id){
        return categoryCrudRepositorio.findById(id);
    }

    public Category save(Category comp){
        return categoryCrudRepositorio.save(comp);
    }
}
