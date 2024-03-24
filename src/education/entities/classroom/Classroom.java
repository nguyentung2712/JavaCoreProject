package education.entities.classroom;

import education.entities.student.Student;
import education.entities.subject.Subject;
import education.entities.teacher.Teacher;

import java.util.LinkedHashMap;
import java.util.Map;

public class Classroom {
    private Map<Integer, Subject> subjects;
    private LinkedHashMap<String, Teacher> teachers;
    private LinkedHashMap<String, Student> students;

    public Classroom(Map<Integer, Subject> subjects, LinkedHashMap<String, Teacher> teachers, LinkedHashMap<String, Student> students) {
        this.subjects = subjects;
        this.teachers = teachers;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                " subjects: " + subjects +
                ", teachers: " + teachers +
                ", students: " + students +
                '}';
    }

    public Map<Integer, Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<Integer, Subject> subjects) {
        this.subjects = subjects;
    }

    public LinkedHashMap<String, Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(LinkedHashMap<String, Teacher> teachers) {
        this.teachers = teachers;
    }

    public LinkedHashMap<String, Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedHashMap<String, Student> students) {
        this.students = students;
    }
}
