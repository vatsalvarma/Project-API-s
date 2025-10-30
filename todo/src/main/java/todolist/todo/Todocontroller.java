package todolist.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RestController
public class Todocontroller {

    List<Todo> todos = new ArrayList<>();

    public Todocontroller() {
        Todo t1 = new Todo(1,"vatsal", "pratice coding");
        todos.add(t1);
        Todo t2 = new Todo(2,"batman","save the city");
        todos.add(t2);
        Todo t3 = new Todo(3,"flash","run faster than light");
        todos.add(t3);
    }

    @GetMapping("/todos")
    public List<Todo> getAlltodos() {
        return todos;
    }

    @GetMapping("/todos/{Id}")
    public List<Todo> getById( @PathVariable int Id) {
        for(Todo t: todos){
            if(t.getId()==Id) {
                return Collections.singletonList(t);
            }
        }
        return null;
    }

    @PostMapping("/todos")
    public List createtodo(@RequestBody Todo to) {
        todos.add(to);
        return todos;

    }

    @PutMapping("/todos/{Id}")
    public List edittodo(@RequestBody Todo to, @PathVariable int Id) {
        for(Todo t: todos) {
            if(t.getId()==Id) {
                t.setName(to.getName());
                t.setTodo(to.getTodo());
            }
        }
        return todos;
    }

    @DeleteMapping("/todos/{Id}")
    public List deletetodo(@PathVariable int Id) {
        Iterator<Todo> iterator = todos.iterator();
          while(iterator.hasNext()) {
              Todo t = iterator.next();
              if(t.getId()==Id){
                  iterator.remove();
              }
          }
    return todos;
    }

}
