package cl.praxis.GestorBiblioteca.model.service;


import cl.praxis.GestorBiblioteca.model.dto.Book;
import cl.praxis.GestorBiblioteca.model.dto.BookDTO;

import java.util.List;

public interface BookService {
  List<Book> findAll();
  Book findOne(int id);
  boolean create(BookDTO b);
  boolean update(BookDTO b);

  boolean delete(int id);
  List<Book> buscar(String texto);

  boolean disponibleBook(int id);
  boolean prestadosBook(int id);
}
