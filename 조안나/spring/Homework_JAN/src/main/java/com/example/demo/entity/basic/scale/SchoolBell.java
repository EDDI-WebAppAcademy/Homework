package com.example.demo.entity.basic.scale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/schoolbell")
public class SchoolBell {

    @GetMapping("/test")
    public List<String> readScale(){
        List<Scale> lyricsCode = new ArrayList<>();
        lyricsCode.add(Scale.G);
        lyricsCode.add(Scale.G);
        lyricsCode.add(Scale.A);
        lyricsCode.add(Scale.A);
        lyricsCode.add(Scale.G);
        lyricsCode.add(Scale.G);
        lyricsCode.add(Scale.E);

        List<String> syllableNames = new ArrayList<>();
        lyricsCode.forEach(scale -> syllableNames.add(scale.getPitchName()));

        return syllableNames;
    }
}
