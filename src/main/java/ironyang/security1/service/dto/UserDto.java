package ironyang.security1.service.dto;

import ironyang.security1.domain.Role;
import ironyang.security1.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private Role role;

    @Builder
    public UserDto(Long id, String name, String password, String email, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public static UserDto of(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .name(this.name)
                .password(this.password)
                .email(this.email)
                .role(this.role)
                .build();
    }
}
