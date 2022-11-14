package org.example;

import java.util.Objects;
import java.util.regex.Pattern;

import org.apache.commons.lang3.*;
import org.apache.commons.lang3.StringUtils;

public class Employee {
    private static int sequence = 0;

    private final int id;
    private String fio;
    private Department department;
    private float salary;


    public static String upperCaseAllFirstCharacter(String text) {
        String regex = "\\b(.)(.*?)\\b";
        return Pattern.compile(regex)
                .matcher(text)
                .replaceAll(e -> e.group(1).toUpperCase() + e.group(2));
    }

    public Employee(String fio, Department department, float salary) {
        this.id = genSeqNextVal();

        if (StringUtils.isEmpty(fio) || department == null || salary <= 0) {
            throw  new IllegalArgumentException("Некорректные входные данные. Один из параметров не заполнен");
        }else if (StringUtils.containsAny(fio, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_', '*')) {
            throw  new IllegalArgumentException("ФИО содержит запрещенные символы");
        }
        this.fio = StringUtils.capitalize(fio);
        // но так как ФИО в одном поле хранится
        this.fio = upperCaseAllFirstCharacter(fio);

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
