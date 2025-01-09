package io.github.andygabler.swimsetgraphql.graphql;

import io.github.andygabler.swimsetgraphql.model.SwimSet;
import io.github.andygabler.swimsetgraphql.repository.SwimSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class SwimSetGraphController {

    @Autowired
    SwimSetRepository swimSetRepository;

    @QueryMapping
    public Iterable<SwimSet> swimSets() {
        return swimSetRepository.findAll();
    }

    @QueryMapping
    public Optional<SwimSet> swimSetById(@Argument String id) {
        return swimSetRepository.findById(id);
    }

    @QueryMapping
    SwimSet swimSetByName(@Argument String name) {
        return swimSetRepository.findByName(name);
    }
}
