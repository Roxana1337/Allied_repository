package automation.services.dto;

import java.util.List;

public class CurrencyRangeResponseDTO extends BaseResponseDTO{

    private List<CurrencyRange> currenciesRange;

    public List<CurrencyRange> getCurrenciesRange() {
        return currenciesRange;
    }

    public void setCurrenciesRange(List<CurrencyRange> currenciesRange) {
        this.currenciesRange = currenciesRange;
    }

    @Override
    public String toString() {
        return "CurrencyRangeResponseDTO{" +
                "currenciesRange=" + currenciesRange +
                '}';
    }
}
