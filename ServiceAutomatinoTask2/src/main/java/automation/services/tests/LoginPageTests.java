package automation.services.tests;

import automation.core.ExcelDataProvider;
import automation.core.UserPassGenerator;
import automation.services.actions.RegistrationLoginActions;
import automation.services.dto.BaseResponseDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginPageTests {
    @Test(dataProvider = "LoginPageDataProvider", dataProviderClass = ExcelDataProvider.class)
    public void loginPageTest(Map<String, String> inputMatrix) {
        String username = inputMatrix.get("username");
        String password = inputMatrix.get("password");

        if(username.equals("existingUser")) {
            username = "UserTest1";
        } else if(username.equals("valid")) {
            username = UserPassGenerator.numberUCLCUserPass();
        }

        if(password.equals("existingPassword")) {
            password = "PassTest1";
        } else if(password.equals("valid")) {
            password = UserPassGenerator.numberUCLCUserPass();
        }



        BaseResponseDTO loginResult = RegistrationLoginActions.loginUser(username, password);
        System.out.println(loginResult.getErrorDescription());
        loginResult.getResponseHeaders().stream().forEach(System.out::println);
        if (loginResult.getResponseStatusCode() == 400) {
            Assert.assertTrue(loginResult.getErrorDescription().contains(inputMatrix.get("errorDescription")),
                    "Validate that actual and expected error descriptions are correct");
        } else if (loginResult.getResponseStatusCode() == 200) {
            Assert.assertEquals(loginResult.getResponseStatusCode() + "", inputMatrix.get("statusCode"),
                    "Validate that actual and expected response status codes are equal");
        }
    }
}
