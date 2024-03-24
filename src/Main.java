import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        String json = "{\"checkboxi\": \"k\", \"email\": \"asdf@example.com\"}";
        ObjectMapper mapper = new ObjectMapper();

        IntegrationData data = mapper.readValue(json, IntegrationData.class);
        System.out.println("isCheckboxi: " + data.isCheckboxi());
        System.out.println(data.toString());

    }
}

