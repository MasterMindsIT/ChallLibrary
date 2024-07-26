package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Gestion;
import cl.praxis.GestorBiblioteca.model.dto.GestionDTO;
import cl.praxis.GestorBiblioteca.model.service.BookService;
import cl.praxis.GestorBiblioteca.model.service.IGestion;
import cl.praxis.GestorBiblioteca.model.service.IUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gestiones")
public class GestionController {
    private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);
    private final IGestion gestionLibros;
    private final IUser usuarios;
    private final BookService bookService;
    public GestionController(IGestion gestionLibros, IUser usuarios, BookService bookService){
        this.gestionLibros = gestionLibros;
        this.usuarios = usuarios;
        this.bookService = bookService;
    }
    @GetMapping
    public String findAll(Model model){
        model.addAttribute("gestions",gestionLibros.findAll());
        return "gestionList";
    }
    @GetMapping("/new")
    public ModelAndView crear(Model model){
        model.addAttribute("books",bookService.findAll());
        model.addAttribute("users",usuarios.findAll());
        return new ModelAndView("gestionNew");
    }
    @PostMapping("/new")
    public String create(@ModelAttribute GestionDTO gestion, Model model){
        boolean result = gestionLibros.prestar(gestion);
        if (result){
            logger.info("User created successfully");
        } else {
            logger.error("Error al crear user");
        }
        model.addAttribute(gestionLibros.findAll());
        return "redirect:/gestiones";
    }


}
