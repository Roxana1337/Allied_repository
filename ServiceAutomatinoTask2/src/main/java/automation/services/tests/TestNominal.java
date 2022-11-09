package automation.services.tests;

import automation.core.UserPassGenerator;
import automation.services.actions.CurrencyActions;
import automation.services.actions.RegistrationLoginActions;
import automation.services.dto.BaseResponseDTO;
import automation.services.dto.CurrencyRangeResponseDTO;
import org.apache.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import static automation.services.core.BNMAction.getValueFromBNM;

public class TestNominal {

    @Test
    public void test() throws IOException {

        BaseResponseDTO registrationResult = RegistrationLoginActions.registerNewUser(UserPassGenerator.numberUCLCUserPass(), UserPassGenerator.numberUCLCUserPass());
        String myDate = "04.11.2022";
        String myCharCode = "HUF";
        System.out.println(registrationResult.getErrorDescription());
        registrationResult.getResponseHeaders().stream().forEach(System.out::println);


        String authToken = "";
        Optional<Header> optionalAuthTokenHeader = registrationResult.getResponseHeaders().stream()
                .filter(header -> header.getName().equals("AuthToken")).findFirst();
        if (optionalAuthTokenHeader.isPresent()) {
            Header header = optionalAuthTokenHeader.get();
            authToken = header.getValue();
        }

        HashMap<String, String> authTokens = new HashMap<>();
        authTokens.put("authToken", authToken);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("datefrom", myDate);
        queryParams.put("dateto", myDate);
        queryParams.put("charcodes", myCharCode);

        CurrencyRangeResponseDTO resultFromCRA = CurrencyActions.getCurrencyRanges(queryParams, authTokens);
        int nominal = resultFromCRA.getCurrenciesRange().get(0).getCurrencies().get(0).getNominal();
        double valueFromBNM = getValueFromBNM(myCharCode, myDate);
        double valueFromHUF = resultFromCRA.getCurrenciesRange().get(0).getCurrencies().get(0).getValue();
        Assert.assertEquals(Math.round(valueFromHUF), Math.round(valueFromBNM/nominal));
    }
}