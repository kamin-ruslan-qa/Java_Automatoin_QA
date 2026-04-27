package tests.testdata;

import net.datafaker.Faker;
import utils.RandomUtils;
import static utils.RandomUtils.getMonthNumber;


public class TestData
{
 public static final Faker faker = new Faker();
 private static final RandomUtils randomUtils = new RandomUtils();

 public static  String
         firstName = faker.name().firstName(),
         lastName = faker.name().lastName(),
         userEmail = faker.internet().emailAddress(),
         userNumber = faker.phoneNumber().subscriberNumber(10),
         gender = faker.options().option("Male", "Female", "Other"),
         year = String.valueOf(faker.number().numberBetween(1994, 2012)),
         month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
         day = String.valueOf(faker.number().numberBetween(1, 28)),
         subjects = faker.options().option("Maths", "Accounting", "Arts", "Biology", "Physics", "Chemistry", "Commerce", "History"),
         hobbies = faker.options().option("Sports", "Reading", "Music"),
         upload = faker.options().option("Test1.jpg", "Test2.jpg", "Test3.jpg"),
         currentAddress = faker.address().fullAddress(),
         state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
         city = randomUtils.getRandomCity(state),
         userName = firstName + " " + lastName,
         permanentAddress = faker.address().secondaryAddress(),
         dateOfBirth = String.format("%s-%02d-%02d", year, getMonthNumber(month), Integer.parseInt(day)),
         inCorrectEmail = firstName.toLowerCase() + "." + lastName.toLowerCase() + "ru",
         incorrectPhoneNumber = faker.phoneNumber().subscriberNumber(8);
}