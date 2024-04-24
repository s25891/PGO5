import java.util.Date;
import java.util.ArrayList;
import java.util.List;

class Student {
    private static int counter = 0;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private Date birthDate;
    private String indexNumber;
    private StudyProgramme programme;
    private int currentSemester;
    private String status;

    public Student(String firstName, String lastName, String email, String address, String phoneNumber, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.indexNumber = "s" + (++counter);
        this.currentSemester = 1;
        this.status = "Candidate";
    }

    public void enrollStudent(StudyProgramme programme) {
        this.programme = programme;
        this.status = "Student";
    }

    public void promoteToNextSemester() {
        if (currentSemester < programme.getSemesterNumber()) {
            currentSemester++;
            if (currentSemester == programme.getSemesterNumber()) {
                status = "Graduate";
            }
        }
    }

    public void displayInfo() {
        System.out.println(firstName + " " + lastName + " (" + indexNumber + ")");
        System.out.println("Program: " + programme.getName() + ", Semester: " + currentSemester);
        System.out.println("Status: " + status);
    }
}

class StudyProgramme {
    private String name;
    private String description;
    private int semesterNumber;
    private int maxRetakes;

    public StudyProgramme(String name, String description, int semesterNumber, int maxRetakes) {
        this.name = name;
        this.description = description;
        this.semesterNumber = semesterNumber;
        this.maxRetakes = maxRetakes;
    }

    public String getName() {
        return name;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }
}

class Students {
    private static List<Student> studentList = new ArrayList<>();

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void promoteAllStudents() {
        for (Student student : studentList) {
            student.promoteToNextSemester();
        }
    }

    public static void displayInfoAboutAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("John", "Doe", "doe@gmail.com", "Warsaw, Zlota 44", "333-222-666", new Date(1998, 1, 3));
        StudyProgramme it = new StudyProgramme("IT", "AAA", 7, 5);
        s.enrollStudent(it);

        Students.addStudent(s);
        Students.promoteAllStudents();
        Students.displayInfoAboutAllStudents();
    }
}