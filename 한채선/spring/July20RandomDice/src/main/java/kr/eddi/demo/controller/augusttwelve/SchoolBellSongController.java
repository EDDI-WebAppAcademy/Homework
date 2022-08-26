package kr.eddi.demo.controller.augusttwelve;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/java-study")
public class SchoolBellSongController {

    @GetMapping("/School-bell-song")
    public String schoolBellSong() {
        return null;
    }
}
