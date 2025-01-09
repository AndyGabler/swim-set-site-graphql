package io.github.andygabler.swimsetgraphql.repository;

import io.github.andygabler.swimsetgraphql.model.ScheduledSet;
import io.github.andygabler.swimsetgraphql.model.SwimSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduledSetRepository extends MongoRepository<ScheduledSet, Long> {

    List<ScheduledSet> findByScheduledSetOrderByDateScheduled(SwimSet scheduledSet);

    // TODO make a between date deal
    List<ScheduledSet> findByDateScheduledOrderByOrder(String scheduledDate);

    // TODO make a between date deal
    List<ScheduledSet> findByDateScheduledAndScheduledSetOrderByOrder(
        String scheduledDate,
        SwimSet scheduledSet
    );
}
