import entity.Employee;

public class Domain {
    public static void main(String[] args)
    {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Evgenia");
        employee.setLastName("Nikolaeva");

        System.out.println(employee);
    }
}
