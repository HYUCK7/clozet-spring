package kr.co.clozet.soccer.domains;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Component
@Table(name = "stadiums")
public class Stadium {
    @Id @Column(name = "stadium_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private long stadiumNo;
    @Column(nullable = false) private String stadiumId;
    private String stadiumName;
    private String hometeamId;
    private String seatCount;
    private String address;
    private String ddd;
    private String tel;

    @OneToMany(mappedBy = "stadium")
    List<Schedule> schedules = new ArrayList<>();
}
