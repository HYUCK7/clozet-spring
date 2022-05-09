package kr.co.clozet.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Component
@Table(name = "schedules")
public class Schedule {
    @Id
    long teamId;
    private String stadiumId;
    private String date;
    private String gubun;
    private String homeTeamId;
    private String awayTeamId;
    private String homeScore;
    private String awayScore;

}
