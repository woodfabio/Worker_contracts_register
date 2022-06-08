package application;
import entities.Department;
import entities.Worker;
import entities.HourContract;
import enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class ex003_composicao_prog {
    public static void main(String[] args) throws ParseException {
        
        // register contracts --------------------------------------------------
        Department dep = new Department();
        String wname;    // worker name
        WorkerLevel lvl; // worker level
        Double bs;       // worker base salary
        int conts;       // worker contracts
        
        Scanner t = new Scanner(System.in);
        System.out.println("Enter department's name: ");
        dep.setName(t.nextLine());
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        wname = t.nextLine();
        System.out.println("Level: ");
        lvl = WorkerLevel.valueOf(t.nextLine());
        System.out.println("Base salary: ");
        bs = t.nextDouble();
        
        Worker w = new Worker(wname, lvl, bs, dep);
        
        System.out.println("How many contracts to this worker?: ");
        conts = t.nextInt();
        
        for (int i=1; i <= conts; i++) {
            Date date;     // contract date
            Double vph;    // contract value per hour
            Integer hours; // contract hours
            
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.println("Enter contract #" + i + " data: ");
            System.out.println("Date (DD/MM/YYYY): ");
            t.nextLine(); // remove line break
            date = sdf1.parse(t.nextLine());
            System.out.println("Value per hour: ");
            vph = t.nextDouble();
            System.out.println("Duration (hours): ");
            hours = t.nextInt();
            
            HourContract c = new HourContract(date, vph, hours);            
            w.addContract(c);
        }
        
        // check contracts -----------------------------------------------------
        Date datecheck; // date to select related contracts        
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
        Calendar calprog = Calendar.getInstance();
        
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        t.nextLine(); // remove line break
        datecheck = sdf2.parse(t.nextLine());
        calprog.setTime(datecheck);
        int month = calprog.get(Calendar.MONTH);
        int year = calprog.get(Calendar.YEAR);
        
        System.out.println("Name: " + w.getName());
        System.out.println("Department: " + w.getDepartment().getName());
        System.out.printf("Income for %02d/%d: ", month+1, year);
        System.out.printf("R$%.2f\n", w.income(year, month));
    }
    
}
