import java.util.*;
import java.io.FileWriter;
class PreReqException extends Exception {
    public PreReqException(String m){
        super(m);
    }
}

class FullCapacityException extends Exception {
    public FullCapacityException(String m){
        super(m);
    }
}

class ReportGeneration {
    private FileWriter FileForReport=null;
    public ReportGeneration(String name){
        try{
        this.FileForReport=new FileWriter(name);
        }
        catch(Exception e){
            System.out.println("Eception Caught : "+e.getMessage());
        }
    }
    void GenerateReport(Student s){
        if(FileForReport != null){
            try{
            String r="Name : " + s.getName();
            r+="\nRoll No. : "+s.getRoll_No();
            FileForReport.write(r);
            FileForReport.close();
            }
            catch(Exception e){
                System.out.println("Eception Caught : "+e.getMessage());
            }
        }
    }
}

abstract class person {
    private String name;
    private String email;
    private String Roll_No;

    public person(String n,String e,String r){
        this.name=n;
        this.email=e;
        this.Roll_No=r;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getRoll_No() {
        return Roll_No;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRoll_No(String roll_No) {
        Roll_No = roll_No;
    }
    abstract void displayDetails();
}

class Student extends person {
    private double cgpa;
    private List<Double> cgpaList;
    public Student(String name, String email, String rollNo) {
        super(name, email, rollNo);
        this.cgpa = 0.0;
        this.cgpaList = new java.util.ArrayList<>();
    }
    public double getCgpa() {
        return cgpa;
    }
    public void setCgpa(double cgpa) {
        this.cgpaList.add(cgpa);
        this.cgpa = cgpa;
    }
    public List<Double> getCgpaList() {
        return cgpaList;
    }
    @Override
    void displayDetails() {
        System.out.println("Student Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Roll No: " + getRoll_No());
        System.out.println("CGPA: " + getCgpa());
    }
}

class Professor extends person {
    private Department department;
    public Professor(String name, String email, String rollNo, Department department) {
        super(name, email, rollNo);
        this.department = department;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    @Override
    void displayDetails() {
        System.out.println("Professor Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Roll No: " + getRoll_No());
        System.out.println("Department: " + department.getDepartmentName());
    }
}

class Department {
    private String departmentName;
    private Professor headOfDepartment;
    public Department(String departmentName, Professor headOfDepartment) {
        this.departmentName = departmentName;
        this.headOfDepartment = headOfDepartment;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public Professor getHeadOfDepartment() {
        return headOfDepartment;
    }
    public void setHeadOfDepartment(Professor headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }
}

class Courses {
    private String courseName;
    private int credits;
    private String courseCode;
    private int capacity;
    private int enrolledStudents;
    private Map<String, Integer> Grading_Criteria = new HashMap<>();
    private Department d;
    public Courses(Department dep,String courseName, int credits, String courseCode, int capacity) {
        this.d=dep;
        this.courseName = courseName;
        this.credits = credits;
        this.courseCode = courseCode;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getCredits() {
        return credits;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getEnrolledStudents() {
        return enrolledStudents;
    }
    public void enrollStudent() throws FullCapacityException {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
        } else {
            throw new FullCapacityException("Course is full. Cannot enroll more students.");
        }
    }
    public Map<String, Integer> getGrading_Criteria() {
        return Grading_Criteria;
    }
    public void addGrading_Criteria(String gradeComponent, int weightage) {
        Grading_Criteria.put(gradeComponent, weightage);
    }
}

class Enrollment {
    private Student student;
    private Courses course;
    private int grade;
    private enum status {
        Not_registered, Passed, Failed,Ongoing
    }
    private status Status;
    public Enrollment(Student student, Courses course) {
        this.student = student;
        this.course = course;
        try{
            course.enrollStudent();
        }
        catch(FullCapacityException e){
            e.getMessage();
        }
        this.grade = -1; // -1 indicates no grade assigned yet
        this.Status = status.Not_registered;
    }

    public Student getStudent() {
        return student;
    }
    public Courses getCourse() {
        return course;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public status getStatus() {
        return Status;
    }
    public void setStatus(status status) {
        Status = status;
    }

}

public class Main {
    public static void main(String[] args)
    {
        Student s=new Student("Rahul", "null","2022388");
        ReportGeneration report1 = new ReportGeneration("Report1.txt");
        report1.GenerateReport(s);
    }    
}
