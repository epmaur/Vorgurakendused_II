package ee.ttu.vorgurakendused.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping(value = "/")
    public String trainings() {
        return "trainings";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/a")
    public String a() {
        return "a";
    }

    @GetMapping(value = "/registration")
    public String register() {
        return "register";
    }

}
