package io.github.andygabler.swimsetgraphql.restservice;

import io.github.andygabler.swimsetgraphql.model.SwimSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwimSetRepository extends MongoRepository<SwimSet, String> {

    SwimSet findByName(String name);
}
