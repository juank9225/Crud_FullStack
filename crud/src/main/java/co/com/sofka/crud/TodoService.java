package co.com.sofka.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    //inyectamos el repositorio
    @Autowired
    private TodoRepository repository;
    //.....................

    public Iterable<Todo> list(){//listar todos
        return repository.findAll();
    }

    public Todo save(Todo todo){//guardar todos
        return repository.save(todo);
    }

    public void delete(Long id){//eliminar
        repository.delete(get(id));
    }

    public Todo get(Long id){//optener id para eliminar
         return repository.findById(id).orElseThrow();
    }
}
