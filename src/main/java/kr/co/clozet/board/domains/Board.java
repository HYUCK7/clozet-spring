package kr.co.clozet.board.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Component
@Table(name="boards")
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue
    private long boardid;
    @Column private @NotNull
    String boardName;
    @Column(name = "created_date") @NotNull private String createdDate;

    @OneToMany(mappedBy = "board")
    List<Article> articles = new ArrayList<>();
}
