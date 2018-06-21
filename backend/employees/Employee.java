package backend.employees;


abstract public class Employee {
    public static int SALARY;
    public static int GAIN;

    public Employee(int SALARY, int GAIN) {
        this.SALARY = SALARY;
        this.GAIN = GAIN;
    }

    public int getSALARY() {
        return SALARY;
    }

    public int getGain() {
        return GAIN;
    }

    abstract public void payEmployee();
}
