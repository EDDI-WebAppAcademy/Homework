package kr.eddi.demo.controller.homework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/homework")
public class PortfolioController {

    @GetMapping("/portfolio")
    public String portfolio() {
        log.info("portfolio");

        return "homework/portfolio";
    }
}
