import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.regex.Pattern;

public class IntegrationData {
    private final boolean checkboxi;
    private final String email;

    // Private constructor to ensure the factory method is used for object creation
    private IntegrationData(boolean checkboxi, String email) {
        this.checkboxi = checkboxi;
        this.email = email;
    }

    // Static factory method for object creation
    @JsonCreator
    public static IntegrationData create(
            @JsonProperty("checkboxi") String checkboxiStr,
            @JsonProperty("email") String email) {

        // Convert "k" or "e" to boolean
        boolean checkboxi = "k".equals(checkboxiStr);

        // Validate email format
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        return new IntegrationData(checkboxi, email);
    }

    // Email validation method
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }

    // Getters
    public boolean isCheckboxi() {
        return checkboxi;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "{" +
                "checkboxi=" + checkboxi +
                ", email='" + email + '\'' +
                '}';
    }
}
