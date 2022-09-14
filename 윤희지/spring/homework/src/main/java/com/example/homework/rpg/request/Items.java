package com.example.homework.rpg.request;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter

public class Items {
    private String name;
    private Integer price;
    private String description;
    private Integer atk;
}
