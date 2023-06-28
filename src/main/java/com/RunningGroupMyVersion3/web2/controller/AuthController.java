package com.RunningGroupMyVersion3.web2.controller;

import com.RunningGroupMyVersion3.web2.models.RegistrationDto;
import com.RunningGroupMyVersion3.web2.models.UserEntity;
import com.RunningGroupMyVersion3.web2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String getRegisterForm(Model model){
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user",user);
        return "register";

    }
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user")RegistrationDto user, BindingResult result,Model model){
        UserEntity existingUserEmail = userService.findByEmail(user.getEmail());
        if(existingUserEmail !=null && existingUserEmail.getEmail() !=null && !existingUserEmail.getEmail().isEmpty()){
            return "redirect:/register?fail";

        }
        UserEntity existingUserUsername = userService.findByUsername(user.getUsername());
        if(existingUserUsername !=null && existingUserUsername.getUsername() !=null && !existingUserUsername.getUsername().isEmpty()){
            return "redirect:/register?fail";

        }
        if(result.hasErrors()){
            model.addAttribute("user,user");
            return "/register";
        }
        userService.saveUser(user);
        return "redirect:/clubs?success";

    }
    @GetMapping ("/login")
    public String loginPage(){
        return "login";
    }
}
