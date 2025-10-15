package com.embarkx.firstspring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
public class controller {
    ArrayList<user> u = new ArrayList<>();


    public controller() {  // adding users and user data
        user u1 = new user(1,"vatsal","v@gmail.com");
        u.add(u1);
        user u2 = new user(2,"batman","bat@gmail.com");
        u.add(u2);
    }

    @GetMapping("/user") //getting all users
    public ArrayList<user> getAlluser() {
        return u;
    }

    @GetMapping("/user/{id}") //get user by id
    public ResponseEntity<user> getuserById(@PathVariable int id) {
        for(user us: u) {
            if(us.getId() == id) {
                return ResponseEntity.ok(us);
            }
        }
        return null;
    }

    @PostMapping("/user") //creating a new user
    public ResponseEntity<String> createuser(@RequestBody user us) {
          u.add(us);
          return ResponseEntity.ok("user addes");
    }

    @PutMapping("/user/{id}") //updating or edditing an existing user
    public ResponseEntity<String> edituser(@PathVariable int id, @RequestBody user ed) {
        for(user us : u) {
            if(us.getId()==id) {
              us.setName(ed.getName());
              us.setEmail(ed.getEmail());
              return ResponseEntity.ok("updated");
            }
        }
        return null;
    }

    @DeleteMapping("/user/{id}") //deleting an existing user
    public ResponseEntity<String> deleteuser(@PathVariable int id) {
        Iterator<user> iterator = u.iterator();
        while(iterator.hasNext()){
            user ud = iterator.next();
            if(ud.getId() == id) {
                iterator.remove();
                return ResponseEntity.ok("deleted");
            }
        }
        return null;
    }
}
