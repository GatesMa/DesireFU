package cn.gatesma.desirefu.config.api.generate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        System.out.println("doc.html");
        return "redirect:doc.html";
    }
}
