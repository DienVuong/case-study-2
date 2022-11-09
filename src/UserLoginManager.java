import Acount.FileAcount;
import Acount.Role;
import Acount.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserLoginManager implements Serializable {
    FileAcount<User> fileAcount = new FileAcount<>();
    public ArrayList<User> users;
    StudentSystem studentSystem = new StudentSystem();
    public UserLoginManager(){
        users = fileAcount.readFile("case modul2/src/Acount/FileAccount.txt");
        User admin = new User("Dien","123456");
        admin.setRole2(new Role("ADMIN"));
        users.add(admin);
        fileAcount.writeFile(users, "case modul2/src/Acount/FileAccount.txt");

    }

    public void loginAccount(Scanner scanner){
        try{
            System.out.println("Enter account: ");
            String account = scanner.nextLine();
            System.out.println("Enter password: ");
            String password = scanner.nextLine();
            for(User u : users){
                if( u.getAcount().equals(account) && u.getPassword().equals(password)){
                    if(u.getRole2().getName_role().equals("ADMIN")){
                        studentSystem.creadMennuAdmin(scanner, new StudentManager());
                    }else {
                        studentSystem.creadMenuUser(scanner, new StudentManager());
                    }
                    break;
                }
            }
        }catch (InputMismatchException e){
            System.err.println(e.getMessage());
        }
    }

    public void registerAccount(Scanner scanner){
        try{
            System.out.println("Enter name account: ");
            String account = scanner.nextLine();
            System.out.println("Enter password: ");
            String passWord = scanner.nextLine();
            User user = new User(account, passWord);
            user.setRole2(new Role("USER"));
            users.add(user);
            System.out.println("Register successful!");
            fileAcount.writeFile(users, "case modul2/src/Acount/FileAccount.txt");
        }catch (NumberFormatException | InputMismatchException e){
            System.err.println(e.getMessage());
        }
    }

}
