package org.example;

import java.util.Objects;

public class Employee {
    private static int sequence = 0;

    private final int id;
    private String fio;
    private Department department;
    private float salary;

    public Employee(String fio, Department department, float salary) {
        this.id = genSeqNextVal();
        this.fio = fio;
        this.department = department;
        this.salary = salary;
    }

    public static void resetSequence() {
        Employee.sequence = 0;
    }

    private static int genSeqNextVal() {
        return sequence++;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public Department getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{ id=" + id + ", fio=" + fio + ", department=" + department + ", salary=" + salary + "}\n" ;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Employee employee = (Employee) other;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
