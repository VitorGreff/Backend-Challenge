package com.greff.challenge.service;

import com.greff.challenge.domain.Client;
import com.greff.challenge.dto.ClientDTO;
import com.greff.challenge.repository.ClientRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repo;

    public List<Client> findAll(){
        return repo.findAll();
    }
    public Client insertClient(Client client){
        return repo.insert(client);
    }

    public Client findById(String id){
        Optional<Client> client = repo.findById(id);
        return client.orElseThrow();
    }

    public Client fromDTO(ClientDTO obj){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Client client = null;
        try {
            client = new Client(null, obj.getName(), sdf.parse(obj.getBirthDate()), obj.getGender(), new Date());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return client;
    }
}
