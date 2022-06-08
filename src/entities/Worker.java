package entities;
import enums.WorkerLevel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
public class Worker {
    
    // basic attributes
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    
    // associations attributes
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();
    
    // methods
    // constructor -------------------------------------------------------------
    public Worker(String n, WorkerLevel l, Double bs, Department d) {
        this.name = n;
        this.level = l;
        this.baseSalary = bs;
        this.department = d;
    }
    
    // getters -----------------------------------------------------------------
    public String getName() {
        return name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }
    
    // setters -----------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // other methods -----------------------------------------------------------
    public void addContract(HourContract c) {
        this.getContracts().add(c);
    }
    
    public void removeContract(HourContract c) {
        this.getContracts().remove(c);
    }
    
    public Double income(Integer year, Integer month) {
        Double sum = this.getBaseSalary();
        Calendar cal = Calendar.getInstance();        
        for (HourContract c : this.getContracts()) {
            cal.setTime(c.getDate());            
            if (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month) {
                sum += c.totalValue();
            }
        }        
        return sum;
    }
    
}
