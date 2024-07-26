package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.model.dto.Book;
import cl.praxis.GestorBiblioteca.model.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements IUser{

    private final List<User> userList;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(){
        userList = new ArrayList<>();
        userList.add(new User(1,"Junito", "Perez","123"));
        userList.add(new User(2,"Ana", "Gomez","456"));
        userList.add(new User(3,"Zara", "Paez", "789"));
        userList.add(new User(4,"Michael", "Vazquez","234"));
    }
    @Override
    public List<User> findAll() {
        logger.info("FindAll");
        return userList;
    }

    @Override
    public User findOne(int id) {
        logger.info("FindUser");
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean create(User user) {
        user.setId(getNewID());
        logger.info("CreateUser");
        return userList.add(user);
    }

    private int getNewID() {
        User user = userList.stream().max(Comparator.comparing(User::getId)).orElseThrow(NoSuchElementException::new);
        return user.getId()+1;
    }

    @Override
    public List<User> delete(int id) {
        logger.info("DeleteUser");
        User user = findOne(id);
        if (user != null){
            userList.remove(user);
        }
        return userList;
    }
}
