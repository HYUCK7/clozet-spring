package kr.co.clozet.board.services;

import kr.co.clozet.auth.domains.User;
import kr.co.clozet.board.domains.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ArticleService{
    List<Article> findAll();

    List<Article> findAll(Sort sort);

    Page<Article> findAll(Pageable pageable);

    long count();

    String save(Article article);

    String delete(Article article);

    Optional<Article> findById(@PathVariable String articleId);

    boolean existsById(String articleId);
}
