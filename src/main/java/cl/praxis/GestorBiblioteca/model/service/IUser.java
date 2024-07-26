package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.model.dto.User;

import java.util.List;

public interface IUser {

    List<User> findAll();
    User findOne(int id);
    boolean create(User user);
    List<User> delete(int id);
}
