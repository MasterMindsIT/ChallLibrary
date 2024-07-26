package cl.praxis.GestorBiblioteca.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gestion {
    private int id;
    private int book_id;
    private Book book;

    private int user_id;
    private User user;
    private String accion;

    public Gestion() {
    }

    public Gestion(int id, int book_id, Book book, int user_id, User user, String accion) {
        this.id = id;
        this.book_id = book_id;
        this.book = book;
        this.user_id = user_id;
        this.user = user;
        this.accion = accion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
