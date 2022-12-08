public class EmployeeRunner
{
    public static void main(String[] args)
    {
        Employee employee1 = new Employee("Jim", "Mason");
        employeeTest(employee1);

        Employee employee2 = new Employee("Amy", "Adams");
        employeeTest(employee2);

        Employee employee3 = new Employee("Bob", "Ross");
        employeeTest(employee3);

        Employee employee4 = new Employee("Cindy", "Nox");
        employeeTest(employee4);

        System.out.println("==============================");
        employeeTest(employee1);
        employeeTest(employee2);
        employeeTest(employee3);
        employeeTest(employee4);
    }

    public static void employeeTest(Employee employee)
    {
        System.out.println("Employee's full name: " + employee.getFullName());
        // finish writing me:
        System.out.println("Employee's ID number: " + employee.getIdNum());
        System.out.println("Most Recent Employee ID: " + employee.recentIdNum());
        System.out.println("Total Employees: " + employee.numOfEmployees());
        System.out.println("-----");

    }
}
