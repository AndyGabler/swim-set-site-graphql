package io.github.andygabler.swimsetgraphql.restservice;

import io.github.andygabler.swimsetgraphql.model.ScheduledSet;

import java.util.List;

public interface ScheduledSetService {

    List<ScheduledSet> getScheduledSets(
        String swimSetName,
        String swimSetId,
        String scheduledDate
    );
}
