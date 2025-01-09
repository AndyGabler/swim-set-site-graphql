package io.github.andygabler.swimsetgraphql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SwimSet")
@Data
public class SwimSet {

    @Id
    private String id;

    private int repLength;

    private int repCount;

    private String name;

    private String description;

    private String[] labels;
}
