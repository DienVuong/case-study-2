import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    private static ArrayList<Faculty> faculties;

    static {
        faculties = new ArrayList<>();
        faculties.add(new Faculty("Cơ Khí"));
        faculties.add(new Faculty("Kinh tế"));
        faculties.add(new Faculty("Tin học"));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        UserLoginManager login = new UserLoginManager();
        do {
            System.out.println("----Menu Login----");
            System.out.println("1. Login account : ");
            System.out.println("2. Register account");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 4) {
                    throw new RuntimeException();
                }
                switch (choice) {
                    case 1:
                        login.loginAccount(scanner);
                        break;
                    case 2:
                        login.registerAccount(scanner);
                        break;
                    case 0:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }
        public static void creadMennuAdmin(Scanner scanner, StudentManager studentManager){
            do {
                    System.out.println("       ADMIN ACCOUNT");
                    System.out.println("1. Add student");
                    System.out.println("2. Update student: ");
                    System.out.println("3. Delete student: ");
                    System.out.println("4. Display all student: ");
                    System.out.println("5. Display student by ID: ");
                    System.out.println("6. Display student by faculty: ");
                    System.out.println("7. Display student by name: ");
                    System.out.println("8. Display sort student by marksAvg : ");
                    System.out.println("9. Display list student have max marksAvg: ");
                    System.out.println("0. Exit");
                    System.out.println("Enter your choice:");
                try{
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    if (choice1 == 0) {
                        break;
                    } else {
                        if(choice1 < 0 || choice1 >9){
                            System.out.println("Enter your choice, number choice within 0 - 9");
                        }
                        switch (choice1) {
                            case 1:
                                studentManager.addStudent(faculties, scanner);
                                break;
                            case 2:
                                studentManager.updateStudent(faculties, scanner);
                                break;
                            case 3:
                                studentManager.deleteStudent(scanner);
                                break;
                            case 4:
                                studentManager.display();
                                break;
                            case 5:
                                studentManager.displayByCode();
                                break;
                            case 6:
                                studentManager.displayByFaculty(faculties, scanner);
                                break;
                            case 7:
                                studentManager.displayByName(scanner);
                                break;
                            case 8:
                                studentManager.displayByMarksSortDown();
                                break;
                            case 9:
                                studentManager.displayListStudentByMaxMarks();
                                break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Please enter your selection");
                }
            } while (true);
        }

        public static void creadMenuUser(Scanner scanner, StudentManager studentManager){
            do {
                System.out.println("        USER ACCOUNT");
                System.out.println("1. Display student by name: ");
                System.out.println("2. Display student by ID: ");
                System.out.println("3. Display list student have maxMarksAvg: ");
                System.out.println("0. Exist");
                System.out.println("Enter your choice");
                int choice2 = Integer.parseInt(scanner.nextLine());
                if (choice2 < 0 || choice2 > 3) {
                    throw new RuntimeException();
                }
                if (choice2 == 0) {
                    break;
                }
                switch (choice2) {
                    case 1:
                        studentManager.displayByName(scanner);
                        break;
                    case 2:
                        studentManager.displayByCode();
                        break;
                    case 3:
                        studentManager.displayListStudentByMaxMarks();
                        break;
                }
            } while (true);
        }
}
