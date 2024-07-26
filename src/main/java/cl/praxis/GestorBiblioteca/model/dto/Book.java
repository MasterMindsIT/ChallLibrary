package cl.praxis.GestorBiblioteca.model.dto;

public class Book {
  private int id;
  private String isbn;
  private String title;
  private int authorId;
  private Author author;
  private String extract;

  private int stock;
  private int stockPrestado;

  public Book() {
  }


  public Book(int id, String isbn, String title, int authorId, Author author, String extract, int stock, int stockPrestado) {
    this.id = id;
    this.isbn = isbn;
    this.title = title;
    this.authorId = authorId;
    this.author = author;
    this.extract = extract;
    this.stock = stock;
    this.stockPrestado = stockPrestado;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  public String getExtract() {
    return extract;
  }

  public void setExtract(String extract) {
    this.extract = extract;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public int getStockPrestado() {
    return stockPrestado;
  }

  public void setStockPrestado(int stockPrestado) {
    this.stockPrestado = stockPrestado;
  }
}
