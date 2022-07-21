package com.example.homework.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.IntSupplier;

@RestController
public class HW_RestController {

    @GetMapping("/homework1")
    public int dice() {
            return (int) (Math.random()*6) + 1;
    }
}
