package kr.co.clozet.board.controllers;

import kr.co.clozet.auth.domains.User;
import kr.co.clozet.board.domains.Article;
import kr.co.clozet.board.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService service;
    @GetMapping("/findAll")
    public List<Article> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Article> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Article> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Article article) {
        return service.delete(article);
    }

    @PostMapping("/join")
    public String save(@RequestBody Article article) {
        return service.save(article);
    }

    @GetMapping("/findById/{articleId}")
    public Optional<Article> findById(@PathVariable String articleId) {
        return service.findById(articleId);
    }

    @GetMapping("/existsById/{articleId}")
    public boolean existsById(@PathVariable String articleId) {
        return service.existsById(articleId);
    }
}
