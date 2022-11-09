import java.io.Serializable;

public class Student implements Serializable {
    public static Long INDEX = Long.valueOf(0);
    private String code;
    private String name;
    private int age;
    private String gender;
    private String address;
    private Faculty faculty;
    private double marksAvg;

    public Student(String name, int age, String gender,String address, double marksAvg, Faculty faculty) {
        this.code = String.valueOf(++INDEX);
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.marksAvg = marksAvg;
        this.faculty = faculty;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMarksAvg() {
        return marksAvg;
    }

    public void setMarksAvg(double marksAvg) {
        this.marksAvg = marksAvg;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        if(faculty == null) {
            return "Student{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", gender='" + gender + '\'' +
                    ", address='" + address + '\'' +
                    ", marksAvg='" + marksAvg + '\'' +
                    ", faculty= null" +
                    '}';
        }
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", marksAvg='" + marksAvg + '\'' +
                ", faculty=" + faculty.getName() +
                '}';
    }

    public void display(){
        if(faculty != null){
            System.out.printf("%-5s%-25s%-15s%-20s%-20s%-20s%s", code, name, age, gender, address,marksAvg,faculty.getName() + "\n" );
        }
        else{
            System.out.printf("%-5s%-25s%-15s%-20s%-20s%-20s%s", code, name, age, gender, address, marksAvg + "null\n" );
        }
    }
}
