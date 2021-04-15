package com.example.demohibernate.controllers;

import com.example.demohibernate.models.Kompis;
import com.example.demohibernate.models.Message;
import com.example.demohibernate.repositories.KompisRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kompis")
public class KompisController {

    @Autowired
    private KompisRepository kompisRepository;

    @GetMapping(path = "/add")
    public String addKompis(@RequestParam String name, @RequestParam String address,@RequestParam String email,@RequestParam String telefon){
        Kompis kompis = new Kompis();
        kompis.setName(name);
        kompis.setAddress(address);
        kompis.setEmail(email);
        kompis.setTelefon(telefon);
        kompisRepository.save(kompis);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Kompis> getAll(){
        return kompisRepository.findAll();
    }

    @GetMapping(path = "/getByName")
    public Kompis getKompisByName(@RequestParam String name){
        return kompisRepository.findByName(name).stream().findFirst().orElse(null);
    }

    @GetMapping(path = "/deleteByName")
    public Message deleteKompisByName(@RequestParam String name){
        Message response = new Message(false, "Kompis deleted");
        Kompis kompis = kompisRepository.findByName(name).stream().findFirst().orElse(null);
        System.out.println(kompis.getName());
        kompisRepository.delete(kompis);
        return response;
    }

    @PostMapping("/upsert")
    public Message upsertKompis(@RequestParam Long id, @RequestParam String telefon ){
        Kompis kompis = kompisRepository.findById(id).orElse(null);
        System.out.println(kompis.getName());
        if(kompis != null){
            kompis.setTelefon(telefon);
            System.out.println(kompis.getTelefon());
            Message response = new Message(true, "Kompis updated");
            return response;

        }
        else {
            Message response = new Message(false, "Kompis not found");
            return response;

        }
    }
/*
        int kompisToUpdate = -1;
        for (int i = 0; i < myFriends.size(); i++){
            if(myFriends.get(i).getId() == k.getId()){
                kompisToUpdate = i;
            }
        }
        if(kompisToUpdate == -1){
            myFriends.add(k);
            Message m = new Message(true, "Friend was created");
            return m;
        }
        else{
            myFriends.set(kompisToUpdate, k);
            Message m = new Message(true, "Friend was updated");
            return m;
        }
*/
}
