package co.com.sofka.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping (value = "api/todos")
    public Iterable<Todo> list(){//paso los metodos del service
        return todoService.list();
    }

    @PostMapping (value = "api/todo")
    public Todo save(@RequestBody Todo todo){//paso los metodos del service
        return todoService.save(todo);
    }

    @PutMapping (value = "api/todo")
    public Todo update(@RequestBody Todo todo){//paso los metodos del service
        if(todo.getId()!= null){
            return todoService.save(todo);
        } throw new RuntimeException("No existe el Id paraa actualizar");

    }

    @DeleteMapping (value = "api/{id}/todos")
    public void delete(@PathVariable("id")Long id){//paso los metodos del service
        todoService.delete(id);
    }

    @GetMapping (value = "api/{id}/todos")
    public Todo get(@PathVariable("id") Long id){
        return todoService.get(id);//paso los metodos del service
    }
}
