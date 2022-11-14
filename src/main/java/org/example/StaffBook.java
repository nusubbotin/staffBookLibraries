package org.example;

import java.util.Arrays;

public class StaffBook {
    Employee[] employees;

    public StaffBook(int length) {
        Employee.resetSequence();
        employees = new Employee[length];
    }

    private Employee getEmploy(int id) {
        return employees[id];
    }

    private void setEmploy(Employee employee) {
        employees[employee.getId()]= employee;
    }

    public void addEmploy(String fio, Department department, float salary){
        Employee employ = new Employee(fio, department, salary);
        setEmploy(employ);
    }
    public void editEmploy(int id, String fio, Department department, float salary){
        if (id > this.employees.length-1){
            throw new ArrayIndexOutOfBoundsException("Введен идентификатор Сотрудника, не работающего в компании");
        }

        Employee employ = getEmploy(id);

        if (employ == null) {
            throw new ArrayIndexOutOfBoundsException("Сотрудник, с указанным идентификатором еще не заведен в базу");
        }

        employ.setFio(fio);
        employ.setDepartment(department);
        employ.setSalary(salary);
        setEmploy(employ);
    }


    @Override
    public String toString() {
        return "StaffBook{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }

    // получить список всех сотрудников со всеми имеющимися по ним данными
    public void getStaffBook(){
        System.out.println("this = " + this);
        System.out.println();
    }

    // Посчитать сумму затрат на зарплаты в месяц
   public float calcMonthSalary(){
       float MonthSalary = 0;
       for (Employee employee : employees) {
           MonthSalary+= employee.getSalary();
       }
       return MonthSalary;
   }

   public float calcAverageSalary(){

       if (employees.length == 0){
           throw new ArrayIndexOutOfBoundsException("В компании нет ни одного сотрудника. ЗАведите сотрудников перед тем как использовать метод.");
       }
       return calcMonthSalary() / employees.length;
   }

   public Employee findEmployeeWithMinSalary(){
       if (employees.length == 0){
            throw new ArrayIndexOutOfBoundsException("В компании нет ни одного сотрудника. ЗАведите сотрудников перед тем как использовать метод.");
        }

       Employee employeeWithMinSalary = employees[0];

       for (Employee employee : employees) {
           if (employeeWithMinSalary.getSalary() > employee.getSalary()){
               employeeWithMinSalary = employee;
           }
       }
       return employeeWithMinSalary;
   }

    public Employee findEmployeeWithMaxSalary(){
        if (employees.length == 0){
            throw new ArrayIndexOutOfBoundsException("В компании нет ни одного сотрудника. Заведите сотрудников перед тем как использовать метод.");
        }

        Employee employeeWithMaxSalary = employees[0];

        for (Employee employee : employees) {
            if (employeeWithMaxSalary.getSalary() < employee.getSalary()){
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public void printOtherEmplWithThisEmplSalary(Employee employee){
        for (Employee empl : employees) {
            if (empl.getSalary() == employee.getSalary() && empl != employee) {
                System.out.println("А также с такой же зарплатой есть сотрудник: " + empl);
            }
        }

    }

    public void printAllSalaryFio(){
        for (Employee employee : employees) {
            System.out.println(employee.getFio());
        }
    }
}
