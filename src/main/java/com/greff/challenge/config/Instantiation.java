package com.greff.challenge.config;

import com.greff.challenge.domain.Client;
import com.greff.challenge.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepo;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        clientRepo.deleteAll();

        Client client1 = new Client(null, "João",sdf.parse("12/09/2001"),"MALE", new Date());
        Client client2 = new Client(null, "Maria",sdf.parse("13/05/2003"), "FEMALE", new Date());
        Client client3 = new Client(null, "Pedro",sdf.parse("16/09/2000"),"MALE", new Date());
        Client client4 = new Client(null, "Ana",sdf.parse("22/09/2007"), "FEMALE", new Date());
        Client client5 = new Client(null, "Luiz",sdf.parse("22/12/2001"),"MALE", new Date());

        clientRepo.saveAll(Arrays.asList(client1,client2,client3,client4,client5));

    }
}
