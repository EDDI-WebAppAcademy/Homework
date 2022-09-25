package kr.eddi.demo.controller.jpa.product;

import kr.eddi.demo.entity.jpa.products.request.JoinRequest;
import kr.eddi.demo.service.jpa.products.GuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/goods/guest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class GuestController {

    @Autowired
    private GuestService service;

    @PostMapping("/join")
    public void join(@RequestBody JoinRequest joinRequest){
        log.info("join()");

        service.join(joinRequest);
    }
}
