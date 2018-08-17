package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> showUsers() {
        return userService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User userPost(@RequestBody User user) {
        return userService.addUser(user);
    }
}
