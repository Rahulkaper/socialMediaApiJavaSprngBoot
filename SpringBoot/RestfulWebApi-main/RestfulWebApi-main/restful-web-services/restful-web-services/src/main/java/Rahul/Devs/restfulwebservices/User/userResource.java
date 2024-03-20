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

import java.net.URI;
import java.util.*;

import javax.swing.text.html.parser.Entity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class userResource {

    private UserDaoService service;

    public userResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/Users")
    public List<user> retrieveUser() {
        return service.findAll();
    }

    @GetMapping("/Users/{n}")
    public EntityModel<user> retrieveSpecificUser(@PathVariable int n) {
    
        user usr = service.findone(n);
        if (usr == null)
            throw new UserNotFound("id:" + n);

            EntityModel<user> entitymodel = EntityModel.of(usr);
            WebMvcLinkBuilder link  = linkTo(methodOn(this.getClass()).retrieveUser());
            entitymodel.add(link.withRel("all users"));


        return entitymodel;

    }

    @DeleteMapping("/Users/{n}")
    public void DeleteUser(@PathVariable int n) {
        service.DeleteOne(n);

    }

    @PostMapping("/Users")
    public ResponseEntity<user> post(@RequestBody user usr) {
        user newUser = service.postUser(usr);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getID())
                .toUri();

        return ResponseEntity.created(location).build();

    }

}
