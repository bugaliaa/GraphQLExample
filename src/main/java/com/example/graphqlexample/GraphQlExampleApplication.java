package com.example.graphqlexample;

import graphql.Scalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class GraphQlExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlExampleApplication.class, args);
    }

//    @Bean
//    GraphQLSchema schema() {
//        return GraphQLSchema.newSchema()
//                            .query(GraphQLObjectType.newObject()
//                                                    .name("query")
//                                                    .field(field -> field
//                                                               .name("test")
//                                                               .type(Scalars.GraphQLString)
//                                                               .dataFetcher(environment -> "response")
//                                                          )
//                                                    .build())
//                            .build();
//    }
}
