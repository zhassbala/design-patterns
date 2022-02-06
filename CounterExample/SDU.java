package CounterExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
* this is SDU uni functional simulator
* You can enroll to course, get available courses, register your student ID, etc.
* */
public class SDU {
    private static SDU instance;
    private static HashMap<String, Course> courses;
    private static HashMap<String, Student> students;
    
    private class Course{
        public String name;
        public String code;
        private final ArrayList<Student> students;

        Course(String name, String code){
            this.name = name;
            this.code = code;
            this.students = new ArrayList<>();
        }
        private void enrollStudent(Student student){
            this.students.add(student);
        }
        void unenrollStudent(Student student){
            this.students.remove(student);
        }
        ArrayList<Student> getStudents(){
            return this.students;
        }

        @Override
        public String toString() {
            return "\nCode: " + this.code + "\nCourse name: " + this.name;
        }
    }
    static class Student{
        public String firstname;
        public String lastname;
        public String ID;
        private static int lastID = 0;
        private final ArrayList<Course> enrolledCourses;

        private Student(String firstname, String lastname){
            this.firstname = firstname;
            this.lastname = lastname;
            this.ID = createID();
            this.enrolledCourses = new ArrayList<>();
        }
        private String createID(){
            lastID++;
            return String.format("%08d", lastID);
        }

        public ArrayList<Course> getEnrolledCourses() {
            return enrolledCourses;
        }
        void enroll(Course course){
            if (!this.enrolledCourses.contains(course)){
                this.enrolledCourses.add(course);
                course.enrollStudent(this);
            }
        }
        void unenroll(Course course){
            if (this.enrolledCourses.contains(course)){
                this.enrolledCourses.remove(course);
                course.unenrollStudent(this);
            }
        }
        @Override
        public String toString(){
            return  "Student ID: " + this.ID + "\n" +
                    "Full name: " + this.firstname + " " + this.lastname + "\n" +
                    "Enrolled Courses: " + Arrays.toString(this.enrolledCourses.toArray());
        }
    }
    Student register(String firstname, String lastname){
        Student student = new Student(firstname, lastname);
        students.put(student.ID, student);
        return student;
    }

    private SDU(){
        courses = new HashMap<>();
        students = new HashMap<>();
    }
    public static SDU getInstance(){
        if (instance == null){
            instance = new SDU();
        }
        return instance;
    }
    void createCourse(String name, String code){
        courses.put(code, new Course(name, code));
    }
    Course getCourse(String code){
        return courses.get(code);
    }
    void deleteCourse(String code){
        courses.remove(code);
    }
    Student getStudent(String ID){
        return students.get(ID);
    }
    public static HashMap<String, Student> getStudents() {
        return students;
    }
    public void printCourses(){
        System.out.println(Arrays.toString(courses.values().toArray()));
    }
    public void printStudents(){
        System.out.println(Arrays.toString(students.values().toArray()));
    }
}
