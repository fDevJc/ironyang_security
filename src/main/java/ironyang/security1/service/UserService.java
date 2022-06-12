package ironyang.security1.service;

import ironyang.security1.domain.User;
import ironyang.security1.repository.UserRepository;
import ironyang.security1.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDto join(UserDto userDto) {
        return UserDto.of(userRepository.save(userDto.toEntity()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("[UserService.UserDetailsService.loadUserByUsername] username = {}", username);
        return null;
    }
}
