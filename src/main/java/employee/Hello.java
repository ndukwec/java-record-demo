package employee;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Hello {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String name, salary;
        System.out.println("Enter employee name > _");
        name = in.nextLine();
        System.out.println("Enter employee monthly gross > _");
        salary = in.nextLine();
        if (!Objects.equals(name, "") && !Objects.equals(salary, "")) {
                try {
                    var me = new Employee(UUID.randomUUID().toString(), name, salary);
                    System.out.printf("Employee info: %s%n", me);
                    System.out.printf("Employee annual salary based on the amount entered is %s", calculateAnnualSalary(me.salary()));
                    System.out.println("\n");
                } catch (Exception e) {
                    throw new Exception("An error occurred: " + e.getMessage());
                }
        } else {
            throw new Exception("You must've entered a wrong value for name or salary of the Employee somewhere " +
                    "while running this application, please try again");
        }
    }

    public static Integer calculateAnnualSalary(String salaryStr) {
        return !Objects.equals(salaryStr, "") ? Integer.parseInt(salaryStr) * 12 : 0;
    }
}
