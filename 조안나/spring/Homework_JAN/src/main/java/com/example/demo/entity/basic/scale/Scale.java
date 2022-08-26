package com.example.demo.entity.basic.scale;

import lombok.Getter;

@Getter
public enum Scale {
    C("도"),
    D("레"),
    E("미"),
    F("파"),
    G("솔"),
    A("라"),
    B("시");

    private String pitchName;

    Scale(String pitchName) {
        this.pitchName = pitchName;
    }

}