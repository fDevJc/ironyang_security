package ironyang.security1.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    private Long id;
    private String email;
    private String password;
}
