package com.lp.challenges;

public class Challenge9 {
    public static void main(String[] args) {
        final NewTutor tutor = new NewTutor();
        final NewStudent student = new NewStudent(tutor);
        tutor.setStudent(student);
        new Thread(() -> tutor.studyTime()).start();
        new Thread(() -> student.handInAssignment()).start();
    }
}

class NewTutor {
    private NewStudent student;

    public void setStudent(NewStudent student) {
        this.student = student;
    }

    public void studyTime() {
        synchronized (this) {
            System.out.println("Tutor has arrived");
            synchronized (student) {
                student.startStudy();
                System.out.println("Tutor is studying with student");
            }
        }
    }

    public void getProgressReport() {
        System.out.println("Tutor gave progress report");
    }
}

class NewStudent {

    private NewTutor tutor;

    NewStudent(NewTutor tutor) {
        this.tutor = tutor;
    }

    public void startStudy() {
        System.out.println("Student is studying");
    }

    public void handInAssignment() {
        synchronized (tutor) {
            tutor.getProgressReport();
            synchronized (this) {
                System.out.println("Student handed in assignment");
            }
        }
    }
}