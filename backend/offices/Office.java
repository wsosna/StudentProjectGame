package backend.offices;

import backend.employees.Employee;
import backend.locations.City;

import java.util.List;

public interface Office {
    void hire(Employee employee);
    void fire(Employee employee);
    int getPrice();
    City getLocation();
    List<Employee> getEmployeeList();
    int getGain();

}
