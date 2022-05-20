package kr.co.clozet.board.services;

import kr.co.clozet.board.domains.Article;
import kr.co.clozet.board.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> findAll(Sort sort) {
        return articleRepository.findAll(sort);
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public long count() {
        return articleRepository.count();
    }

    @Override
    public String save(Article article) {
        return null;
    }
    @Override
    public String delete(Article article) {
        return null;
    }

    @Override
    public Optional<Article> findById(String articleId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String articleId) {
        return false;
    }


}
