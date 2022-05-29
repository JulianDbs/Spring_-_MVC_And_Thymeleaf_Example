package com.juliandbs.springmvcthymeleafexample.repositories;

import com.juliandbs.springmvcthymeleafexample.objects.Article;
import com.juliandbs.springmvcthymeleafexample.exceptions.ArticleNotValidException;
import java.util.List;
import java.lang.NullPointerException;

/**
*	@author JulianDbs
*/
public interface BaseRepository {

	public List<Article> findAll();

	public Article findArticleByName(String articleName);

	public Article findArticleByLink(String articleLink);

	public List<Article> findLastTreeArticles();

	public void save(Article article) throws NullPointerException, ArticleNotValidException;

	public void deleteAll();
}
