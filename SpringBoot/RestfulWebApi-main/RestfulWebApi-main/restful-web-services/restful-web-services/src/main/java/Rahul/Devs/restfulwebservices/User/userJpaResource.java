package Rahul.Devs.restfulwebservices.User;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Rahul.Devs.restfulwebservices.jpa.userRepository;

import java.net.URI;
import java.util.*;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class userJpaResource {

  
    private userRepository repository;
    public userJpaResource( userRepository repository ) {
        this.repository = repository;

    }

    @GetMapping("/jpa/Users")
    public List<user> retrieveUser() {
        return repository.findAll();
    }

    @GetMapping("/jpa/Users/{n}")
    public EntityModel<user> retrieveSpecificUser(@PathVariable int n) {
    
        Optional<user> usr = repository.findById(n);
        if (usr.isEmpty())
            throw new UserNotFound("id:" + n);

            EntityModel<user> entitymodel = EntityModel.of(usr.get());
            WebMvcLinkBuilder link  = linkTo(methodOn(this.getClass()).retrieveUser());
            entitymodel.add(link.withRel("all users"));


        return entitymodel;

    }

    @DeleteMapping("/jpa/Users/{n}")
    public void DeleteUser(@PathVariable int n) {
        repository.deleteById(n);

    }
    @GetMapping("/jpa/Users/posts/{n}")
    public List<post> retrievePostOfAUser(@PathVariable int n) {
        Optional<user> usr = repository.findById(n);
        if (usr.isEmpty())
            throw new UserNotFound("id:" + n);

            return user.get().getPost();

    }

    @PostMapping("/jpa/Users")
    public ResponseEntity<user> post(@RequestBody user usr) {
        user newUser = repository.save(usr);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getID())
                .toUri();

        return ResponseEntity.created(location).build();

    }

}
