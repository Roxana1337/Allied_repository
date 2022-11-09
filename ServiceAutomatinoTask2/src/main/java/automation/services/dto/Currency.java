package automation.services.dto;

public class Currency {

    private Integer nominal;
    private String charCode;

    private Double value;
    private String name;
    private Integer numCode;
    private Integer id;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumCode() {
        return numCode;
    }

    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "nominal=" + nominal +
                ", charCode='" + charCode + '\'' +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", numCode=" + numCode +
                ", id=" + id +
                '}';
    }
}
