package kr.co.clozet.board.services;

import kr.co.clozet.board.domains.Article;
import kr.co.clozet.board.domains.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BoardService {
    List<Board> findAll();

    List<Board> findAll(Sort sort);

    Page<Board> findAll(Pageable pageable);

    long count();

    String save(Board board);

    String delete(Board board);
}
