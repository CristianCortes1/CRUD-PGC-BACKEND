package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.User;

public interface AuthService {
    User login(String username, String password);

    Boolean verifyUsername(String username);
}
