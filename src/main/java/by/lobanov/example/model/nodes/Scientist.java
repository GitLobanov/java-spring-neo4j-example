package by.lobanov.example.model.nodes;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
@Data
@Builder
public class Scientist {

    @Id @GeneratedValue private Long id;
    private String name;
    private String organization;

    @Relationship(type = "AUTHORED_BY", direction = Relationship.Direction.INCOMING)
    private List<Publication> publications;

    @Relationship(type = "COLLABORATES_WITH")
    private List<Scientist> collaborators;
}
