package com.devx.ai;

public record BookRecommendation(
		 String title,
	        String author,
	        int publicationYear,
	        String genre,
	        int pageCount,
	        String summary) {

}
