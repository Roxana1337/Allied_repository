package automation.services.tests;

import automation.core.ExcelDataProvider;
import automation.core.UserPassGenerator;
import automation.services.actions.RegistrationLoginActions;
import automation.services.dto.BaseResponseDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class RegistrationPageTests {
    @Test(dataProvider = "RegistrationPageDataProvider", dataProviderClass = ExcelDataProvider.class)
    public void registrationPageTest(Map<String, String> inputMatrix) {
        String userName = inputMatrix.get("username");
        String password = inputMatrix.get("password");
        boolean sameUser = false;

        switch (userName) {
            case "valid":
                userName = UserPassGenerator.numberUCLCUserPass();
                break;
            case "tooShort":
                userName = UserPassGenerator.userShort();
                break;
            case "noUpperCase":
                userName = UserPassGenerator.userPassLCNo();
                break;
            case "noLowerCase":
                userName = UserPassGenerator.userPassUCNo();
                break;
            case "noNumber":
                userName = UserPassGenerator.userPassUCLC();
                break;
            case "nothing":
                userName = null;
                break;
            case "special":
                userName = UserPassGenerator.numberUCLCCharUserPass();
                break;
            case "validSameUser":
                userName = UserPassGenerator.numberUCLCUserPass();
                break;
            case "validSameUser2":
                userName = UserPassGenerator.numberUCLCUserPass();
                sameUser = true;
                break;
        }

        switch (password) {
            case "valid":
                password = UserPassGenerator.numberUCLCUserPass();
                break;
            case "tooShort":
                password = UserPassGenerator.passwordShort();
                break;
            case "noUpperCase":
                password = UserPassGenerator.userPassLCNo();
                break;
            case "noLowerCase":
                password = UserPassGenerator.userPassUCNo();
                break;
            case "noNumber":
                password = UserPassGenerator.userPassUCLC();
                break;
            case "nothing":
                password = null;
                break;
            case "special":
                password = UserPassGenerator.numberUCLCCharUserPass();
                break;
        }
        if (sameUser) {
            RegistrationLoginActions.registerNewUser(userName, password);
        }

        BaseResponseDTO registrationResult = RegistrationLoginActions.registerNewUser(userName, password);
        System.out.println(registrationResult.getErrorDescription());
        registrationResult.getResponseHeaders().stream().forEach(System.out::println);
        if (registrationResult.getResponseStatusCode() == 400) {
            Assert.assertTrue(registrationResult.getErrorDescription().contains(inputMatrix.get("errorDescription")),
                    "Validate that actual and expected error descriptions are correct");
        } else if (registrationResult.getResponseStatusCode() == 201) {
            Assert.assertEquals(registrationResult.getResponseStatusCode() + "", inputMatrix.get("statusCode"),
                    "Validate that actual and expected response status codes are equal");
        }
    }
}

