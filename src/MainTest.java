import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class MainTest {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static HashMap<User,ArrayList<Product>> list = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        MainTest app = new MainTest();
        while(true) {
            app.startApp();
        }
    }

    private void startApp(){
        System.out.println(
                  "\n1.Display list of all users\n"
                + "2.Display list of all products\n"
                + "3.Buy a product\n"
                + "4. Display list of user products by user id\n"
                + "5. Display list of users that bought product by product id\n"
                + "6. Add user\n"
                + "7. Add product\n"
                + "8. Remove user\n"
                + "9. Remove product\n"
        +"\nSelect an operation : ");



        while(!sc.hasNextInt()){
            sc.next();
        }


        
        switch (sc.nextInt()) {
            case 1: {
                System.out.println(users);
                break;
            }
            case 2: {
                System.out.println(products);
                break;
            }
            case 3: {
                
                try {
                    Buy();
                }catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 4: {

                for(User user:users){

                    if( !list.get(user).isEmpty() ){
                        System.out.println(user + ":\n" + list.get(user));
                    }

                }
                break;
            }
            case 5: {
                String str = "";

                for(Product product:products){

                    str += product +  ":" + "\n";

                    for (User user: users){

                        if(list.get(user).contains(product)){
                            str+=user + ",\n";
                        }
                    }
                    if(!str.equals(product + ":" + "\n")){
                        System.out.println(str);
                    }
                    str = "";
                }
                break;
            } case 6:{
                try {
                    AddUser();
                    System.out.println(users);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            } case 7:{
                try {
                    AddProduct();
                    System.out.println(products);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            } case 8:{
                try {
                    System.out.println(users);
                    System.out.println("");

                    RemoveUser();
                    System.out.println(users);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            } case 9:{
                try {
                    System.out.println(products);
                    System.out.println("");
                    RemoveProduct();
                    System.out.println();
                    System.out.println(products);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    public static User getUserById(int id){

        for (User user:users){

            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public static Product getProductById(int id){

        for (Product product:products){

            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public static void  AddUser() throws Exception {
        Random random = new Random();
        int id;
        boolean findId = false;

        while (true) {
            id = random.nextInt(1000);

            for (User usr : users) {

                if (usr.getId() == id) {
                    findId = true;
                    break;
                }
            }

            if(!findId){
                break;
            }
        }

        System.out.println("Enter the First name: ");
        sc.nextLine();
        String first_name = sc.nextLine();

        if(first_name == "") {
            throw new Exception("The first name is null.");
        }

        System.out.println("Enter the Last name: ");
        String last_name = sc.nextLine();

        if(last_name == null)
            throw new Exception("The first name is null.");

        System.out.println("Enter the amount of money:");

        if(!sc.hasNextFloat())
            throw new Exception("You have not entered a number.");

        float money = sc.nextFloat();
        User user = new User(id, first_name, last_name, money);
        users.add(user);
        list.put(user, new ArrayList<>());

    }

    public static void  AddProduct() throws Exception {
        Random random = new Random();
        int id = 0;
        boolean findId = false;

        while (true) {

            id = random.nextInt(1000);
            for (Product prd : products) {
                if (prd.getId() == id) {
                    findId = true;
                    break;
                }
            }
            if(!findId){
                break;
            }
        }

        System.out.println("Enter the name: ");
        sc.nextLine();
        String name = sc.nextLine();

        if(name == "") {
            throw new Exception("The name is null.");
        }

        System.out.println("Enter the price : ");

        if(!sc.hasNextFloat()) {

            throw new Exception("The price isn't float");
        }

        float price = sc.nextFloat();
        products.add(new Product(id,name, price));

    }


    public static void  RemoveUser() throws Exception {

        System.out.println("Select the user you want to delete (enter his id) : ");
        int id = sc.nextInt();
        boolean findId = false;
        for(User usr : users){
            if(usr.equals(getUserById(id))){
                findId = true;
                break;
            }
        }

        if(!findId)
            throw new Exception("No user found with id = " + id + " in the users list.");

        users.remove(getUserById(id));
        list.remove(getUserById(id));
    }

    public static void  RemoveProduct() throws Exception{

        int id = 0;
        System.out.println("Select the product you want to delete (enter its id) : ");
        id = sc.nextInt();
        boolean findId = false;
        for(Product prd : products){
            if(prd.equals(getProductById(id))){
                findId = true;
                break;
            }
        }

        if(!findId)
            throw new Exception("There is no product with id " + id + " in a products list.");

        products.remove(getProductById(id));

        for(User user : users){
            for(Product prd : list.get(user)){

                if(prd.getId() == id){
                    list.get(user).remove(prd);
                }

            }
        }
    }

    public static void Buy() throws Exception{
        int idUser;
        int idProduct;
        boolean findId;

        while(true) {
            System.out.println(users);
            System.out.println("Enter the user's id: ");
            idUser = sc.nextInt();
            findId = false;

            for (User usr : users) {
                if (idUser == usr.getId()) {
                    findId = true;
                    break;
                }
            }

            if (!findId) {
                System.out.println("There is no such user in the list of users.");
            } else break;
        }
        System.out.println(products);
        while(true) {
            System.out.println("Enter the product's id : ");
            idProduct = sc.nextInt();
            findId = false;
            for (Product product : products) {
                if (idProduct == product.getId()) {
                    findId = true;
                    break;
                }
            }
            if (!findId) {
                System.out.println("There is no such product in the list of products");
            } else break;
        }

        Product prod = getProductById(idProduct);
        User user= getUserById(idUser);

        if(prod.getPrice() > user.getMoney())
            throw new Exception(user.getMoney() + " is not enough money to buy this product (" + prod.getName() +
                    ", price = "+ prod.getPrice() + " )\n");

        user.setMoney(user.getMoney()-prod.getPrice());
        list.get(user).add(prod);
    }



}
