package kr.co.clozet.board.domains;

import com.sun.istack.NotNull;
import kr.co.clozet.user.domains.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Builder@AllArgsConstructor@NoArgsConstructor@Getter@Entity
@Component@Table(name="articles")
public class Article {
    @Id
    @Column(name = "article_id")
    @GeneratedValue
    private long articleId;
    @Column @NotNull
    private String title;
    @Column @NotNull private String content;
    @Column(name = "written_date") @NotNull private String writtenDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
