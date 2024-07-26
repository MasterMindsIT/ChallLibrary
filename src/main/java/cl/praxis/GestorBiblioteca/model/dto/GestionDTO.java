package cl.praxis.GestorBiblioteca.model.dto;

public class GestionDTO {
    private int id;
    private int bookId;
    private int userId;
    private String accion;

    public GestionDTO() {
    }

    public GestionDTO(int id, int bookId, int userId, String accion) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.accion = accion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
