/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author BossBeast
 */
public class PayrollSystemTest {

    public String toString() {
        // System.out.printf("Date current date %d %n", this);
        return String.format("%d/%d/%d", this);
    }

    public static void main(String[] args) {
        // create subclass objects
        Date1 currentDate = new Date1(5, 10, 2009);
        System.out.println("CurrentDate is " + currentDate);
        SalariedEmployee salariedEmployee
                = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, new Date1(6, 10, 1999));
        HourlyEmployee hourlyEmployee
                = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, new Date1(5, 3, 1975));
        CommissionEmployee commissionEmployee
                = new CommissionEmployee(
                        "Sue", "Jones", "333-33-3333", 10000, .06, new Date1(6, 7, 1975));
        BasePlusCommissionEmployee basePlusCommissionEmployee
                = new BasePlusCommissionEmployee(
                        "Bob", "Lewis", "444-44-4444", 5000, .04, 300, new Date1(9, 7, 1965));
        PieceWorker pieceWorker
                = new PieceWorker("Rick", "Bridges", "666-66-6666", 2.50, 600, new Date1(10, 8, 1960));
        System.out.println(pieceWorker.toString());
        System.out.println("earnings" + pieceWorker.getpieces());

        System.out.println("\nEmployees processed individually:");

        System.out.printf("%n%s%n%s: $%,.2f%n%n",
                salariedEmployee, "earned", salariedEmployee.earnings());

        System.out.printf("%s%n%s: $%,.2f%n%n",
                hourlyEmployee, "earned", hourlyEmployee.earnings());

        System.out.printf("%s%n%s: $%,.2f%n%n",
                commissionEmployee, "earned", commissionEmployee.earnings());

        System.out.printf("%s%n%s: $%,.2f%n%n",
                basePlusCommissionEmployee,
                "earned", basePlusCommissionEmployee.earnings());
        
        System.out.printf("%s%n%s: $%,.2f%n%n",
                pieceWorker,
                "earned", pieceWorker.earnings());
        

        // create four-element Employee array 
        Employee[] employees = new Employee[5];

        // initialize array with Employees
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorker;

        System.out.printf("Employees processed polymorphically:%n%n");

        // generically process each element in array employees 
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); // invokes toString

            // determine whether element is a BasePlusCommissionEmployee 
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee reference to 
                // BasePlusCommissionEmployee reference 
                BasePlusCommissionEmployee employee
                        = (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf(
                        "new base salary with 10%% increase is: $%,.2f%n",
                        employee.getBaseSalary());
            }
            if (currentEmployee.getbirthDate().getmonth() == currentDate.getmonth()) {
                double incrementedEarnings = currentEmployee.earnings() + 100;
                System.out.printf(
                        "earned $%,.2f%n%n", incrementedEarnings);
            }
            if (currentEmployee instanceof PieceWorker) {
                System.out.println("earnings: " + pieceWorker.earnings());
            }
            // get type name of each object in employees array
            System.out.println("----------------------------------");
            for (int j = 0; j < employees.length; j++) {

                System.out.printf("Employee %d is a %s%n", j,
                        employees[j].getClass().getName());
            }// for loop

        }
    }//main
}//class
