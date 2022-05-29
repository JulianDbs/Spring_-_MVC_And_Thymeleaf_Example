package com.juliandbs.springmvcthymeleafexample.repositories;

import com.juliandbs.springmvcthymeleafexample.repositories.ArticleRepository;
import com.juliandbs.springmvcthymeleafexample.objects.Article;
import com.juliandbs.springmvcthymeleafexample.exceptions.ArticleNotValidException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.time.LocalDate;
import java.lang.NullPointerException;

/**
*	@author JulianDbs
*/
@Tag("unitary")
@DisplayName("ArticleRepository Test")
public class ArticleRepositoryTest {

	private ArticleRepository articleRepository = new ArticleRepository();
	public Article classUnderTestA = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "Bob",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest")
	                                );
	public Article classUnderTestB = new Article(
	                                        "Article 2",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "Bob",
	                                        LocalDate.now(),
	                                        "article/Article_2",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest")
	                                );
	public Article classUnderTestC = new Article(
	                                        "Article 3",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "Bob",
	                                        LocalDate.now(),
	                                        "article/Article_3",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest")
	                                );


	@Nested
	@DisplayName("FindArticleByName() Method Test")
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	public class FindArticleByName {

		@BeforeAll
		public void setup() {
			articleRepository.deleteAll();
			try {
				articleRepository.save(classUnderTestA);
			} catch( NullPointerException | ArticleNotValidException e) {e.printStackTrace();}
		}

		@Test
		@Order(1)
		@DisplayName("Not Null Test")
		public void articleRepositoryFindArticleByNameNotNullTest() {
			assertNotNull(articleRepository.findArticleByName("Article 1"));
		}

		@Test
		@Order(2)
		@DisplayName("instanceOf Article Test")
		public void articlerepositoryFindArticleByNameInstsanceOfArticleTest() {
			assertInstanceOf(Article.class, articleRepository.findArticleByName("Article 1"));
		}

		@Test
		@Order(3)
		@DisplayName("isEmpty() Method Test")
		public void articleRepositoryFindArticleByNameIsEmptyTest() {
			assertFalse(articleRepository.findArticleByName("Article 1").isEmpty());
		}

		@Test
		@Order(4)
		@DisplayName("Equals Test")
		public void articleRepositoryFindArticleByNameEqualsTest() {
			assertEquals(classUnderTestA, articleRepository.findArticleByName("Article 1"));
		}
	}

	@Nested
	@DisplayName("FindArticleByLink() Method Test")
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	public class FindArticleByLink {

		@BeforeAll
		public void setup() {
			articleRepository.deleteAll();
			try {
				articleRepository.save(classUnderTestA);
			} catch( NullPointerException | ArticleNotValidException e) {e.printStackTrace();}
		}


		@Test
		@Order(1)
		@DisplayName("Not Null Test")
		public void articleRepositoryFindArticleByLinkNotNullTest() {
			assertNotNull(articleRepository.findArticleByLink("article/Article_1"));
		}

		@Test
		@Order(2)
		@DisplayName("instanceOf Article Test")
		public void articlerepositoryFindArticleByLinkInstsanceOfArticleTest() {
			assertInstanceOf(Article.class, articleRepository.findArticleByLink("article/Article_1"));
		}

		@Test
		@Order(3)
		@DisplayName("isEmpty() Method Test")
		public void articleRepositoryFindArticleByLinkIsEmptyTest() {
			assertFalse(articleRepository.findArticleByLink("article/Article_1").isEmpty());
		}

		@Test
		@Order(4)
		@DisplayName("Equals Test")
		public void articleRepositoryFindArticleByLinkEqualsTest() {
			assertEquals(classUnderTestA, articleRepository.findArticleByLink("article/Article_1"));
		}
	}

	@Nested
	@DisplayName("findAll() Method Test")
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class FindAllMethodTest {

		@BeforeAll
		public void setup() {
			try {
				articleRepository.deleteAll();
				articleRepository.save(classUnderTestA);
				articleRepository.save(classUnderTestB);
				articleRepository.save(classUnderTestC);
			}  catch (NullPointerException | ArticleNotValidException e) {e.printStackTrace();}
		}

		@AfterAll
		public void teardown() {
			articleRepository.deleteAll();
		}

		@Test
		@Order(1)
		@DisplayName("Not Null Test")
		public void articleRepositoryFindAllMethodNotNullTest() {
			assertNotNull(articleRepository.findAll());
		}

		@Test
		@Order(2)
		@DisplayName("Instance Of Test")
		public void articleRepositoryFindAllMethodsInstaceOfTest() {
			assertInstanceOf(List.class, articleRepository.findAll());
		}

		@Test
		@Order(3)
		@DisplayName("Equals Test")
		public void articleRepositoryFindAllMethodEqualsTest() {
			List<Article> listToTest = new LinkedList<Article>();
			listToTest.add(classUnderTestC);
			listToTest.add(classUnderTestB);
			listToTest.add(classUnderTestA);
			assertEquals(listToTest, articleRepository.findAll());
		}

		@Test
		@Order(4)
		@DisplayName("Iterable Equals Test")
		public void articleRepositoryFindAllMethodIterableEqualsTest() {
			List<Article> listToTest = new LinkedList<Article>();
			listToTest.add(classUnderTestC);
			listToTest.add(classUnderTestB);
			listToTest.add(classUnderTestA);
			assertIterableEquals(listToTest, articleRepository.findAll());
		}

	}

	@Nested
	@DisplayName("findLastTreeArticles() Method Test")
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	public class FindLastTreeArticles {

		@BeforeAll
		public void setup() {
			articleRepository.deleteAll();
			try {
				articleRepository.save(classUnderTestA);
				articleRepository.save(classUnderTestB);
				articleRepository.save(classUnderTestC);
			} catch (NullPointerException | ArticleNotValidException e) {e.printStackTrace();}
		}

		@Test
		@Order(1)
		@DisplayName("Not Null Test")
		public void articleRepositoryFindLastTreeArticlesMethodNotNullTest() {
			assertNotNull(articleRepository.findLastTreeArticles());
		}

		@Test
		@Order(2)
		@DisplayName("Instance Of Test")
		public void articleRepositoryFindLastTreeArticlesMethodInstanceOfTest() {
			assertInstanceOf(List.class, articleRepository.findLastTreeArticles());
		}

		@Test
		@Order(3)
		@DisplayName("Equals Test")
		public void articleRepositoryFindLastTreeArticlesMethodEqualsTest() {
			List<Article> listToCompare = new LinkedList<>();
			listToCompare.add(classUnderTestC);
			listToCompare.add(classUnderTestB);
			listToCompare.add(classUnderTestA);
			assertEquals(listToCompare, articleRepository.findLastTreeArticles());
		}

		@Test
		@Order(4)
		@DisplayName("Iterable Equals Test")
		public void articleRepositoryFindLastTreeArticlesMethodIterableEqualsTest() {
			List<Article> listToCompare = new LinkedList<>();
			listToCompare.add(classUnderTestC);
			listToCompare.add(classUnderTestB);
			listToCompare.add(classUnderTestA);
			assertIterableEquals(listToCompare, articleRepository.findLastTreeArticles());
		}
	}

	@Nested
	@DisplayName("save() Method Test")
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	public class SaveMethodTest {

		@BeforeAll
		public void setup() {
			articleRepository.deleteAll();
		}

		@AfterEach
		public void afterEach() {
			articleRepository.deleteAll();
		}

		@Test
		@Order(1)
		@DisplayName("Throws Exaclty NullPointerException Test")
		public void articleRepositorySaveMethodThrowsExactlyNullPointerExceptionTest() {
			assertThrowsExactly(NullPointerException.class, () -> {
				articleRepository.save(null);
			});
		}

		@Test
		@Order(2)
		@DisplayName("Thorws Exactly ArticleNotValidException Test")
		public void articleRepositorySaveMethodThrowsExactlyArticleNotValidExceptionTest() {
			assertThrowsExactly(ArticleNotValidException.class, () -> {
				articleRepository.save( new Article());
			});
		}

		@Test
		@Order(3)
		@DisplayName("Does Not Throw Test")
		public void articleRepositorySaveMethodDoesNotThrowTest() {
			assertDoesNotThrow( () -> { articleRepository.save(classUnderTestA); } );
		}

		@Test
		@Order(4)
		@DisplayName("Equals Test")
		public void articleRepositorySaveMethodEqualsTest() {
			try {
				articleRepository.save(classUnderTestA);
			} catch (NullPointerException | ArticleNotValidException e) {e.printStackTrace();}
			assertEquals(classUnderTestA, articleRepository.findArticleByName("Article 1"));
		}
	}

	@Nested
	@DisplayName("deleteAll() Method Test")
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	public class DeleteAllMethodTest {

		@BeforeAll
		public void setup() {
			articleRepository.deleteAll();
		}

		@Test
		@Order(1)
		@DisplayName("Not Null Test")
		public void articleRepositoryDeleteAllNotNull() {
			try {
				articleRepository.save(classUnderTestA);
			} catch (NullPointerException | ArticleNotValidException e) {e.printStackTrace();}
			articleRepository.deleteAll();
			assertNotNull(articleRepository.findAll());

		}

		@Test
		@Order(2)
		@DisplayName("Equals Test")
		public void articleRepositoryDeleteAllEquals() {
			try {
				articleRepository.save(classUnderTestA);
			} catch (NullPointerException | ArticleNotValidException e) {e.printStackTrace();}
			assertEquals(1, articleRepository.findAll().size());
			articleRepository.deleteAll();
			assertEquals(0, articleRepository.findAll().size());
		}
	}
}
