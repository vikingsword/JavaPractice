package vikingar.basicspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vikingar.basicspring.service.CatService;

/**
 * @author: vikingar
 * @time: 2024/1/9 12:49
 * @description:
 */
@RestController
@RequestMapping("cat")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("name")
    public String getCatName() {
        return catService.getName();
    }



}
