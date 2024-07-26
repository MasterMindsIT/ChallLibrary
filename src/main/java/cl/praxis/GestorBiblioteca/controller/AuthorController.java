package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Author;
import cl.praxis.GestorBiblioteca.model.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {
  private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);

  private final AuthorService service;

  public AuthorController(AuthorService service) {
    this.service = service;
  }

  @GetMapping
  public String findAll(Model model){
    logger.info("Ejecutando findAll de AuthorController");
    model.addAttribute("authors", service.findAll());
    return "authorsList";
  }

  @GetMapping("{id}")
  public String findOne(@PathVariable("id") int id, Model model){
    model.addAttribute("author", service.findOne(id));
    return "authorEdit";
  }

  @PostMapping
  public String update(@ModelAttribute Author author){
    boolean result = service.update(author);

    return "redirect:/authors";
  }

  @GetMapping("/new")
  public String newAuthor(){
    return "authorNew";
  }

  @PostMapping("/new")
  public String createAuthor(@ModelAttribute Author author){
    boolean result = service.create(author);

    return "redirect:/authors";
  }

}
