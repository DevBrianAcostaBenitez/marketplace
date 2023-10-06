package org.factoriaf5.comicbooks.roles;
import java.util.List;

import org.factoriaf5.comicbooks.genres.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

   
    public Role getRoleById(Long id) {
     Role role= repository.findById(id).orElseThrow();
        return role;
    }

    

}
