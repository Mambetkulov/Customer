import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    static Scanner scanLine = new Scanner(System.in);
    static  Scanner scanNum = new Scanner (System.in);

    public static void main(String[] args) {
         Crud crud = new Crud();

        while(true) {

            System.out.println("""
                    
                    to add customer type - add
                    to get all customer type - get
                    to get customer by id type - gedi
                    to update type - up
                    to delete type - del
                   
                    """);

            String choice = scanLine.nextLine();
            switch(choice){
                case "add" :{
                       Customer  customer = regCustomer(new Customer());
                       String result = crud.add(customer);
                       System.out.println(result);

                     break;
                }
                case "get" :{
                    var all = crud.getAll();
                    for(Customer i : all){
                        System.out.println( i.getId() + "\n" + i.getName() + "\n" + i.getEmail() + "\n" + i.getPhoneNumber()
                                           + "\n" + i.getDateOfBirth() + "\n");
                    }
                     break;
                }
                case "geti" : {
                    System.out.println("write id ");
                    Long sid = scanNum.nextLong();
                    crud.getById(sid);
                    break;
                }
                case "up" : {
                    System.out.println("write id ");
                    Long sid = scanNum.nextLong();
                    Customer  customer = regCustomer(new Customer());
                    crud.update(sid,customer);
                    break;
                }
                case "del" : {
                    System.out.println("write id ");
                    Long sid = scanNum.nextLong();
                    crud.delete(sid);
                    break;
                }
            }


        }
    }
    public static Customer regCustomer (Customer customer){

        System.out.print("write name : ");
        customer.setName(scanLine.nextLine());

        System.out.print("write email : ");
        customer.setEmail(scanLine.nextLine());

        System.out.print("write phone number : ");
        customer.setPhoneNumber(scanLine.nextLine());


        System.out.println("write date of birth");
        System.out.print("year : ");
        var year = scanNum.nextInt();
        System.out.print("month : ");
        var month = scanNum.nextInt();
        System.out.print("day : ");
        var day = scanNum.nextInt();

        customer.setDateOfBirth(LocalDate.of(year,month,day));
        System.out.print("write id : ");
        customer.setId(scanNum.nextLong());

        return customer;

    }
}