package com.juliandbs.springmvcthymeleafexample.controllers;

import com.juliandbs.springmvcthymeleafexample.services.ArticleService;
import com.juliandbs.springmvcthymeleafexample.objects.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;

/**
*	@author JulianDbs
*/
@Controller
public class MainController {

	@Autowired
	private ArticleService articleService;

	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("articleResumes", articleService.getLastTreeArticles());
		return "home/home";
	}

	@GetMapping("/articles")
	public String getArticles(Model model) {
		model.addAttribute("articleResumes", articleService.getAllArticles());
		return "articles/articles";
	}

	@GetMapping("/article/**")
	public String getArticle(HttpServletRequest request, Model model) {
		String url = "article/article";
		String articleLink = request.getServletPath();
		System.out.println("servlet path : (" + articleLink + ")");
		if (articleLink.length() > 0) {
			Article article = articleService.getArticleByLink(articleLink.substring(1));
			model.addAttribute("article", article);
			if (article.isEmpty())
				url = "errors/error-404";
		} else {
			url = "errors/error-404";
		}
		return url;
	}
}
