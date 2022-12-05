package kr.eddi.demo.entity.first;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;


@Getter
@Setter

public class AvgScore {
    private int[] score;
    private int sum;
    private double avg;
}


