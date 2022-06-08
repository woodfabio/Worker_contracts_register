package entities;
import java.util.Date;
public class HourContract {
    
    // atributes
    private Date date;
    private Double valuePerHour;
    private Integer hours;
    
    // methods
    // constructor -------------------------------------------------------------
    public HourContract(Date date, Double valuePerHour, Integer hours) {    
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    // getters -----------------------------------------------------------------
    public Date getDate() {
        return date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }
    
    // setters -----------------------------------------------------------------
    public void setDate(Date date) {
        this.date = date;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
    
    // other methods -----------------------------------------------------------
    public Double totalValue() {
        Double tv = this.valuePerHour * this.hours;
        return tv;
    }
}
