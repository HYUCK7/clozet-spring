package kr.co.clozet.board.services;

import kr.co.clozet.board.domains.Article12;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService{
    List<Article12> findAll();

    List<Article12> findAll(Sort sort);

    Page<Article12> findAll(Pageable pageable);



    long count();

    String save(Article12 article);

    String delete(Article12 article);
}
