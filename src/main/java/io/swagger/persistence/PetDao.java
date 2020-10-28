package io.swagger.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.petstore.Pet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class PetDao {

    Pet getPetById() {
        Client client = ClientBuilder.newClient();
//        todo should be reading the uri in from a properties file
        WebTarget target =
                client.target("https://petstore.swagger.io/v2/pet/87");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Pet pet = null;
        try {
            pet = mapper.readValue(response, Pet.class);
        } catch (JsonProcessingException e) {
//            todo set up logging & write this to log
            e.printStackTrace();
        }
        return pet;
    }

}
