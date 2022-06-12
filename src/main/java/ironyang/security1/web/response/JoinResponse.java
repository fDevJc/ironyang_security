package ironyang.security1.web.response;

import ironyang.security1.service.dto.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
public class JoinResponse {
    private Long id;
    private String name;
    private String email;

    @Builder
    public JoinResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static JoinResponse of(UserDto userDto) {
        return JoinResponse.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
    }
}
