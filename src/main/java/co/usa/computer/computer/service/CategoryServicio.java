package co.usa.computer.computer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.computer.computer.model.Category;
import co.usa.computer.computer.repository.CategoryRepositorio;

@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio;

    public List<Category>getAll(){
        return categoryRepositorio.getAll();
    }
    
    public Optional<Category>getCategory(int id){
        return categoryRepositorio.getCategory(id);
    }

    public Category save(Category categ){
        //Verificación si el Computador es Nuevo, si es nuevo se Guarda

        if (categ.getId()==null){
            return categoryRepositorio.save(categ);
        // Si el objeto vienen con unID Verificamos si existe o no    
        }else{
            Optional<Category> consulta=categoryRepositorio.getCategory(categ.getId());
            if (consulta.isEmpty()) {
                return categoryRepositorio.save(categ);

            }else{
                return categ;
            }
        }    
    }
    
}
