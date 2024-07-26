package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.model.dto.Gestion;
import cl.praxis.GestorBiblioteca.model.dto.GestionDTO;

import java.util.List;

public interface IGestion {
    List<Gestion> findAll();

    boolean prestar(GestionDTO gestion);



}
