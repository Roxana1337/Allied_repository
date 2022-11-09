package automation.services.actions;

import automation.core.PropertyReader;
import automation.services.core.BaseAction;
import automation.services.dto.CurrencyNameResponseDTO;
import automation.services.dto.CurrencyRangeResponseDTO;

import java.util.HashMap;
import java.util.Map;

public class CurrencyActions extends BaseAction {

    public static CurrencyNameResponseDTO getCurrencyNames(String language, String date){
        Map<String, String> queryParametersCurrency = new HashMap<>();
        String currencyRates = PropertyReader.getProperty("currencyNamesUrl");
        queryParametersCurrency.put("date", date);
        queryParametersCurrency.put("lang", language);
        return get(currencyRates, queryParametersCurrency, null, CurrencyNameResponseDTO.class);
    }

    public static CurrencyNameResponseDTO getCurrencyNames(HashMap<String, String> queryParameters) {
        String currencyNamesUrl = PropertyReader.getProperty("currencyNamesUrl");
        return get(currencyNamesUrl,
                queryParameters,
                null,
                CurrencyNameResponseDTO.class);
    }

    public static CurrencyRangeResponseDTO getCurrencyRanges(HashMap<String, String> queryParameters, HashMap<String, String> headers){
        String currencyNamesUrl = PropertyReader.getProperty("exchangeRatesUrl");
        return get(currencyNamesUrl,
                queryParameters,
                headers,
                CurrencyRangeResponseDTO.class);
    }

}
