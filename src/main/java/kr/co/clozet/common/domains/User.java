package kr.co.clozet.common.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private String userId;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String birth;
    private String address;
}
