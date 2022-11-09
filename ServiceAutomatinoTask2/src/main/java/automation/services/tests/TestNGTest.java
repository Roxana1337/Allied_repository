package automation.services.tests;

import automation.core.ExcelDataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class TestNGTest {
    @Test(dataProvider = "RegistrationPageDataProvider", dataProviderClass = ExcelDataProvider.class)
    public void test(Map<String, String> inputMatrix) {
        System.out.println("Running test: " + inputMatrix.get("TestName"));
        System.out.println("Username: " + inputMatrix.get("username"));
        System.out.println("Password: " + inputMatrix.get("password"));
    }
}
