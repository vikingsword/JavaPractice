package top.vikingar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vikingar
 * @time 2024/2/16 17:03
 * @description
 */
@RestController
@RequestMapping("/api")
public class DashboardController {

    @GetMapping("test")
    public String test() {
        return "test";
    }

}
