package cl.praxis.GestorBiblioteca.model.service;
import cl.praxis.GestorBiblioteca.model.dto.Book;
import cl.praxis.GestorBiblioteca.model.dto.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

  private List<Book> bookList;
  private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

  private AuthorService authorService = new AuthorServiceImpl();

  public BookServiceImpl() {

    bookList = new ArrayList<>();

    bookList.add(new Book(1, "123", "Canción de Hielo y Fuego",
            1, authorService.findOne(1), "El invierno se acerca",3,0));
    bookList.add(new Book(2, "234", "El Resplandor",
            2,  authorService.findOne(2), "Las paredes sangran",2,0));
    bookList.add(new Book(3, "345", "Inferno",
            3,  authorService.findOne(3), "Es como el infierno pero sin i",1,0));
    bookList.add(new Book(4, "456", "Sapo y Sepo",
            4,  authorService.findOne(4), "Amigos inseparables",2,0));
  }

  public BookServiceImpl(List<Book> bookList) {
    this.bookList = bookList;
  }

  @Override
  public List<Book> findAll() {

    logger.info("Ejecutando findAll de BookServiceImpl");

    return bookList;
  }

  @Override
  public Book findOne(int id) {
    return bookList.stream()
            .filter(book -> book.getId() == id)
            .findFirst()
            .orElse(null);
  }

  @Override
  public boolean create(BookDTO b) {
    Book newBook = new Book(getNewId(),b.getIsbn(),b.getTitle(),b.getAuthorId(), authorService.findOne(b.getAuthorId()),b.getExtract(),b.getStock(),0);
    bookList.add(newBook);
    return true;
  }

  private int getNewId() {
    Book book = bookList.stream().max(Comparator.comparing(Book::getId)).orElseThrow(NoSuchElementException::new);
    return book.getId()+1;
  }

  @Override
  public boolean update(BookDTO b) {

    Book bookUp = findOne(b.getId());
    bookUp.setTitle(b.getTitle());
    bookUp.setExtract(b.getExtract());
    bookUp.setIsbn(b.getIsbn());
    bookUp.setStock(b.getStock());
    bookUp.setAuthorId(b.getAuthorId());
    bookUp.setAuthor(authorService.findOne(b.getAuthorId()));
    bookUp.setStockPrestado(bookUp.getStockPrestado());
    return true;
  }



  @Override
  public boolean delete(int id) {

    Book b = findOne(id);
    if (b != null){
      bookList.remove(b);
      return true;
    }

    return false;
  }

  @Override
  public List<Book> buscar(String texto) {
    return bookList.stream()
            .filter(book -> book.getAuthor().getName().contains(texto))
            .filter(book -> book.getTitle().contains(texto))
            .toList();
  }

  @Override
  public boolean disponibleBook(int id) {
    Book book = findOne(id);
      return book.getStock() > 0;
  }

  @Override
  public boolean prestadosBook(int id) {
    Book book = findOne(id);
    return book.getStockPrestado() > 0;
  }
}
