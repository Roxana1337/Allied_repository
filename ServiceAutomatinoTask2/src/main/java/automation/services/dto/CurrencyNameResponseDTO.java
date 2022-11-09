package automation.services.dto;

import java.util.List;

public class CurrencyNameResponseDTO extends BaseResponseDTO {
    private List<String> currencyNames;

    public List<String> getCurrencyNames() {
        return currencyNames;
    }

    public void setCurrencyNames(List<String> currencyNames) {
        this.currencyNames = currencyNames;
    }
}
