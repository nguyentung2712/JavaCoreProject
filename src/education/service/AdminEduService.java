package education.service;

import education.entities.classroom.Classroom;
import education.entities.student.Student;
import education.entities.subject.Subject;
import education.entities.subject.Type;
import education.entities.teacher.Teacher;
import education.service.impl.ClassroomService;
import login.entities.Account;
import login.entities.AccountType;
import login.view.View;
import utils.Utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminEduService implements ClassroomService<Classroom> {

    Scanner scanner = new Scanner(System.in);
    View view = new View();
    Utils utils = new Utils();

    // 1. View all subject
    public void viewAllSubject(Classroom classroom){
        System.out.println(classroom.getSubjects());
    }

    // 2. Find subject by id
    public void findSubjectById(Classroom classroom){
        int id = utils.idSubjectExistedCheck(classroom);
        System.out.println(classroom.getSubjects().get(id));
    }

    // 3. Subject management
    public void subjectManagement(Classroom classroom){
        viewAllSubject(classroom);
        while (true){
            view.subjectManagementEduAdmin();
            int chooseCommand = utils.inputInt(scanner);
            switch (chooseCommand){
                case 1 -> addSubject(classroom);
                case 2 -> editInfoSubject(classroom);
                case 3 -> deleteSubject(classroom);
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            break;
        }
    }
    // 3.1. Add subject
    public void addSubject(Classroom classroom){
        int id = utils.idSubjectNoExistedCheck(classroom);
        String name = utils.nameSubjectCheck();
        int numberOfCredit = utils.numberOfCreditSubjectCheck();
        Type type = utils.typeSubjectOrMajorCheck();
        Subject subject = new Subject(id,name,numberOfCredit,type);
        classroom.getSubjects().put(subject.getId(),subject);
        viewAllSubject(classroom);
    }
    // 3.2. Edit info subject
    public void editInfoSubject(Classroom classroom){
        int id = utils.idSubjectExistedCheck(classroom);
        while (true){
            view.menuEditInfoSubject();
            int chooseCommandEdit = utils.inputInt(scanner);
            switch (chooseCommandEdit){
                case 1 -> {
                    String name = utils.nameSubjectCheck();
                    classroom.getSubjects().get(id).setName(name);
                }
                case 2 -> {
                    int numberOfCredit = utils.numberOfCreditSubjectCheck();
                    classroom.getSubjects().get(id).setNumberOfCredits(numberOfCredit);
                }
                case 3 -> {
                    Type type = utils.typeSubjectOrMajorCheck();
                    classroom.getSubjects().get(id).setType(type);
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            System.out.println(classroom.getSubjects().get(id));
            break;
        }
    }
    // 3.3. Delete subject
    public void deleteSubject(Classroom classroom){
        int id = utils.idSubjectExistedCheck(classroom);
        classroom.getSubjects().remove(id);
        System.out.println("Subject was deleted!");
        viewAllSubject(classroom);
    }

    // 4. View all student accounts
    public void viewAllStudentAccount(Classroom classroom){
        for(Map.Entry<String,Student> student : classroom.getStudents().entrySet()){
            System.out.println(student.getValue().studentInfoAdminEduView());
        }
    }

    // 5. Find student account by username
    public void findStudentAccountByUsername(Classroom classroom){
        viewAllStudentAccount(classroom);
        String username = utils.studentUsernameExistedCheck(classroom);
        System.out.println(classroom.getStudents().get(username).studentInfoAdminEduView());
    }

    // 6. Student management
    public void studentManagement(LinkedHashMap<String,Account> accounts, Classroom classroom){
        viewAllStudentAccount(classroom);
        while (true){
            view.studentManagementEduAdmin();
            int chooseCommand = utils.inputInt(scanner);
            switch (chooseCommand){
                case 1 -> createNewStudentAccount(accounts,classroom);
                case 2 -> editStudentAccount(accounts,classroom);
                case 3 -> removeStudentAccount(classroom);
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            break;
        }
    }
    // 6.1. Create new student account
    public void createNewStudentAccount(LinkedHashMap<String,Account> accounts, Classroom classroom){
        String username = utils.usernameCheck(accounts);
        String email = utils.emailEduCheck(accounts);
        String password = utils.passwordCheck();
        String name = utils.nameCheck();
        String phone = utils.phoneEduCheck(accounts);
        String address = utils.addressCheck();
        double avgScore = utils.avgScoreCheck();
        String teacherUsername = utils.teacherUsernameExistedCheck(classroom);
        Student student = new Student(username,email,password,AccountType.Student,name,phone,address,avgScore,teacherUsername);
        accounts.put(student.getUsername(),student);
        classroom.getStudents().put(student.getUsername(),student);
        System.out.println(student.studentInfoAdminEduView());
    }
    // 6.2. Edit student account
    public void editStudentAccount(LinkedHashMap<String,Account> accounts, Classroom classroom){
        String username = utils.studentUsernameExistedCheck(classroom);
        while (true){
            view.menuEditInfoStudent();
            int commandChoose = utils.inputInt(scanner);
            switch (commandChoose){
                case 1 -> {
                    String email = utils.emailEduCheck(accounts);
                    classroom.getStudents().get(username).setEmail(email);
                }
                case 2 -> {
                    String password = utils.passwordCheck();
                    classroom.getStudents().get(username).setPassword(password);
                }
                case 3 -> {
                    String name = utils.nameCheck();
                    classroom.getStudents().get(username).setName(name);
                }
                case 4 -> {
                    String phone = utils.phoneEduCheck(accounts);
                    classroom.getStudents().get(username).setPhone(phone);
                }
                case 5 -> {
                    String address = utils.addressCheck();
                    classroom.getStudents().get(username).setAddress(address);
                }
                case 6 -> {
                    double avgScore = utils.avgScoreCheck();
                    classroom.getStudents().get(username).setAvgScore(avgScore);
                }
                case 7 -> {
                    String teacherUsername = utils.teacherUsernameExistedCheck(classroom);
                    classroom.getStudents().get(username).setTeacherUsername(teacherUsername);
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            System.out.println(classroom.getStudents().get(username));
            break;
        }
    }
    // 6.3. Remove student account
    public void removeStudentAccount(Classroom classroom){
        String username = utils.studentUsernameExistedCheck(classroom);
        classroom.getStudents().remove(username);
        System.out.println("Student account was removed!");
        viewAllStudentAccount(classroom);
    }

    // 7. View all teacher account
    public void viewAllTeacherAccount(Classroom classroom){
        for(Map.Entry<String,Teacher> teacher : classroom.getTeachers().entrySet()){
            System.out.println(teacher.getValue().teacherInfoAdminEduView());
        }
    }

    // 8. Find teacher account by username
    public void findTeacherAccountByUsername(Classroom classroom){
        viewAllTeacherAccount(classroom);
        String username = utils.teacherUsernameExistedCheck(classroom);
        System.out.println(classroom.getTeachers().get(username).teacherInfoAdminEduView());
    }

    // 9. Teacher management
    public void teacherManagement(LinkedHashMap<String,Account> accounts, Classroom classroom){
        viewAllTeacherAccount(classroom);
        while (true){
            view.teacherManagementEduAdmin();
            int chooseCommand = utils.inputInt(scanner);
            switch (chooseCommand){
                case 1 -> createNewTeacherAccount(accounts,classroom);
                case 2 -> editTeacherAccount(accounts,classroom);
                case 3 -> removeTeacherAccount(classroom);
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            break;
        }
    }
    // 9.1. Create new teacher account
    public void createNewTeacherAccount(LinkedHashMap<String,Account> accounts, Classroom classroom){
        String username = utils.usernameCheck(accounts);
        String email = utils.emailEduCheck(accounts);
        String password = utils.passwordCheck();
        String name = utils.nameCheck();
        String phone = utils.phoneEduCheck(accounts);
        String address = utils.addressCheck();
        Type type = utils.typeSubjectOrMajorCheck();
        Teacher teacher = new Teacher(username,email,password,AccountType.Teacher,name,phone,address,type);
        accounts.put(teacher.getUsername(),teacher);
        classroom.getTeachers().put(teacher.getUsername(),teacher);
        System.out.println(teacher.teacherInfoAdminEduView());
    }
    // 9.2. Edit teacher account
    public void editTeacherAccount(LinkedHashMap<String,Account> accounts, Classroom classroom){
        String username = utils.teacherUsernameExistedCheck(classroom);
        while (true) {
            view.menuEditInfoTeacher();
            int commandChoose = utils.inputInt(scanner);
            switch (commandChoose) {
                case 1 -> {
                    String email = utils.emailEduCheck(accounts);
                    classroom.getTeachers().get(username).setEmail(email);
                }
                case 2 -> {
                    String password = utils.passwordCheck();
                    classroom.getTeachers().get(username).setPassword(password);
                }
                case 3 -> {
                    String name = utils.nameCheck();
                    classroom.getTeachers().get(username).setName(name);
                }
                case 4 -> {
                    String phone = utils.phoneEduCheck(accounts);
                    classroom.getTeachers().get(username).setPhone(phone);
                }
                case 5 -> {
                    String address = utils.addressCheck();
                    classroom.getTeachers().get(username).setAddress(address);
                }
                case 6 -> {
                    Type major = utils.typeSubjectOrMajorCheck();
                    classroom.getTeachers().get(username).setMajor(major);
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            System.out.println(classroom.getTeachers().get(username).teacherInfoAdminEduView());
            break;
        }
    }
    // 9.3. Remove teacher account
    public void removeTeacherAccount(Classroom classroom){
        String username = utils.teacherUsernameExistedCheck(classroom);
        classroom.getTeachers().remove(username);
        System.out.println("Teacher account was removed!");
        viewAllTeacherAccount(classroom);
    }

}