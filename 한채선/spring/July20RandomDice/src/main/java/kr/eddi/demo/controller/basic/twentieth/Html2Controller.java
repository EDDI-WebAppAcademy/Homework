package kr.eddi.demo.controller.basic.twentieth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/html-controll-2")
public class Html2Controller {

    @GetMapping("/img-size-test")
    public String imgSizeTest() {
        log.info("img size test");

        return "/basic/twentieth/img-size-test";
    }

    @GetMapping("/display-method-test")
    public String displayMethodTest() {
        log.info("img size test");

        return "/basic/twentieth/display-method-test";
    }

    @GetMapping("/display-method-with-css")
    public String displayMethodWithCssTest() {
        log.info("css test");

        return "/basic/twentieth/display-method-with-css";
    }

    @GetMapping("/hyperlink-test")
    public String hyperlinkTest() {
        log.info("hyperlink test");

        return "/basic/twentieth/hyperlink-test";
    }

    @GetMapping("/form-test")
    public String formTest() {
        log.info("form test");

        return "/basic/twentieth/form-test";
    }

    @GetMapping("/checkbox-test")
    public String checkboxTest() {
        log.info("checkbox test");

        return "/basic/twentieth/checkbox-test";
    }

    @GetMapping("/radio-button-test")
    public String radioButtonTest() {
        log.info("radio button test");

        return "/basic/twentieth/radio-button-test";
    }

    @GetMapping("/login-form-test")
    public String loginFormTest() {
        log.info("login form test");

        return "/basic/twentieth/login-form-test";
    }


    @GetMapping("/login-form-test2")
    public String loginFormTest2() {
        log.info("login form test2");

        return "/basic/twentieth/login-form-test2";
    }

    @GetMapping("/number-form-test")
    public String numberFormTest() {
        log.info("number form test");

        return "/basic/twentieth/number-form-test";
    }

    @GetMapping("/drop-down-menu-test")
    public String dropDownMenuTest() {
        log.info("drop down menu test");

        return "/basic/twentieth/drop-down-menu";
    }



}
