package com.example.homework.ninth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/homework9")
public class ResumeController {
    @GetMapping("/resume-table")
    public String homeworkResume() {
        log.info("resume-table");

        return "ninth/resume-table";
    }
}
