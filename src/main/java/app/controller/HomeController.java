package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage() {
        return "hello";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="/users", method = RequestMethod.GET)
    public List<User> showUsers() {
        return userService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/userA", method = RequestMethod.GET)
    public User getByAge(){
        return userService.getByAge(29);
    }

    //Good!!!
    @RequestMapping(path = "userGet/{mobileNo}", method = RequestMethod.GET)
    public User getByNumber(@PathVariable Long mobileNo) {
        return userService.getByNumber(mobileNo);
    }

    /*@RequestMapping(path = "userPost/", method = RequestMethod.POST)
    public User*/

    @PostMapping(value = "/post")
    public User userPost(@RequestBody User user) {
        return user;
    }
}
