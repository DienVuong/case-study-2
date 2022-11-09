import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class StudentManager {
    private ArrayList<Student> students;
    Scanner scanner = new Scanner(System.in);
    public StudentManager(){
        students = readFile();
        resetStaticINDEX();
    }
    Pattern p = Pattern.compile("^[a-zA-Z ]+$");
    Pattern p1 = Pattern.compile("^[0-9]+$");
    public void addStudent(ArrayList<Faculty> faculties , Scanner scanner) {
        String name;
        while (true) {
            System.out.println("Enter name student: ");
            name = scanner.nextLine();
            if(p.matcher(name).find()){
                break;
            }else{
                System.out.println("Enter name student ");
            }
        }
        int age;
        while (true) {
            try {
                System.out.println("Enter age student");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 17 && age <= 50) {
                    break;
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        String gender;
        while (true) {
            System.out.println("Enter gender student: ");
            gender = scanner.nextLine();
            if(p.matcher(gender).find()){
                break;
            }
        }
        String address;
        while (true) {
            System.out.println("Enter address student: ");
            address = scanner.nextLine();
            if(p.matcher(address).find()){
                break;
            }
        }
        double marksAvg;
            while (true) {
                try{
                System.out.println("Enter marksAvg student: ");
                marksAvg = Double.parseDouble(scanner.nextLine());
                if (marksAvg >= 0.0 && marksAvg <= 10.0) {
                    break;
                }
            }catch (Exception e){
                    System.err.println(e.getMessage());
            }
            }
        System.out.println("Enter faculty student: ");
        Faculty faculty = getFacultyByIndex(faculties, scanner);
        students.add(new Student(name, age, gender, address, marksAvg ,faculty));
        writeFile();
    }


    public void updateStudent(ArrayList<Faculty> faculties, Scanner scanner){
        try{
            System.out.println("Enter code of student you want update: ");
            String code = scanner.nextLine();
            Student studentUpdate;
            if((studentUpdate = checkExist(code)) != null){
                System.out.println("Enter new name student: ");
                String name = scanner.nextLine();
                if(!name.equals("") && p1.matcher(name).find()){
                    studentUpdate.setName(name);
                }
                System.out.println("Enter new age student: ");
                String age = scanner.nextLine();
                if(!age.equals("")){
                    studentUpdate.setAge(Integer.parseInt(age));
                }
                System.out.println("Enter new gender student: ");
                String gender = scanner.nextLine();
                if(!gender.equals("")){
                    studentUpdate.setGender(gender);
                }
                System.out.println("Enter new address student: ");
                String address = scanner.nextLine();
                if(!address.equals("")){
                    studentUpdate.setAddress(address);
                }
                System.out.println("Enter new marksAvg student: ");
                String marksAvg = scanner.nextLine();
                if(!marksAvg.equals("")){
                    studentUpdate.setMarksAvg(Double.parseDouble(marksAvg));
                }
                System.out.println("Enter new faculty student; ");
                Faculty faculty;
                if((faculty = getFacultyByIndex(faculties, scanner)) != null ){
                    studentUpdate.setFaculty(faculty);
                }
                writeFile();
            }else{
                System.out.println(" Not exist student have code: ");
            }

        }catch( NumberFormatException | InputMismatchException e){
            System.err.println(e.getMessage());
        }
    }

    public void deleteStudent(Scanner scanner){
        try{
            System.out.println("Enter code of student");
            String code = scanner.nextLine();
            Student studentDelete;
            if((studentDelete = checkExist(code)) != null ) {
                students.remove(studentDelete);
                writeFile();
            } else{
                System.out.println("Not exist student have code: ");
            }
        }catch( NumberFormatException | InputMismatchException e){
            System.err.println(e.getMessage());
        }
    }

    public void display(){
        System.out.printf("%-5s%-25s%-15s%-20s%-20s%-20s%s", "ID", "Name", "Age", "Gender", "Address", "MarksAvg", "Faculty\n");
        for (Student s : students) {
            s.display();
            System.out.println();
        }
    }

    public void displayByCode(){
        try{
            System.out.println("Enter code student you want display; ");
            String code = scanner.nextLine();
            Student student;
            if((student = checkExist(code)) != null){
                System.out.println(student);
            }else{
                System.out.println("Not exist student have code: ");
            }
        }catch(NumberFormatException | InputMismatchException e){
            System.err.println(e.getMessage());
        }
    }

    public void displayByFaculty(ArrayList<Faculty> faculties, Scanner scanner){
        System.out.println("Enter your choice: ");
        Faculty faculty = getFacultyByIndex(faculties, scanner);
        if(faculty != null){
            for(Student s : students){
                if(s.getFaculty().equals(faculty)){
                    System.out.println(s);
                }
            }
        }else{
            System.out.println("Not exist student have faculty: ");
        }
    }

    public void displayByName(Scanner scanner){
        System.out.println("Enter character you want search: ");
        String search = scanner.nextLine();
        System.out.println("List student have name contains");
        for(Student s : students){
            if(s.getName().contains(search)){
                System.out.println(s);
            }
        }
    }

    public void displayByMarksSortDown(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o2.getMarksAvg() - o1.getMarksAvg());
            }
        });
        for(Student s : students)
        System.out.println(s);
    }
    public void displayListStudentByMaxMarks(){
        double max;
        max = students.get(0).getMarksAvg();
        for( int i = 0; i< students.size(); i++){
            if( students.get(i).getMarksAvg() > max){
                max = students.get(i).getMarksAvg();
            }
        }
        for (Student s : students){
            if( s.getMarksAvg() == max){
                System.out.println(s);
            }
        }
    }


    private Faculty getFacultyByIndex(ArrayList<Faculty> faculties, Scanner scanner){
        for(int i = 0; i < faculties.size(); i++){
            System.out.println((i+1) + ", " + faculties.get(i).getName());
        }
        System.out.println("0. Not choice");
        int choice;
        try{
            do{
                System.out.println("Enter your choice");
                choice = Integer.parseInt(scanner.nextLine());
                if(choice == 0){
                    return null;
                }
                if(choice >0 && choice <= faculties.size()){
                    return faculties.get(choice - 1);
                }
                System.err.println("Please re-enter your selection!");
            }while (choice <0 || choice > faculties.size());
        }catch( NumberFormatException | InputMismatchException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    private Student checkExist(String code){
        for(Student s : students){
            if(s.getCode().equals(code)){
                return s;
            }
        }return null;
    }

    private void writeFile(){
        File file = new File("case modul2/src/File_Save/SavaFile.txt");
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(students);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    private ArrayList<Student> readFile(){
        File file =new File("case modul2/src/File_Save/SavaFile.txt");
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            if(fileInputStream.available() > 0){
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                studentArrayList = (ArrayList<Student>) objectInputStream.readObject();
            }
            return studentArrayList;
        }catch (IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
        return studentArrayList;
    }

    private void resetStaticINDEX(){
        if(!students.isEmpty()){
          Student.INDEX = Long.valueOf(students.get(students.size() - 1).getCode());
        }
    }
}
