package kr.co.clozet.board.services;

import kr.co.clozet.board.domains.Article12;
import kr.co.clozet.board.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;

    @Override
    public List<Article12> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article12> findAll(Sort sort) {
        return articleRepository.findAll(sort);
    }

    @Override
    public Page<Article12> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public long count() {
        return articleRepository.count();
    }

    @Override
    public String save(Article12 article) {
        articleRepository.save(article);
        return "";
    }

    @Override
    public String delete(Article12 article) {
        articleRepository.delete(article);
        return "";
    }
}
