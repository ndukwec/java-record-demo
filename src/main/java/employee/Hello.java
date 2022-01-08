package employee;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Hello {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        boolean another = true;
        while (another) {
            enterEmployeeInfoAndCalculateSalary();
            System.out.println("Would you like to calculate another Employee's salary? ");
            System.out.println("Enter true or false > ");
            another = in.nextBoolean();
        }
        System.out.println("See you later then :)");
    }

    private static void enterEmployeeInfoAndCalculateSalary() throws Exception {
        var in = new Scanner(System.in);
        System.out.println("Enter employee name > ");
        var name = in.nextLine();
        System.out.println("Enter employee monthly gross > ");
        var salary = in.nextLine();
        if (!Objects.equals(name, "") && !Objects.equals(salary, "")) {
            var me = new Employee(UUID.randomUUID().toString(), name, salary);
            System.out.printf("Employee info: %s%n", me);
            try {
                System.out.printf("Employee annual salary based on the amount entered is %s", calculateAnnualSalary(Integer.parseInt(me.salary())));

            } catch (Exception e) {
                throw new Exception("An error occurred when trying to calculate employee: %ss' annual salary: %s".formatted(name, e.getMessage()));
            }
            System.out.println("\n");
        } else {
            throw new Exception("You must've entered a wrong value for name or salary of the Employee somewhere " +
                    "while running this application, please try again");
        }
    }

    public static Integer calculateAnnualSalary(Integer salary) {
        return salary != 0 ? salary * 12 : 0;
    }
}
