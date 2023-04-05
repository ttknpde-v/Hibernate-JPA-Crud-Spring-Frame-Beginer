package net.spring.coding.controller;


import net.spring.coding.model.Employee;
import net.spring.coding.repository.EmployeeRepository;
import net.spring.coding.service.EmployeeService;

import java.util.List;


public class Application {
    private EmployeeRepository employeeRepository;
    public Application () {

        this.employeeRepository = new EmployeeService();

    }

    public void test() {
/*
        ///// READ return Class Object[] type Array
        List<Object[]> rows = employeeService.read();
        for (Object[] row : rows) {
            Employee employee = new Employee();
            employee.setId(Long.parseLong(row[0].toString()));
            employee.setName((row[1].toString()));
            employee.setEmail((row[2].toString()));
            employee.setPhone((row[3].toString()));
            employee.setCity((row[4].toString()));
            employee.setPosition((row[5].toString()));
            System.out.println(employee);
*/


/*
        ///// CREATE
        Employee employee = new Employee();
        employee.setName("Physical");
        employee.setEmail("Physical@hotmail.com");
        employee.setPhone("0741277799");
        employee.setCity("Bangkok");
        employee.setPosition("C++ Developer");
        System.out.println(employeeRepository.create(employee));
*/


/*
        ///// READ
        List<Employee> employeesList = employeeRepository.read();
        for (Employee employee : employeesList) {
            System.out.println(employee);
        }
//        System.out.println(employeesList.get(0));
//        System.out.println(employeesList.get(1));
//        System.out.println(employeesList.get(2));
*/


/*
        ///// READ BY ID
        System.out.println(employeeRepository.readById(6l));
*/


/*
        ///// UPDATE
        Employee employee = new Employee();
        employee.setName("Golang");
        employee.setEmail("Golang@hotmail.com");
        employee.setPhone("0888777998");
        employee.setCity("Bangkok");
        employee.setPosition("Basic Developer");
        employeeRepository.update(employee,6l);
        System.out.println(employeeRepository.readById(6l));
*/


/*
        ///// DELETE
        employeeRepository.delete(6l);
*/

/*      System.out.println(employeeRepository.readById(6l)); */
}
    public static void main(String[] args) {
        new Application().test();
    }
}
