package kr.eddi.demo.controller.basic.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.DataFormatException;

//Controller 는 올드하지만 리턴값에 html파일경로를 지정할 수 있음.
@Slf4j
@Controller
public class FirstController {

    //Locale은 다국어 언어팩.

    @GetMapping("/what-time-is-it")
    public String whatTimeIsIt (Locale locale, Model model) {
        log.info("현재시각 메소드가 동작합니다.");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);
        //model.addAttribute()는 HashMap처럼 특정 키값이 밸류값을 맵핑시키는 것이라 봐도 무방.
        //즉 servTime에 formattedDate인 형식을 갖춘 날짜가 맵핑됨.
        //model.addAttribute()하면 HTML에서 Thymeleaf 등을 통해서 정보를 읽을 수 있음.
        model.addAttribute("servTime", formattedDate);
        //resources 에 있는 html을 리턴시키게 됨.
        return "basic/first/WhatTimeIsIt";

    }

}
