package kr.co.clozet.security.domains;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter @Builder
public class Messenger {
    private String message, code;
    private int status;
}
