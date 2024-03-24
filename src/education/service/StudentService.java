package education.service;

import education.entities.classroom.Classroom;
import education.entities.student.Student;
import education.entities.teacher.Teacher;
import education.service.impl.ClassroomService;
import utils.Utils;

import java.util.Map;

public class StudentService implements ClassroomService<Classroom> {
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

    // 3. View student's own information
    public void viewStudentInfo(Student student){
        System.out.println(student.studentInfoStudentView());
    }

    // 4. View information about student's teachers
    public void showTeacherTeach(Student student, Classroom classroom){

        int count = 0;
        for(Map.Entry<String, Teacher> teacher : classroom.getTeachers().entrySet()){
            if(student.getTeacherUsername().equals(teacher.getValue().getUsername())){
                count++;
                System.out.println(teacher);
            }
        }
        if(count<=0) System.out.println("You don't have a teacher assigned yet");
    }

}