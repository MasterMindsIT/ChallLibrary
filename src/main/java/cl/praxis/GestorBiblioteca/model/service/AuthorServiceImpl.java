package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Author;
import cl.praxis.GestorBiblioteca.model.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {

  private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);
  List<Author> authorList;

  public AuthorServiceImpl() {
    authorList = new ArrayList<>();
    authorList.add(new Author(1, "George", "Martin", 1948));
    authorList.add(new Author(2, "Stephen", "King", 1947));
    authorList.add(new Author(3, "Dan", "Brown", 1964));
    authorList.add(new Author(4, "Arnold", "Lobel", 1933));
  }

  public AuthorServiceImpl(List<Author> authorList) {
    this.authorList = authorList;
  }

  @Override
  public List<Author> findAll() {
    logger.warn("Ejecutando findAll de AuthorServiceImpl");
    return authorList;
  }

  @Override
  public Author findOne(int id) {
    return authorList.stream()
            .filter(author -> author.getId() == id)
            .findFirst()
            .orElse(null);
  }

  @Override
  public boolean create(Author a) {
    a.setId(getNewId());
    authorList.add(a);
    return true;
  }

  private int getNewId() {
    Author author = authorList
            .stream()
            .max(Comparator.comparing(Author::getId)).get();
    return author.getId()+1;
  }

  @Override
  public boolean update(Author a) {
    Author author = findOne(a.getId());
    author.setName(a.getName());
    author.setLastname(a.getLastname());
    author.setYearOfBirth(a.getYearOfBirth());
    return true;
  }

  @Override
  public boolean delete(int id) {
    return false;
  }
}
