import java.util.Arrays;

public class Crud {
    Customer[] customer = new Customer[0];
    int size = 0;



    public String add(Customer newOne){
        customer = Arrays.copyOf(customer,size + 1);
        customer[size] = newOne;
        size ++;
        return "successfully added ";
    }



    public Customer[] getAll(){
          return customer;
        }



    public void getById (Long id) {
        boolean bre = true;
        for (Customer value : customer) {
            if (value.getId().equals(id)) {
                bre = false;
                System.out.println(value.getName() + "\n" + value.getEmail() + "\n" + value.getDateOfBirth() +"\n" + value.getPhoneNumber());
            }
        }
        if (bre){
            System.out.println("Customer with this id " + id + " not found ");
        }
    }




       public void update(Long id , Customer newCustomer){
        boolean bre = true;
           for (int i = 0; i < customer.length; i++) {
               if (customer[i].getId().equals(id)){
                   bre = false;
                   customer[i] = newCustomer;
                   System.out.println("successfully updated");
               }
           }
             if (bre){
                 System.out.println("Customer with this id " + id + " not found ");
             }
        }




        public void delete(Long id){
            boolean bre = false;
            for (int i = 0; i < customer.length; i++) {
                if (customer[i].getId().equals(id)){
                    bre = true;
                    for (int j = i; j < size -1 ; j++) {
                        customer[j] = customer[j + 1];
                    }
                    size --;
                }
            }

               customer = Arrays.copyOf(customer,customer.length - 1) ;
            System.out.println(bre ? "successfully deleted " : "Customer with this id " + id + " not found ");


        }





}
