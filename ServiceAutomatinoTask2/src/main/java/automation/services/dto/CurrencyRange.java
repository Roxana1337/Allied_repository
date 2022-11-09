package automation.services.dto;

import java.util.List;

public class CurrencyRange extends BaseResponseDTO{

    private List<Currency> currencies;
    private String date;
    private String name;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CurrencyRange{" +
                "currencies=" + currencies +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
