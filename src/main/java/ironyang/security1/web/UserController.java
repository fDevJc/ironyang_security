package ironyang.security1.web;

import ironyang.security1.domain.User;
import ironyang.security1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/welcome")
    public ResponseEntity welcome() {
        return ResponseEntity.ok("welcome");
    }


    @PostMapping("/users")
    public ResponseEntity join(@RequestBody User user) {
        Long savedId = userService.join(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedId);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        User foundUser = userService.findOne(id);
        return ResponseEntity.ok(foundUser);
    }
}
