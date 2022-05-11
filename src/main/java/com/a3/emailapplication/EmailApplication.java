package com.a3.emailapplication;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit //annotare f importanta pentru queues.
public class EmailApplication {

    //IDEE: CRED CA VOI FACE UN CONTROLLER CU O SINGURA METODA, NU STIU DACA POST SAU GET, DEPINDE CUM SE TRANSMIT DATELE
    //DE LA APLICATIA 1 LA ACEASTA, SI IN CONTROLLER VOI APELA O METODA DIN SERVICE UNDE TRIMIT MAILUL SAU FAC VERIFICARI
    //ALE USERULUI TRIMIS, DACA NU E NULL, BLAH BLAH. CONTROLLER-UL VA AVEA METODA CU URL-UL ACELASI DAT SI IN METODA DIN
    //APLICATIA 1. I REALLY HOPE THIS WORKS.
    //DUPA CE FAC TRANSMITEREA OKAY, O SA FAC SI SA ARATE FRUMOS IN HTML. DAR TREBUIE FACUTA SI CLASA AIA DE MESSAGE
    //IN CARE SA AM UN TEMPLATE HTML, SI IN CARE BAG NUMELE SI ETC PRINTR-O METODA PENTRU PERSONALIZARE.

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

}
