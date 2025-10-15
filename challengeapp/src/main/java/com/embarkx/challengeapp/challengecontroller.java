package com.embarkx.challengeapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;

@RestController
public class challengecontroller {

    ArrayList<challenge> c = new ArrayList<>();

    public challengecontroller() {
        challenge c1 = new challenge(12, "vatsal build a larege project");
        c.add(c1);
        challenge c2 = new challenge( 22, "batman kill them all");
        c.add(c2);
    }

    @GetMapping ("/challenge")
    public ResponseEntity<ArrayList<challenge>> getAllChallenges() {
        return ResponseEntity.ok(c);
    }

    @GetMapping("/challenge/{Id}")
    public ResponseEntity<challenge> getbyid(@PathVariable int Id) {
        for(challenge ch: c) {
            if(ch.getId() == Id)
                return ResponseEntity.ok(ch);
        }
        return null;
    }

    @PostMapping("/challenge")
    public ResponseEntity<String> addchallenge(@RequestBody challenge addc) {
        c.add(addc);
        return ResponseEntity.status(HttpStatus.CREATED).body("challenge added");
    }

    @PutMapping("/challenge/{Id}")
    public ResponseEntity<String> updatechallenge(@PathVariable int Id, @RequestBody challenge uc) {
         for(challenge ch : c) {
             if (ch.getId() == Id) {
                 ch.setName(uc.getName());
                 return ResponseEntity.ok("challenge updated");
             }
         }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("challenge notfound!");
    }

    @DeleteMapping("/challenge/{Id}")
    public ResponseEntity<String> deletechallenge(@PathVariable int Id) {
        Iterator<challenge> iterator = c.iterator();
        while(iterator.hasNext()) {
            challenge ch = iterator.next();
            if(ch.getId() == Id){
                iterator.remove();
                return ResponseEntity.ok("challenge deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("challenge not forund");
    }

}
