package com.example.homework.second.entity;

public class ClassAverage {

    private int studentNum;
    private int minScore;
    private int totalScore;
    public ClassAverage(int studentNum, int minScore) {
        this.studentNum = studentNum;
        this.minScore = minScore;
    }

    public int randomScore() {
        for (int i = 0; i < studentNum; i++) {
            totalScore += (int)(Math.random()*(101 - minScore) + minScore);
        }
        return totalScore;
    }

    public double calAvg() {
        return totalScore/studentNum;
    }
}
