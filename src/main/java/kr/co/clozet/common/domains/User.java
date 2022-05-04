package kr.co.clozet.common.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Component
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false) private String userId;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private String password;
    @Column(nullable = false) private String email;
    private String phone;
    private String birth;
    private String address;
}
