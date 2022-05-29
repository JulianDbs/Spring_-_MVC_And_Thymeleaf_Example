package com.juliandbs.springmvcthymeleafexample.objects;

import com.juliandbs.springmvcthymeleafexample.objects.Article;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.NullPointerException;
import java.util.Arrays;
import java.time.LocalDate;

/**
*	@author JulianDbs
*/
@Tag("unitary")
@DisplayName("Article Test")
public class ArticleTest {

	@Nested
	@DisplayName("Empty Constructor Test")
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class EmptyConstructorTest {

		@Test
		@Order(1)
		@DisplayName("Not Null Instance Test")
		public void emptyConstructorNotNullInstanceTest() {
			assertNotNull(new Article());
		}

		@Test
		@Order(2)
		@DisplayName("NUll / Not Null Properties Test")
		public void emptyConstructorNullNotNullPropertiesTest() {
			Article classUnderTest = new Article();
			assertAll(
				() -> assertNotNull(classUnderTest.getName()),
				() -> assertNull(classUnderTest.getImageLinks()),
				() -> assertNotNull(classUnderTest.getAuthor()),
				() -> assertNull(classUnderTest.getDate()),
				() -> assertNotNull(classUnderTest.getLink()),
				() -> assertNotNull(classUnderTest.getDescription()),
				() -> assertNull(classUnderTest.getParagraphs())
			);
		}

		@Test
		@Order(3)
		@DisplayName("isEmpty() Method Test")
		public void isEmptyMethodTest() {
			Article classUnderTest = new Article();
			assertTrue(classUnderTest.isEmpty());
		}
	}

	@Nested
	@DisplayName("Constructor With Parameters Test")
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class ConstructorWithParametersTest {

		@Test
		@Order(1)
		@DisplayName("Thorws Exactly NullPointerException Test")
		public void constructorWithParametersThrowsExactlyNullPointerExceptionTest() {
			assertThrowsExactly(NullPointerException.class, () -> {
				Article classUnderTest = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        null,
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest")
                        		);
			});
		}

		@Test
		@Order(2)
		@DisplayName("Does Not Throw Test")
		public void constructorWithPropertiesDoesNotThrowExceptionTest() {
			assertDoesNotThrow(
				() -> { Article classUnderTest = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest")
                        		);
				}
			);
		}

		@Test
		@Order(3)
		@DisplayName("Not Null Properties Test")
		public void constructorWithParametersNotNullParametersTest() {
			Article classUnderTest = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest")
                        );
			assertAll(
				() -> assertNotNull(classUnderTest.getName()),
				() -> assertNotNull(classUnderTest.getImageLinks()),
				() -> assertNotNull(classUnderTest.getAuthor()),
				() -> assertNotNull(classUnderTest.getDate()),
				() -> assertNotNull(classUnderTest.getLink()),
				() -> assertNotNull(classUnderTest.getDescription()),
				() -> assertNotNull(classUnderTest.getParagraphs())
			);
		}

		@Test
		@Order(4)
		@DisplayName("Equals Test")
		public void constructorWithPropertiesEqualsTest() {
			LocalDate dateToTest = LocalDate.now();
			Article classUnderTest = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        dateToTest,
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));
			assertAll(
				() -> assertEquals("Article 1", classUnderTest.getName()),
				() -> assertEquals(
                                 	Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
					classUnderTest.getImageLinks()
				),
				() -> assertEquals("bob", classUnderTest.getAuthor()),
				() -> assertEquals(dateToTest, classUnderTest.getDate()),
				() -> assertEquals("article/Article_1", classUnderTest.getLink()),
				() -> assertEquals("Article Description", classUnderTest.getDescription()),
				() -> assertEquals(Arrays.asList("testtest", "testtest"), classUnderTest.getParagraphs())
			);
		}

		@Test
		@Order(5)
		@DisplayName("isEmpty() Method Test")
		public void constructorWithParametersIsEmptyMethodTest() {
			Article classUnderTest = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));
			assertFalse(classUnderTest.isEmpty());
		}

		@Test
		@Order(6)
		@DisplayName("equals() Method Test")
		public void constructorWithParametersEqualsTest() {
			Article classUnderTestA = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));
			Article classUnderTestB = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));
			Article classUnderTestC = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "arthur",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));

			assertTrue(classUnderTestA.equals(classUnderTestB));
			assertFalse(classUnderTestA.equals(classUnderTestC));
		}

		@Test
		@Order(7)
		@DisplayName("compareTo() Method Test")
		public void constructorWithParametersCompareToMethodTest() {
			Article classUnderTestA = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));
			Article classUnderTestB = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));
			Article classUnderTestC = new Article(
	                                        "Article 2",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        LocalDate.now(),
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));
			assertEquals(0, classUnderTestA.compareTo(classUnderTestB));
			assertEquals(1, classUnderTestA.compareTo(classUnderTestC));
			assertEquals(-1, classUnderTestC.compareTo(classUnderTestA));
		}

		@Test
		@Order(8)
		@DisplayName("hashCode() Method Test")
		public void constructorWithParametersHashCodeMethodTest() {
			LocalDate localDate = LocalDate.now();
			int hashCodeToTest = 2075572783;
			hashCodeToTest = hashCodeToTest + localDate.hashCode();
			Article classUnderTest = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        localDate,
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));
			assertEquals(hashCodeToTest, classUnderTest.hashCode());
		}

		@Test
		@Order(9)
		@DisplayName("toString() Method Test")
		public void constructorWithParametersToStringMethodTest() {
			LocalDate localDate = LocalDate.now();
			Article classUnderTest = new Article(
	                                        "Article 1",
	                                         Arrays.asList("images/pexels-francesco-ungaro-396549.jpg", "images/pexels-marlene-leppänen-1031586.jpg"),
	                                        "bob",
	                                        localDate,
	                                        "article/Article_1",
	                                        "Article Description",
	                                        Arrays.asList("testtest", "testtest"));
			assertEquals(
				"Article 1 [images/pexels-francesco-ungaro-396549.jpg, images/pexels-marlene-leppänen-1031586.jpg] bob " + localDate.toString() + " article/Article_1 Article Description [testtest, testtest]",
				classUnderTest.toString()
			);
		}
	}
}
