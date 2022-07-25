package com.example.homework.second.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter

public class ClassRoom {
    private final int MAX = 100;
    private String roomName;
    private Student[] students;
    private int minScore;
    private int totalScore;
    private int studentNum;

    public ClassRoom(int studentNum, int minScore) {
        this.studentNum = studentNum;
        this.students = new Student[studentNum];
        this.minScore = minScore;
    }

    public void makeStudent() {
        for (int i = 0; i < students.length ; i++) {
            students[i] = new Student();
        }
    }

    public void doExam() {
        for (int i = 0; i < students.length ; i++) {
            Random random = new Random();
            students[i].setScore(random.nextInt(MAX - minScore) + minScore);
        }
    }

    public double calAvg() {
        for (int i = 0; i < students.length ; i++) {
            totalScore += students[i].getScore();
        }
        return totalScore / studentNum;
    }
}
