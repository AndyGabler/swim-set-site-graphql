package io.github.andygabler.swimsetgraphql.restservice;

import io.github.andygabler.swimsetgraphql.model.SwimSet;
import io.github.andygabler.swimsetgraphql.repository.SwimSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultSwimSetService implements SwimSetService {

    @Autowired
    SwimSetRepository swimSetRepository;

    @Override
    public List<SwimSet> getSwimSet(String name, String id) {
        List<SwimSet> sets = Collections.emptyList();
        SwimSet singletonResult = null;

        if (name != null && id != null) {
            throw new IllegalArgumentException("Cannot search by both name and id.");
        } else if (name != null) {
            singletonResult = swimSetRepository.findByName(name);
        } else if (id != null) {
            singletonResult = swimSetRepository.findById(id).orElse(null);
        } else {
            sets = swimSetRepository.findAll();
        }

        if (singletonResult != null) {
            sets = Collections.singletonList(singletonResult);
        }

        return sets;
    }
}
