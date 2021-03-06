package kr.co.clozet.board.repositories;

import kr.co.clozet.board.domains.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface ArticleCustomRepository{
    Article update(Article article);
}

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
