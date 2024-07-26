package cl.praxis.GestorBiblioteca.model.dto;

public class User {
    private int id;
    private String rut;
    private String name;
    private String lastName;

    public User() {
    }

    public User(int id, String name, String lastName, String rut) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.rut =  rut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
