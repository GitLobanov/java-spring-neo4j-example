package by.lobanov.example.model.nodes;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class ResearchArea {

    @Id @GeneratedValue private Long id;
    private String name;
    private String description;
}
