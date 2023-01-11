package com.example.graphqlexample.resolver;

import java.util.Optional;

import com.example.graphqlexample.domain.Author;
import com.example.graphqlexample.domain.Tutorial;
import com.example.graphqlexample.repository.AuthorRepository;
import com.example.graphqlexample.repository.TutorialRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class Mutation implements GraphQLMutationResolver {

    @NonNull
    private final AuthorRepository authorRepository;

    @NonNull
    private final TutorialRepository tutorialRepository;

    public Author createAuthor(String name, Integer age) {
        Author author = Author.builder().name(name).age(age).build();
        return authorRepository.save(author);
    }

    public Tutorial createTutorial(String title, String description, Long authorId) {
        Tutorial tutorial = Tutorial.builder().title(title).description(description)
                                    .author(Author.builder().id(authorId).build()).build();
        return tutorialRepository.save(tutorial);
    }

    public boolean deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
        return true;
    }

    public Tutorial updateTutorial(Long id, String title, String description) throws NotFoundException {
        Optional<Tutorial> optionalTutorial = tutorialRepository.findById(id);

        if(optionalTutorial.isPresent()) {
            Tutorial tutorial = optionalTutorial.get();

            if(title != null) {
                tutorial.setTitle(title);
            }

            if(description != null) {
                tutorial.setDescription(description);
            }

            return tutorialRepository.save(tutorial);
        }

        throw new NotFoundException("Tutorial not found for the given ID");
    }
}
