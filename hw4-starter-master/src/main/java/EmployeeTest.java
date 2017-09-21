import edu.gcccd.csis.Company;

public class EmployeeTest {



    public static void main(String[] args) {
        Employee e1, e2, e3;

        e1 = new Employee();
        e2 = new Employee("Juan Querendon", "CEO", "Google", 6151995);
        e3 = new Employee("Maria Macarena", "Accountant", "Amazon", 5251992);

        Company c1, c2, c3;
        c3 =  new Company();
        c1 = new Company("Google",5 );
        c2 = new Company("Microsoft", 3) ;



            //equals operator not comparing containing values
           if (e1 == e2) {
            System.out.println(" Employees are the same \n");
        } else {
            System.out.println("Employees are different\n");

            }
        System.out.println("\n");


        //calling equals method comparing containing values.
        System.out.println(e1.equals(e2)&& (c1.equals(c1)));






    }
}