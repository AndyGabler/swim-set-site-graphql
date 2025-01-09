package io.github.andygabler.swimsetgraphql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ScheduledSet")
@Data
public class ScheduledSet {

    @Id
    private String id;

    private String dateScheduled;

    private int order;

    private SwimSet scheduledSet;
}
