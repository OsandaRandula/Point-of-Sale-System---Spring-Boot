package ijse.POS.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ijse.POS.entity.User;
import ijse.POS.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("auth/users")
    public java.util.List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("auth/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if(user != null) {
            return ResponseEntity.status(200).body(user);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("auth/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);

        return ResponseEntity.status(201).body(createdUser);
    }

    @PutMapping("/auth/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = userService.updateUser(id, user);

        if(updateUser != null) {
            return ResponseEntity.status(200).body(updateUser);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
    
    @DeleteMapping("/auth/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
}