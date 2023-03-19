package framework.helpers;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class StringHelpers {
    private static final Faker faker = new Faker();

    public static String generateValidFirstName() {
        return faker.name().firstName();
    }

    public static String generateValidLastName() {
        return faker.name().lastName();
    }

    public static String generateValidEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateValidPassword() {
        return faker.internet().password();
    }

    public static String generaValidBirthdate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(faker.date().birthday());
    }

    public static String generateValidAddress() {
        return faker.address().fullAddress();
    }

    public static String generatePostalCode() {
        return faker.address().zipCode().substring(0, 5);
    }

    public static String generateCity() {
        return faker.address().cityName();
    }
}
