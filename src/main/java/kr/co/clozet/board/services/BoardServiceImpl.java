package kr.co.clozet.board.services;

import kr.co.clozet.board.domains.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    @Override
    public List<Board> findAll() {
        return null;
    }

    @Override
    public List<Board> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Board> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public String save(Board board) {
        return null;
    }

    @Override
    public String delete(Board board) {
        return null;
    }
}
