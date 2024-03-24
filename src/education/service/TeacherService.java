package education.service;

import education.entities.classroom.Classroom;
import education.entities.student.Student;
import education.entities.teacher.Teacher;
import education.service.impl.ClassroomService;
import utils.Utils;

import java.util.Map;
import java.util.Scanner;

public class TeacherService implements ClassroomService<Classroom> {
    Scanner scanner = new Scanner(System.in);
    Utils utils = new Utils();

    // 1. View all subject
    public void viewAllSubject(Classroom classroom){
        System.out.println(classroom.getSubjects());
    }

    // 2. Find subject by id
    public void findSubjectById(Classroom classroom){
        viewAllSubject(classroom);
        int id = utils.idSubjectExistedCheck(classroom);
        System.out.println(classroom.getSubjects().get(id));
    }

    // 3. View teacher's own information
    public void viewTeacherInfo(Teacher teacher){
        System.out.println(teacher.teacherInfoTeacherView());
    }

    // 4. View all student the teacher teach
    public void getAllStudentTeach(Teacher teacher, Classroom classroom){
        int count = 0;
        for(Map.Entry<String,Student> student : classroom.getStudents().entrySet()){
            if(student.getValue().getTeacherUsername().equals(teacher.getUsername())){
                count++;
                System.out.println(student);
            }
        }
        if(count<=0) System.out.println("You have not been assigned a class yet");
    }

    // 5. Edit grade for student
    public void editGradeStudent(Teacher teacher, Classroom classroom){

        getAllStudentTeach(teacher,classroom);

        System.out.println("Enter student's username want to edit grade");
        String usernameStudent = scanner.nextLine();
        int count = 0;
        for(Map.Entry<String,Student> student : classroom.getStudents().entrySet()){
            if(student.getValue().getTeacherUsername().equals(teacher.getUsername()) && student.getKey().equals(usernameStudent)){
                count++;
                System.out.println(student);
                while (true){
                    System.out.println("Enter grade want to edit");
                    double grade = utils.inputDouble(scanner);
                    if(grade>=0 && grade<=10){
                        student.getValue().setAvgScore(grade);
                        System.out.println(student);
                        break;
                    }else {
                        System.out.println("0 <= grade <= 10");
                    }
                }
                break;
            }
        }
        if(count<=0) System.out.println("Don't have student has username is: "+usernameStudent+" in your class!");
    }

}