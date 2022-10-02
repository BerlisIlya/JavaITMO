package JavaAdvanced.Lec02_01;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public final boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof Employee)) return false;
        Employee e = (Employee) other;
        return name.equals(e.name);
    }

    public final int hashCode() {
        return name.hashCode();
    }

    public void prettyPrint(String s) {

        String jobTitle = getClass().getName();
        System.out.printf("%s" + "%s" + " (%s) " + "%s" + "\n", s, getName(), getSalary(), jobTitle);
    }
}

class Manager extends Employee {
    public Manager(String name, double salary, Employee[] es) {
        super(name, salary);
        bonus = 0;
        if (es != null) {
            for (Employee employee : es) {
                add(employee);
            }
        }
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }

    public void add(Employee sub) {
        if (!subs.contains(sub)) {
            subs.add(sub);
        }
    }

    public void remove(Employee sub) {
        subs.remove(sub);
    }

    private double bonus;
    private List<Employee> subs = new ArrayList<>();
    public void prettyPrint(String s) {

        String jobTitle = getClass().getName();
        System.out.printf("%s" + "%s" + " (%s) " + "%s" + "\n", s, getName(), getSalary(), jobTitle);

        for (Employee e : subs) {
            e.prettyPrint("   " + s);
        }
    }
}
