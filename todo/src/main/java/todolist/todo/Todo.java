package todolist.todo;

import jakarta.persistence.Entity;

@Entity
public class Todo {
    int id;
    String name;
    String todo;

    public Todo(int id, String name, String todo) {
        this.id = id;
        this.name = name;
        this.todo = todo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
