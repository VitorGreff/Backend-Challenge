package com.greff.challenge.service;

import com.greff.challenge.domain.Client;
import com.greff.challenge.dto.ClientDTO;
import com.greff.challenge.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;

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

    public Client update(String id, ClientDTO obj){
        Client aux = fromDTO(obj);
        Client newClient = findById(id);
        newClient.setId(id);
        newClient.setName(aux.getName());
        newClient.setGender(aux.getGender());
        newClient.setBirthDate(aux.getBirthDate());
        newClient.setCreationDate(findById(id).getCreationDate());
        newClient.setUpdateDate(new Date());
        return repo.save(newClient);
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
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

    public List<Client> getTenGreater(){
        return repo.findAll().stream()
                .sorted((a, b)-> a.compareTo(b)).
                collect(Collectors.toList()).
                subList(0, 10);
    }
}
