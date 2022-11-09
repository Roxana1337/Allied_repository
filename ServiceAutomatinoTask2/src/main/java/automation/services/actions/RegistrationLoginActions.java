package automation.services.actions;

import automation.core.PropertyReader;
import automation.services.core.BaseAction;
import automation.services.dto.BaseResponseDTO;
import automation.services.dto.CurrencyNameResponseDTO;
import automation.services.tests.LogoutTests;
import automation.services.tests.UnregisterTests;

import java.util.HashMap;
import java.util.Map;

public class RegistrationLoginActions extends BaseAction {

    public static BaseResponseDTO registerNewUser(String username, String password) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("username", username);
        queryParameters.put("password", password);
        String registerNewUserUrl = PropertyReader.getProperty("registrationUrl");
        return post(registerNewUserUrl,
                queryParameters,
                null,
                null,
                BaseResponseDTO.class);
    }

    public static BaseResponseDTO loginUser(String username, String password) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("username", username);
        queryParameters.put("password", password);
        String registerNewUserUrl = PropertyReader.getProperty("loginUrl");
        return post(registerNewUserUrl,
                queryParameters,
                null,
                null,
                BaseResponseDTO.class);
    }

//    public static BaseResponseDTO logoutUser(HashMap<String, String> headers) {
//        Map<String, String> queryParameters = new HashMap<>();
//        String registerNewUserUrl = PropertyReader.getProperty("logoutUrl");
//        return post(registerNewUserUrl,
//                queryParameters,
//                headers,
//                null,
//                BaseResponseDTO.class);
//    }

    public static BaseResponseDTO logoutUser2(String authToken) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("authToken", authToken);
        Map<String, String> queryParameters = new HashMap<>();
        String registerNewUserUrl = PropertyReader.getProperty("logoutUrl");
        return post(registerNewUserUrl,
                queryParameters,
                headers,
                null,
                BaseResponseDTO.class);
    }

    public static BaseResponseDTO unregisterUser(String authToken) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("authToken", authToken);
        Map<String, String> queryParameters = new HashMap<>();
        String registerNewUserUrl = PropertyReader.getProperty("unregisterUrl");
        return post(registerNewUserUrl,
                queryParameters,
                headers,
                null,
                BaseResponseDTO.class);
    }
}

