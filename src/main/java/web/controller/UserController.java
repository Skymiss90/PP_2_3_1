package web.controller;
import web.model.User;
import web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAll(ModelMap model) {
        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        return "users";
    }

    @PostMapping(value = "/newUser")
    public String createUser (User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser (@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser (@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/edit";
    }

    @PutMapping(value = "/updateUser/")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
