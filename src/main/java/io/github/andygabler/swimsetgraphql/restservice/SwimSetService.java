package io.github.andygabler.swimsetgraphql.restservice;

import io.github.andygabler.swimsetgraphql.model.SwimSet;

import java.util.List;

public interface SwimSetService {

    List<SwimSet> getSwimSet(String name, String id);
}
