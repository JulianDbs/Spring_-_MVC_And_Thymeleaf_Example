package com.juliandbs.springmvcthymeleafexample.services;

import com.juliandbs.springmvcthymeleafexample.objects.Article;
import java.util.List;

/**
*	@author JulianDbs
*/
public interface BaseService {

	public List<Article> getAllArticles();

	public List<Article> getLastTreeArticles();

	public Article getArticleByLink(String articleLink);
}
