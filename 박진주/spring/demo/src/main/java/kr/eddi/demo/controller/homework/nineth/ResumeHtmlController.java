package kr.eddi.demo.controller.homework.nineth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/html")
public class ResumeHtmlController {

   @GetMapping("/resume")
   public String ResumeTable(){
       log.info("resume table");

       return "/homework/nineth/resume";
   }
}
