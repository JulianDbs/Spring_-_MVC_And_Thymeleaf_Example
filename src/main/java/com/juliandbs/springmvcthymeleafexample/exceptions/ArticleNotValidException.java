package com.juliandbs.springmvcthymeleafexample.exceptions;

import java.lang.Exception;
import java.lang.Throwable;

/**
*	@author JulianDbs
*/
public class ArticleNotValidException extends Exception {

	private static final long serialVersionUID = 00000001;

	public ArticleNotValidException() {
		super("The Article instance given as method argument does not contains valid values");
	}

	public ArticleNotValidException(Throwable error) {
		super(error);
	}

	public ArticleNotValidException(String errorMessage) {
		super(errorMessage);
	}

	public ArticleNotValidException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}

}
