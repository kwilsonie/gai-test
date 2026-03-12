package com.devx.ai;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	private final ChatClient chatClient;
	
	public BookController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	@GetMapping("/")	
	public List<BookRecommendation>  home () {
        return chatClient
                .prompt()
                .user("""
Generate 5 book recommendations about AI and coding.

Return them as a JSON array.

Each item must contain:
- title
- author
- publicationYear
- genre
- pageCount
- summary (max 100 words)
""")
                .call()
                .entity(new ParameterizedTypeReference<List<BookRecommendation>>() {});
	}

	
	@GetMapping("/old")	
	public String homeOld () {
        return chatClient
                .prompt()
                .user("Generate a book recommendation for a book on AI and coding")
                .call()
                .content();
	}
}
