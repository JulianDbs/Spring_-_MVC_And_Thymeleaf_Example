package com.juliandbs.springmvcthymeleafexample.services;

import com.juliandbs.springmvcthymeleafexample.services.BaseService;
import com.juliandbs.springmvcthymeleafexample.objects.Article;
import com.juliandbs.springmvcthymeleafexample.repositories.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
*	@author JulianDbs
*/
@Service
public class ArticleService implements BaseService {

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public List<Article> getAllArticles() {return articleRepository.findAll();}

	@Override
	public List<Article> getLastTreeArticles() {return articleRepository.findLastTreeArticles();}

	@Override
	public Article getArticleByLink(String articleLink) {return articleRepository.findArticleByLink(articleLink);}
}
