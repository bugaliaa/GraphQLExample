package com.example.graphqlexample.resolver;

import com.example.graphqlexample.domain.Author;
import com.example.graphqlexample.domain.Tutorial;
import com.example.graphqlexample.repository.AuthorRepository;
import com.example.graphqlexample.repository.TutorialRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class Query implements GraphQLQueryResolver {
    @NonNull
    private final AuthorRepository authorRepository;

    @NonNull
    private final TutorialRepository tutorialRepository;

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    public String countAuthors() {
        return String.valueOf(authorRepository.count());
    }

    public String countTutorials() {
        return String.valueOf(tutorialRepository.count());
    }
}
