
public class Shturmovik extends  Military{

    public Shturmovik(String oil, int timenaliota, int salary, String Name, String level){
        this.timenaliota = timenaliota;
        this.salary = salary;
        this.Name = Name;
        this.level = level;
        this.oil=oil;
    }

    @Override
    public void Fly() {
        System.out.println("Flying");
    }

    @Override
    public void Scan() {
        System.out.println("Scanning...");
    }

    @Override
    public String ChooseOil(String temp) {
        this.oil = temp;
        return this.oil;
    }

    @Override
    public int MoreSalary() {
        if (this.timenaliota > 900) {
            this.salary +=300;
        }
        return this.salary;
    }
    public String getName() {
        return this.Name;
    }
    public String getOil() {
        return this.oil;
    }
    public int getsalary() {
        return this.salary;
    }
    public void UpgradeShturmovik (Shturmovik temp) {
        temp.salary+=10;
        temp.timenaliota +=200;
    }
    public void setsalary(int salary) throws IllegalArgumentException {
        if (salary> 0 && salary <100) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Pizdec");
        }
    }
}


