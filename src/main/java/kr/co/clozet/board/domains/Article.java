package kr.co.clozet.board.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Component
@Table(name = "articles")
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false) private String project;
    @Column(nullable = false) private String date;
    @Column(nullable = false) private String status;
    @Column(nullable = false) private String team;
    @Column(nullable = false) private String progress;
    @Column(nullable = false) private String action;
}
