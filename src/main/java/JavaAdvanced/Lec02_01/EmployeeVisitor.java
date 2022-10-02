package JavaAdvanced.Lec02_01;

import java.util.ArrayList;
import java.util.List;

public class EmployeeVisitor {
    private String name;
    private double salary;
    public EmployeeVisitor(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public final boolean equals(Object other)  {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof EmployeeVisitor)) return false;
        EmployeeVisitor e = (EmployeeVisitor) other;
        return name.equals(e.name);
    }

    public final int hashCode() {
        return name.hashCode();
    }

    void accept(Visitor visitor, String indent) {
        visitor.visit(this, indent);
    }
}

class ManagerVisitor extends EmployeeVisitor {
    public ManagerVisitor(String name, double salary, EmployeeVisitor[] es) {
        super(name, salary);
        bonus = 0;
        if (es != null) {
            for (EmployeeVisitor visitor : es) {
                add(visitor);
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

    public void add(EmployeeVisitor sub) {
        if (!subs.contains(sub)) {
            subs.add(sub);
        }
    }

    public void remove(EmployeeVisitor sub) {
        subs.remove(sub);
    }

    void accept(Visitor visitor, String indent) {
        visitor.visit(this, indent);
        for (EmployeeVisitor e : subs) {
            e.accept(visitor, indent + "   ");
        }
    }

    private double bonus;
    private List<EmployeeVisitor> subs = new ArrayList<EmployeeVisitor>();
}
