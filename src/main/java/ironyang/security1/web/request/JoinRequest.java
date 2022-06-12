package ironyang.security1.web.request;

import ironyang.security1.domain.Role;
import ironyang.security1.service.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class JoinRequest {
    private String name;
    private String email;
    private String password;

    @Builder
    public JoinRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDto toDto() {
        return UserDto.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .role(Role.USER)
                .build();
    }
}
