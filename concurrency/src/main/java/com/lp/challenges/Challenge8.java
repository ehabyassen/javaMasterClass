package com.lp.challenges;

import java.util.concurrent.locks.ReentrantLock;

public class Challenge8 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Tutor tutor = new Tutor(lock);
        Student student = new Student(tutor, lock);
        tutor.setStudent(student);
        new Thread(() -> tutor.studyTime()).start();
        new Thread(() -> student.handInAssignment()).start();
    }
}

class Tutor {
    private Student student;
    private ReentrantLock lock;

    public Tutor(ReentrantLock lock) {
        this.lock = lock;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public synchronized void studyTime() {
        if (lock.tryLock()) {
            try {
                System.out.println("Tutor has arrived");
                try {
                    // wait for student to arrive and hand in assignment
                    Thread.sleep(300);
                } catch (InterruptedException e) {}
                student.startStudy();
                System.out.println("Tutor is studying with student");
            } finally {
                lock.unlock();
            }
        }
    }

    public void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}

class Student {

    private Tutor tutor;
    private ReentrantLock lock;

    Student(Tutor tutor, ReentrantLock lock) {
        this.tutor = tutor;
        this.lock = lock;
    }

    public void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    public void handInAssignment() {
        while (lock.isLocked()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        tutor.getProgressReport();
        System.out.println("Student handed in assignment");
    }
}
