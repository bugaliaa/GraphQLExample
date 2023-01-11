package com.example.graphqlexample.resolver;

import com.example.graphqlexample.domain.Author;
import com.example.graphqlexample.domain.Tutorial;
import com.example.graphqlexample.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class TutorialResolver implements GraphQLResolver<Tutorial> {

    @NonNull
    private final AuthorRepository authorRepository;

    public Author getAuthor(Tutorial tutorial) {
        return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
    }
}
