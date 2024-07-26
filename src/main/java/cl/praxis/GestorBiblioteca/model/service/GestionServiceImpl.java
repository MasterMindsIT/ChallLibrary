package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.model.dto.Book;
import cl.praxis.GestorBiblioteca.model.dto.Gestion;
import cl.praxis.GestorBiblioteca.model.dto.GestionDTO;
import cl.praxis.GestorBiblioteca.model.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GestionServiceImpl implements IGestion{
    private static final Logger logger = LoggerFactory.getLogger(GestionServiceImpl.class);
    List<Gestion> gestionList;
    BookService bookService;
    IUser userService;
    public GestionServiceImpl(BookService bookService, IUser userService){
        this.bookService = bookService;
        this.userService = userService;
        gestionList =  new ArrayList<>();

    }



    @Override
    public List<Gestion> findAll() {

        return gestionList;
    }

    @Override
    public boolean prestar(GestionDTO gestion) {
        if(gestion.getAccion().equalsIgnoreCase("PRESTAR")) {

            if (bookService.disponibleBook(gestion.getBookId())) {
                Book book = bookService.findOne(gestion.getBookId());
                User user = userService.findOne(gestion.getUserId());

                book.setStock(book.getStock() - 1);
                book.setStockPrestado(book.getStockPrestado()+1);
                Gestion newGestion = new Gestion(newId(),gestion.getBookId(),book, gestion.getUserId(),user, gestion.getAccion() );
                gestionList.add(newGestion);

                return true;
            }else{
                logger.info("No quedan unidades disponibles");
            }
        }
        if(gestion.getAccion().equalsIgnoreCase("DEVOLVER")) {
            if(bookService.prestadosBook(gestion.getBookId())) {
                Book book = bookService.findOne(gestion.getBookId());
                User user = userService.findOne(gestion.getUserId());

                book.setStock(book.getStock() + 1);
                book.setStockPrestado(book.getStockPrestado()-1);
                Gestion newGestion = new Gestion(newId(),gestion.getBookId(),book, gestion.getUserId(),user, gestion.getAccion() );
                gestionList.add(newGestion);

                return true;
            }else {
                logger.info("No hay unidades prestadas");
            }
        }
        return false;
    }

    int newId(){
        if(!gestionList.isEmpty()) {
            Gestion gestion = gestionList.stream().max(Comparator.comparing(Gestion::getId)).orElseThrow(NoSuchElementException::new);
            return gestion.getId() + 1;
        }
        return 1;
    }
}
