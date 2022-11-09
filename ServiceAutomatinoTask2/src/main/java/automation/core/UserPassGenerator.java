package automation.core;

import automation.services.tests.RegistrationPageTests;
import org.apache.commons.lang3.RandomStringUtils;

import java.awt.*;

public class UserPassGenerator {


    public static String userPassLC() {
        return RandomStringUtils.random(10, true, false).toLowerCase();
    }

    public static String userPassUC() {
        return RandomStringUtils.random(10, true, false).toUpperCase();
    }

    public static String userPassUCLC() {
        return RandomStringUtils.random(10, true, false);
    }

    public static String numberUserPass() {
        return RandomStringUtils.random(10, false, true);
    }

    public static String numberUCLCCharUserPass() {
        String part1OfUsername = RandomStringUtils.random(2, true, false).toLowerCase();
        String part2OfUsername = RandomStringUtils.random(2, true, false).toUpperCase();
        String part3OfUsername = RandomStringUtils.random(2, false, true);
        String part4OfUsername = "șșș";
        return (part1OfUsername + part2OfUsername + part3OfUsername + part4OfUsername);
    }

    public static String numberUCLCUserPass() {
        String part1OfUsername = RandomStringUtils.random(2,true,false).toUpperCase();
        String part2OfUsername = RandomStringUtils.random(2,true,false).toLowerCase();
        String part3OfUsername = RandomStringUtils.random(2,false,true);
        return (part1OfUsername + part2OfUsername + part3OfUsername);
    }

    public static String userShort() {
        String part1OfUsername = RandomStringUtils.random(1, true, false).toLowerCase();
        String part2OfUsername = RandomStringUtils.random(1, true, false).toUpperCase();
        String part3OfUsername = RandomStringUtils.random(1, false, true);
        return (part1OfUsername + part2OfUsername + part3OfUsername);
    }

    public static String passwordShort() {
        String part1OfPassword = RandomStringUtils.random(1,true,false).toLowerCase();
        String part2OfPassword = RandomStringUtils.random(1,true,false).toUpperCase();
        String part3OfPassword = RandomStringUtils.random(3,false,true);
        return (part1OfPassword + part2OfPassword + part3OfPassword);
    }

    public static String userPassUCNo() {
        return RandomStringUtils.random(6,true,true).toUpperCase();
    }

    public static String userPassLCNo() {
        return RandomStringUtils.random(6,true,true).toLowerCase();
    }
}
