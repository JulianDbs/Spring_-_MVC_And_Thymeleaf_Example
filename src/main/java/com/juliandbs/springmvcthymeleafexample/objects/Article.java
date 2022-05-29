package com.juliandbs.springmvcthymeleafexample.objects;

import java.lang.NullPointerException;
import java.lang.Comparable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.LinkedList;

/**
*	@author JulianDbs
*/
public class Article implements Comparable<Article>, Serializable {

	private final String name;

	private final List<String> imageLinks;

	private final String author;

	private final LocalDate date;

	private final String link;

	private final String description;

	private final List<String> paragraphs;

	public Article() {
		name = "none";
		imageLinks = null;
		author = "none";
		date = null;
		link = "none";
		description = "none";
		paragraphs = null;
	}

	public Article(String name,
				List<String> imageLinks,
				String author,
				LocalDate date,
				String link,
				String description,
				List<String> paragraphs
	) throws NullPointerException {
		if (name == null || imageLinks == null || author == null || date == null || link == null || description == null || paragraphs == null)
			throw new NullPointerException("Null Constructor Parameter/s");
		this.name = name;
		this.imageLinks = imageLinks;
		this.author = author;
		this.date = date;
		this.link = link;
		this.description = description;
		this.paragraphs = paragraphs;
	}

	public boolean isEmpty() {
		return name.equals("none") &&
			imageLinks == null &&
			author.equals("none") &&
			date == null &&
			link.equals("none") &&
			description.equals("none") &&
			paragraphs == null;
	}

	public String getName() {return name;}

	public List<String> getImageLinks() {return imageLinks;}

	public String getAuthor() {return author;}

	public LocalDate getDate() {return date;}

	public String getLink() {return link;}

	public String getDescription() {return description;}

	public List<String> getParagraphs() {return paragraphs;}

	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if (object instanceof Article) {
			Article article = (Article) object;
			result = article.getName().equals(name) &&
				article.getImageLinks().equals(imageLinks) &&
				article.getAuthor().equals(author) &&
				article.getDate().equals(date) &&
				article.getLink().equals(link) &&
				article.getDescription().equals(description) &&
				article.getParagraphs().equals(paragraphs);
		}
		return result;
	}

	@Override
	public int compareTo(Article article) {
		return article.getName().compareTo(name) +
			article.getAuthor().compareTo(author) +
			article.getDate().compareTo(date) +
			article.getLink().compareTo(link) +
			article.getDescription().compareTo(description);
	}

	@Override
	public int hashCode() {
		return name.hashCode() +
			imageLinks.hashCode() +
			author.hashCode() +
			date.hashCode() +
			link.hashCode() +
			description.hashCode() +
			paragraphs.hashCode();
	}

	@Override
	public String toString() {
		return name + " " +
			imageLinks.toString() + " " +
			author + " " +
			date.toString() + " " +
			link + " " +
			description + " " +
			paragraphs.toString();
	}
}
