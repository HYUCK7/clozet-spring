package kr.co.clozet.auth.domains;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Messenger {
    private String message, code, token;

}
