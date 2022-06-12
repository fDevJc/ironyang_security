package ironyang.security1.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import ironyang.security1.service.UserService;
import ironyang.security1.service.dto.UserDto;
import ironyang.security1.web.request.JoinRequest;
import ironyang.security1.web.response.JoinResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    /*
        회원가입
     */
    @PostMapping("/users")
    public ResponseEntity<JoinResponse> join(@RequestBody JoinRequest joinRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(JoinResponse.of(userService.join(joinRequest.toDto())));
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        System.out.println("s = " + s);
        ObjectMapper objectMapper = new ObjectMapper();
        JoinRequest joinRequest = objectMapper.readValue(s, JoinRequest.class);
        System.out.println("joinRequest = " + joinRequest);
        log.info("UserController.login()");
        return "ok";
    }
}
