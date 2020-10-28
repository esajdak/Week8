import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.petstore.Pet;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://petstore.swagger.io/v2/pet/87");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Pet pet = mapper.readValue(response, Pet.class);
        assertEquals("doggie", pet.getName());


//        assertEquals("{\"id\":1,\"category\":{\"id\":2,\"name\":\"Cats\"},\"name\":\"Cat 1\",\"photoUrls\":[\"url1\",\"url2\"],\"tags\":[{\"id\":1,\"name\":\"tag1\"},{\"id\":2,\"name\":\"tag2\"}],\"status\":\"available\"}", response);
    }
}