package education.entities.subject;

import education.entities.classroom.Classroom;

public class SubjectList {
    public void subjectList(Classroom classroom){
        // TECH subject
        Subject subjectTech1 = new Subject(1,"JavaCore",5,Type.TECH);
        Subject subjectTech2 = new Subject(2,"SpringBoost",5,Type.TECH);

        // BUSINESS subject
        Subject subjectBusiness1 = new Subject(3,"Accounting",5,Type.BUSINESS);
        Subject subjectBusiness2 = new Subject(4,"Management",5,Type.BUSINESS);

        // LANGUAGE subject
        Subject subjectLanguage1 = new Subject(5,"English",5,Type.LANGUAGE);
        Subject subjectLanguage2 = new Subject(6,"German",5,Type.LANGUAGE);

        classroom.getSubjects().put(subjectTech1.getId(),subjectTech1);
        classroom.getSubjects().put(subjectTech2.getId(),subjectTech2);
        classroom.getSubjects().put(subjectBusiness1.getId(),subjectBusiness1);
        classroom.getSubjects().put(subjectBusiness2.getId(),subjectBusiness2);
        classroom.getSubjects().put(subjectLanguage1.getId(),subjectLanguage1);
        classroom.getSubjects().put(subjectLanguage2.getId(),subjectLanguage2);
    }
}
