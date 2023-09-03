package com.greff.challenge.config;

import com.greff.challenge.domain.Client;
import com.greff.challenge.domain.Disease;
import com.greff.challenge.domain.enums.Severity;
import com.greff.challenge.repository.ClientRepository;
import com.greff.challenge.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepo;
    @Autowired
    private DiseaseRepository diseaseRepository;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        clientRepo.deleteAll();
        diseaseRepository.deleteAll();

        Disease disease1 = new Disease("1", "Hypertension", Severity.TYPE2);
        Disease disease2 = new Disease("2", "Diabetes", Severity.TYPE1);
        Disease disease3 = new Disease("3", "Asthma", Severity.TYPE2);
        Disease disease4 = new Disease("4", "Migraine", Severity.TYPE1);
        Disease disease5 = new Disease("5", "Arthritis", Severity.TYPE2);

        List<Disease> diseases = Arrays.asList(disease1,disease2,disease3,disease4,disease5);
        diseaseRepository.saveAll(diseases);

        Client client1 = new Client(null, "João", sdf.parse("12/09/2001"), "MALE", new Date());
        Client client2 = new Client(null, "Maria", sdf.parse("13/05/2003"), "FEMALE", new Date());
        Client client3 = new Client(null, "Pedro", sdf.parse("16/09/2000"), "MALE", new Date());
        Client client4 = new Client(null, "Ana", sdf.parse("22/09/2007"), "OTHER", new Date());
        Client client5 = new Client(null, "Luiz", sdf.parse("22/12/2001"), "MALE", new Date());
        Client client6 = new Client(null, "Clara", sdf.parse("05/03/1999"), "FEMALE", new Date());
        Client client7 = new Client(null, "Carlos", sdf.parse("10/11/1995"), "MALE", new Date());
        Client client8 = new Client(null, "Laura", sdf.parse("18/07/2005"), "FEMALE", new Date());
        Client client9 = new Client(null, "André", sdf.parse("04/02/1998"), "MALE", new Date());
        Client client10 = new Client(null, "Beatriz", sdf.parse("21/10/2004"), "FEMALE", new Date());
        Client client11 = new Client(null, "José", sdf.parse("09/03/1997"), "MALE", new Date());
        Client client12 = new Client(null, "Gabriela", sdf.parse("30/08/2006"), "FEMALE", new Date());
        Client client13 = new Client(null, "Rafael", sdf.parse("14/06/1994"), "MALE", new Date());
        Client client14 = new Client(null, "Isabella", sdf.parse("25/01/2002"), "FEMALE", new Date());
        Client client15 = new Client(null, "Felipe", sdf.parse("03/12/1996"), "MALE", new Date());

        List<Client> clients = Arrays.asList(
                client1, client2, client3, client4, client5,
                client6, client7, client8, client9, client10,
                client11, client12, client13, client14, client15
        );

        client1.getDiseases().addAll(Arrays.asList(disease1, disease3, disease5));
        client2.getDiseases().addAll(Arrays.asList(disease2, disease4, disease1));
        client3.getDiseases().addAll(Arrays.asList(disease3, disease5, disease2));
        client4.getDiseases().addAll(Arrays.asList(disease4, disease1, disease3));
        client5.getDiseases().addAll(Arrays.asList(disease5, disease2, disease4));
        client6.getDiseases().addAll(Arrays.asList(disease1, disease3, disease5));
        client7.getDiseases().addAll(Arrays.asList(disease2, disease4, disease1));
        client8.getDiseases().addAll(Arrays.asList(disease3, disease5, disease2));
        client9.getDiseases().addAll(Arrays.asList(disease4, disease1, disease3));
        client10.getDiseases().addAll(Arrays.asList(disease5, disease2, disease4));
        client11.getDiseases().addAll(Arrays.asList(disease1, disease3, disease5));
        client12.getDiseases().addAll(Arrays.asList(disease2, disease4, disease1));
        client13.getDiseases().addAll(Arrays.asList(disease3, disease5, disease2));
        client14.getDiseases().addAll(Arrays.asList(disease4, disease1, disease3));
        client15.getDiseases().addAll(Arrays.asList(disease5, disease2, disease4));

        clientRepo.saveAll(clients);

    }
}
