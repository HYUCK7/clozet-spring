package kr.co.clozet.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Component
@Table(name = "stadiums")
public class Stadium {
    @Id long stadiumId;
    private String stadiumName;
    private String homeTeamId;
    private String seatCount;
    private String address;
    private String ddd;
    private String tel;
}
