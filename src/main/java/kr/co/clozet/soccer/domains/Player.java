package kr.co.clozet.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Component
@Table(name = "players")
public class Player {
    @Id
    private String playerId ;
    private String playerName ;
    private String teamId ;
    private String ePlayerName ;
    private String nickname ;
    private String joinYyyy ;
    private String position ;
    private String backNo ;
    private String nation ;
    private String birthDate ;
    private String solar ;
    private String height ;
    private String weight ;
}
