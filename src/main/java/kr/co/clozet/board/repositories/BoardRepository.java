package kr.co.clozet.board.repositories;

import kr.co.clozet.board.domains.Article;
import kr.co.clozet.board.domains.Board;
import org.springframework.data.jpa.repository.JpaRepository;


interface BoardCustomRepository{
    //000. 게시판 이름을 변경.
}

public interface BoardRepository extends JpaRepository<Board, Long> {
}
