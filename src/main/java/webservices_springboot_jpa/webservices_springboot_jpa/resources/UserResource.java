package webservices_springboot_jpa.webservices_springboot_jpa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.User;
import webservices_springboot_jpa.webservices_springboot_jpa.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = userService.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/")
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj=userService.insertUser(obj);
        return ResponseEntity.ok().body(obj);
    }
}
