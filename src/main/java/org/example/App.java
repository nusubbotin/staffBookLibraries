package org.example;

import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {
        StaffBook staffBook = new StaffBook(10);

        staffBook.addEmploy("ильин руслан викторович", new Department("1", "кадры"), 100_000);
        staffBook.addEmploy("Селин Роман Викторович", new Department("1", "кадры"), 200_000);
        staffBook.addEmploy("Алексеев *Артем Викторович", new Department("2", "бухгалтерия"), 300_000);
        staffBook.addEmploy("Андрюшина_Елена Викторовна", new Department("2", "бухгалтерия"), 400_000);
        staffBook.addEmploy("Базаров Булат Викторович", new Department("3", "ИТ"), 500_000);

        staffBook.addEmploy("Базаров Булат Клон 1", new Department("3", "ИТ"), 500_000);
        staffBook.addEmploy("Базаров Булат Клон 2", new Department("3", "ИТ"), 500_000);
        staffBook.addEmploy("Базаров Булат Клон 3", new Department("3", "ИТ"), 500_000);
        staffBook.addEmploy("Базаров Булат Клон 4", new Department("3", "ИТ"), 500_000);
        staffBook.addEmploy("Базаров Булат Клон 5", new Department("3", "ИТ"), 500_000);

        System.out.println("Список всех сотрудников со всеми данными: ");
        staffBook.getStaffBook();
        System.out.println();

        System.out.println("Среднее значение зарплат: ");
        System.out.println("staffBook.calcMonthSalary() = " + staffBook.calcMonthSalary());
        System.out.println();

        System.out.println("Сотрудник с минимальной зарплатой: ");
        Employee employeeWithMinSalary = staffBook.findEmployeeWithMinSalary();
        System.out.println("employeeWithMinSalary = " + employeeWithMinSalary);
        staffBook.printOtherEmplWithThisEmplSalary(employeeWithMinSalary);
        System.out.println();

        System.out.println("Сотрудник с максимальной зарплатой: ");
        Employee employeeWithMaxSalary = staffBook.findEmployeeWithMaxSalary();

        System.out.println("employeeWithMaxSalary = " + employeeWithMaxSalary);
        staffBook.printOtherEmplWithThisEmplSalary(employeeWithMaxSalary);
        System.out.println();

        System.out.println("Среднее значение зарплат: ");
        System.out.println("staffBook.calcAverageSalary() = " + staffBook.calcAverageSalary());
        System.out.println();

        System.out.println("Список ФИО всех сотрудников:");
        staffBook.printAllSalaryFio();
        System.out.println();

        StaffBook staffBook2 = new StaffBook(2);
        staffBook2.addEmploy("Ильин Руслан Викторович", new Department("1", "кадры"), 100_000);
        System.out.println("Список всех сотрудников со всеми данными во Второй компании: ");
        staffBook2.getStaffBook();
        System.out.println();

        staffBook2.editEmploy(0, "Ильин Руслан Викторович", new Department("1", "ИТ"), 300_000);
        staffBook2.getStaffBook();
        System.out.println();
    }
}
