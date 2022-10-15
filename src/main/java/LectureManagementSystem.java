import org.assignment1.Course;
import org.assignment1.Student;
import org.assignment1.Module;
import org.assignment1.Lecturer;
import org.joda.time.DateTime;

public class LectureManagementSystem {

    public LectureManagementSystem() {
    }

    public static void main(String[] args){
        // creating a number of students
        Student s1 = new Student("John", 22, "09/08/2000", "57354628");
        Student s2 = new Student("Mark", 20, "05/06/2002", "65936759");
        Student s3 = new Student("Sarah", 21, "07/10/2001", "67937457");
        Student s4 = new Student("Rachel", 23, "04/04/1999", "96480976");
        Student s5 = new Student("Tom", 22, "03/09/2000", "647392638");
        Student s6 = new Student("Ella", 21, "11/04/2001", "73574727");
        Student s7 = new Student("Jack", 22, "09/01/2000", "16382922");

        // creating a number of lecturers
        Lecturer l1 = new Lecturer("Michael", 40, "03/01/1982", "78472728");
        Lecturer l2 = new Lecturer("Conor", 44, "03/01/1978", "64382618");
        Lecturer l3 = new Lecturer("Joanne", 44, "04/07/1978", "637472847");

        // creating a number of modules
        Module m1 = new Module("Programming", "CT411", l1);
        Module m2 = new Module("Statistics", "ST489", l1);
        Module m3 = new Module("Software Engineering", "CT418", l2);
        Module m4 = new Module("Financial Accounting", "AC456", l3);
        Module m5 = new Module("Tax Accounting", "AC410", l3);

        // adding the modules to the Lecturer's list of modules teaching
        l1.addModuleTeaching(m1);
        l1.addModuleTeaching(m2);
        l2.addModuleTeaching(m3);
        l3.addModuleTeaching(m4);
        l3.addModuleTeaching(m5);

        // adding a number of students to each module and also adding these modules to the student's list of modules they are taking
        m1.addStudent(s1);
        s1.addModule(m1);
        m1.addStudent(s2);
        s2.addModule(m1);
        m1.addStudent(s3);
        s3.addModule(m1);
        m1.addStudent(s4);
        s4.addModule(m1);

        m2.addStudent(s1);
        s1.addModule(m2);
        m2.addStudent(s3);
        s3.addModule(m2);
        m2.addStudent(s5);
        s5.addModule(m2);

        m3.addStudent(s4);
        s4.addModule(m3);
        m3.addStudent(s5);
        s5.addModule(m3);

        m4.addStudent(s3);
        s3.addModule(m4);
        m4.addStudent(s6);
        s6.addModule(m4);
        m4.addStudent(s7);
        s7.addModule(m4);

        m5.addStudent(s6);
        s6.addModule(m5);
        m5.addStudent(s7);
        s7.addModule(m5);

        // creating courses
        Course c1 = new Course("Computer Science", new DateTime("2022-01-01"), new DateTime("2022-05-30"));
        Course c2 = new Course("Accounting", new DateTime("2022-09-01"), new DateTime("2022-12-20"));

        // adding modules to the courses and adding to the module an associated course
        c1.addModule(m1);
        m1.addCourse(c1);
        // for each student in the module, adding them to the list of students for the course if not already there
        for(int i=0; i<m1.getStudents().size(); i++){
            if(!c1.getStudents().contains(m1.getStudents().get(i))){
                c1.addStudents(m1.getStudents().get(i));
            }
            // for each student in the module, adding the course to the student's courses if not already there
            if(!m1.getStudents().get(i).getCourses().contains(c1)){
                m1.getStudents().get(i).addCourses(c1);
            }
        }
        c1.addModule(m2);
        m2.addCourse(c1);
        for(int i=0; i<m2.getStudents().size(); i++){
            if(!c1.getStudents().contains(m2.getStudents().get(i))){
                c1.addStudents(m2.getStudents().get(i));
            }
            if(!m2.getStudents().get(i).getCourses().contains(c1)){
                m2.getStudents().get(i).addCourses(c1);
            }
        }
        c1.addModule(m3);
        m3.addCourse(c1);
        for(int i=0; i<m3.getStudents().size(); i++){
            if(!c1.getStudents().contains(m3.getStudents().get(i))){
                c1.addStudents(m3.getStudents().get(i));
            }
            if(!m3.getStudents().get(i).getCourses().contains(c1)){
                m3.getStudents().get(i).addCourses(c1);
            }
        }
        c2.addModule(m4);
        m4.addCourse(c2);
        for(int i=0; i<m4.getStudents().size(); i++){
            if(!c2.getStudents().contains(m4.getStudents().get(i))){
                c2.addStudents(m4.getStudents().get(i));
            }
            if(!m4.getStudents().get(i).getCourses().contains(c2)){
                m4.getStudents().get(i).addCourses(c2);
            }
        }
        c2.addModule(m5);
        m5.addCourse(c2);
        for(int i=0; i<m5.getStudents().size(); i++){
            if(!c2.getStudents().contains(m5.getStudents().get(i))){
                c2.addStudents(m5.getStudents().get(i));
            }
            if(!m5.getStudents().get(i).getCourses().contains(c2)){
                m5.getStudents().get(i).addCourses(c2);
            }
        }

        // printing out the courses, respective modules and students with the students information
        System.out.println("Course Name: " + c1.getName());
        System.out.println("\nModules");
        for(int i=0; i<(c1.getModules().size()); i++){
            System.out.println("Name: " + c1.getModules().get(i).getName() + ", Lecturer Responsible: " + c1.getModules().get(i).getLecturer().getName());
        }
        System.out.println("\nStudents");
        for(int i=0; i<(c1.getStudents().size()); i++){
            System.out.println("\nName: " + c1.getStudents().get(i).getName() + ", Username: " + c1.getStudents().get(i).getUsername());
            for(int j=0; j<(c1.getStudents().get(i).getModules().size()); j++){
                System.out.println("Assigned Module: " + c1.getStudents().get(i).getModules().get(j).getName());
            }
            for(int j=0; j<(c1.getStudents().get(i).getCourses().size()); j++){
                System.out.println("Registered Course: " + c1.getStudents().get(i).getCourses().get(j).getName());
            }
        }

        System.out.println("\n\n\nCourse Name: " + c2.getName());
        System.out.println("\nModules");
        for(int i=0; i<(c2.getModules().size()); i++){
            System.out.println("Name: " + c2.getModules().get(i).getName() + ", Lecturer Responsible: " + c2.getModules().get(i).getLecturer().getName());
        }
        System.out.println("\nStudents");
        for(int i=0; i<(c2.getStudents().size()); i++){
            System.out.println("\nName: " + c2.getStudents().get(i).getName() + ", Username: " + c2.getStudents().get(i).getUsername());
            for(int j=0; j<(c2.getStudents().get(i).getModules().size()); j++){
                System.out.println("Assigned Module: " + c2.getStudents().get(i).getModules().get(j).getName());
            }
            for(int j=0; j<(c2.getStudents().get(i).getCourses().size()); j++){
                System.out.println("Registered Course: " + c2.getStudents().get(i).getCourses().get(j).getName());
            }
        }

    }
}
