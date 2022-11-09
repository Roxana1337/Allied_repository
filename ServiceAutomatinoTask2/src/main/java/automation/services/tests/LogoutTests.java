package automation.services.tests;

import automation.core.UserPassGenerator;
import automation.services.actions.RegistrationLoginActions;
import automation.services.dto.BaseResponseDTO;
import org.apache.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class LogoutTests {

    @Test()
    public void logoutTest() {
        String username = UserPassGenerator.numberUCLCUserPass();
        String password = UserPassGenerator.numberUCLCUserPass();

        BaseResponseDTO registrationResult = RegistrationLoginActions.registerNewUser(username, password);
        System.out.println(registrationResult.getErrorDescription());
        registrationResult.getResponseHeaders().stream().forEach(System.out::println);
        String authToken = "";
        Optional<Header> optionalAuthTokenHeader = registrationResult.getResponseHeaders().stream()
                .filter(header -> header.getName().equals("AuthToken")).findFirst();
        if (optionalAuthTokenHeader.isPresent()) {
            Header header = optionalAuthTokenHeader.get();
            authToken = header.getValue();
        }

        BaseResponseDTO logoutResult = RegistrationLoginActions.logoutUser2(authToken);
        System.out.println(logoutResult.getErrorDescription());
        logoutResult.getResponseHeaders().stream().forEach(System.out::println);
        System.err.println(logoutResult.getErrorDescription());

        Assert.assertEquals(logoutResult.getResponseStatusCode(), 200);
    }
}
