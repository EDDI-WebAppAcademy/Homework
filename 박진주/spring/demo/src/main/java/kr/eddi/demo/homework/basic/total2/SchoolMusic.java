package kr.eddi.demo.homework.basic.total2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SchoolMusic {
    public Map<String, Integer> schoolMusicPitch;
    public String[] schoolMusic = {"학", "교", "종", "이", "땡", "땡", "땡"};
    public int[] pitch = {5, 5, 6, 6, 5, 5, 3};

    public Map<String, Integer> playSchoolMusic(){
        schoolMusicPitch= new LinkedHashMap<>();

        for (int i = 0; i < schoolMusic.length; i++) {
            schoolMusicPitch.put(schoolMusic[i], pitch[i]);
        }
        return schoolMusicPitch;
    }

}
