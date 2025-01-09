package io.github.andygabler.swimsetgraphql.restservice;

import io.github.andygabler.swimsetgraphql.model.ScheduledSet;
import io.github.andygabler.swimsetgraphql.model.SwimSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultScheduledSetService implements ScheduledSetService {

    @Autowired
    SwimSetService swimSetService;

    @Autowired
    ScheduledSetRepository scheduledSetRepository;

    @Override
    public List<ScheduledSet> getScheduledSets(String swimSetName, String swimSetId, String scheduledDate) {
        SwimSet swimSet = null;

        if (swimSetName != null || swimSetId != null) {
            swimSet = swimSetService.getSwimSet(swimSetName, swimSetId)
                .stream()
                .findFirst()
                .orElse(null);
            if (swimSet == null) {
                return Collections.emptyList();
            }
        }

        List<ScheduledSet> results;
        if (swimSet != null && scheduledDate != null) {
            results = scheduledSetRepository.findByDateScheduledAndScheduledSetOrderByOrder(
                scheduledDate,
                swimSet
            );
        } else if (scheduledDate != null) {
            results = scheduledSetRepository.findByDateScheduledOrderByOrder(scheduledDate);
        } else if (swimSet != null) {
            results = scheduledSetRepository.findByScheduledSetOrderByDateScheduled(swimSet);
        } else {
            results = scheduledSetRepository.findAll();
        }

        return results;
    }
}
