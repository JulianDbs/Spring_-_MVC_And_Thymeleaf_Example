package com.juliandbs.springmvcthymeleafexample.repositories;

import com.juliandbs.springmvcthymeleafexample.repositories.BaseRepository;
import com.juliandbs.springmvcthymeleafexample.objects.Article;
import com.juliandbs.springmvcthymeleafexample.exceptions.ArticleNotValidException;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.lang.NullPointerException;

/**
*	@author JulianDbs
*/
@Repository
public class ArticleRepository implements BaseRepository {

	private static List<Article> articleList = buildList();

        private static List<Article> buildList() {
                List<Article> list = new LinkedList<>();
                list.add( new Article(
					"Article 1",
					 Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
					"Bob",
					LocalDate.now(),
					"article/Article_1",
					"Article Description",
					Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
			)
		);
                list.add( new Article(
					"Article 2",
					 Arrays.asList("images/pexels-lumn-167698.jpg", "images/pexels-veeterzy-38136.jpg"),
					"Bob",
					LocalDate.now(),
					"article/Article_2",
					"Article Description",
					Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
			)
		);
                list.add( new Article(
					"Article 3",
					 Arrays.asList("images/pexels-pavlo-luchkovski-337909.jpg", "images/pexels-pixabay-164634.jpg"),
					"Bob",
					LocalDate.now(),
					"article/Article_3",
					"Article Description",
					Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
			)
		);
                list.add( new Article(
					"Article 4",
					 Arrays.asList("images/pexels-alex-azabache-3264722.jpg", "images/pexels-walid-ahmad-847402.jpg"),
					"Bob",
					LocalDate.now(),
					"article/Article_4",
					"Article Description",
					Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
			)
		);
                return list;
        }

	@Override
        public Article findArticleByName(String articleName) {
                return articleList.stream()
                                        .filter( (e) -> e.getName().equals(articleName))
                                        .findAny()
                                        .orElse(new Article());
        }

	@Override
	public Article findArticleByLink(String articleLink) {
		return articleList.stream()
					.filter( (e) -> e.getLink().equals(articleLink) )
					.findAny()
					.orElse(new Article());
	}

	@Override
        public List<Article> findAll() {
		List<Article> result = new LinkedList<>(articleList);
		Collections.reverse(result);
		return result;
	}

	@Override
	public List<Article> findLastTreeArticles() {
		List<Article> result = new LinkedList<>(articleList);
		Collections.reverse(result);
		return result.stream()
				.sorted( (a1, a2) -> a1.getDate().compareTo(a2.getDate()))
				.limit(3)
				.collect(Collectors.toCollection(LinkedList :: new));
	}

	@Override
	public void save(Article article) throws NullPointerException, ArticleNotValidException {
		if (article == null)
			throw new NullPointerException();
		if (article.isEmpty())
			throw new ArticleNotValidException();
		articleList.add(article);
	}

	@Override
	public void deleteAll() {
		articleList.clear();
	}
}
