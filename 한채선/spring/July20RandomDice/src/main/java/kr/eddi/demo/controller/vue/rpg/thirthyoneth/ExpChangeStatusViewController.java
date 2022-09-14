package kr.eddi.demo.controller.vue.rpg.thirthyoneth;

import kr.eddi.demo.entity.vue.thirthyoneth.ExpChangeManager;
import kr.eddi.demo.entity.vue.thirthyoneth.ExpChangeStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/31th/exp-change-status-view-controller")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ExpChangeStatusViewController {

    private ExpChangeManager expChangeManager = new ExpChangeManager();

    @GetMapping("/exp-change-to-status-list")
    public List<ExpChangeStatus> expChangeToStatusList() {
        log.info("expChangeToStatusList()");
        return expChangeManager.getExchangeExpList();
    }
}
