package cl.praxis.GestorBiblioteca.model.dto;

public class Author {
  private int id;
  private String name;
  private String lastname;
  private int yearOfBirth;

  public Author() {
  }

  public Author(int id, String name, String lastname, int yearOfBirth) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.yearOfBirth = yearOfBirth;
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

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }
}
