package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.User;
import cl.praxis.GestorBiblioteca.model.service.IUser;
import cl.praxis.GestorBiblioteca.model.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);
   IUser userService;
   public UserController(IUser userService){
       this.userService = userService;
   }
   @GetMapping
    public String findAll(Model model){
       model.addAttribute("users",userService.findAll());
       return  "userList";
   }
   @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
       model.addAttribute(userService.findOne(id));
       return "userOne";
   }
    @GetMapping("/new")
    public ModelAndView create(){
        return new ModelAndView("userNew");
    }
   @PostMapping("/new")
    public String create(@ModelAttribute User user,Model model){
       boolean result = userService.create(user);
       if (result){
           logger.info("User created successfully");
       } else {
           logger.error("Error al crear user");
       }
       return "redirect:/users";
   }
}
