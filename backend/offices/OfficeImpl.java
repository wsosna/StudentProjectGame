package backend.offices;

import backend.employees.Employee;
import backend.locations.City;

import java.util.ArrayList;
import java.util.List;

public class OfficeImpl
    implements Office{
    private int price;
    private final City location;
    private List<Employee> employeeList;
    private int gain;

    public OfficeImpl(City location) {
        this.location = location;
        employeeList = new ArrayList<>();
        gain = 0;
        price = 300;
    }

    @Override
    public void hire(Employee employee) {
        employeeList.add(employee);
        gain += employee.getGain();
    }

    @Override
    public void fire(Employee employee) {

    }

    @Override
    public City getLocation() {
        return location;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public int getGain() {
        return gain;
    }

    @Override
    public String toString() {
        return "Biuro z "+location;
    }

}
