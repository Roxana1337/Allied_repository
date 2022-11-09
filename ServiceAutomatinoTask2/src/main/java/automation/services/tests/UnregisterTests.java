package automation.services.tests;

import automation.core.UserPassGenerator;
import automation.services.actions.RegistrationLoginActions;
import automation.services.dto.BaseResponseDTO;
import org.apache.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Optional;

public class UnregisterTests {
    @Test()
    public void unregisterTest() {

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

        System.err.println(authToken);

        BaseResponseDTO unregisterResult = RegistrationLoginActions.unregisterUser(authToken);
        System.out.println(unregisterResult.getErrorDescription());
        unregisterResult.getResponseHeaders().stream().forEach(System.out::println);
        Assert.assertEquals(unregisterResult.getResponseStatusCode(), 200);
        BaseResponseDTO loginResult = RegistrationLoginActions.loginUser(username, password);
        Assert.assertEquals(loginResult.getResponseStatusCode(),401);
    }
}
