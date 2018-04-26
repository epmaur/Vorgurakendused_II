package ee.ttu.vorgurakendused.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class UserController {
    private UserService userService;

    //@Autowired
    //private TokenStore tokenStore;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody UserRegistration userRegistration) {
        System.out.println(userRegistration);
        if(userService.getUser(userRegistration.getUsername()) != null)
            return "Error this username already exists";
        userService.save(new User(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
        return "User created";
    }

    @GetMapping(value = "/getUsername")
    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    /*
    @GetMapping(value = "/logout")
    public void logout(@RequestParam (value = "access_token") String accessToken) {
        tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken));
    }
    */



}
