package by.lobanov.example.model.nodes;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
@Data
public class Publication {

    @Id @GeneratedValue private Long id;
    private String title;
    private String journal;
    private int year;

    @Relationship(type = "AUTHORED_BY")
    private List<Scientist> authors;

    @Relationship(type = "CITES")
    private List<Publication> citations;

    @Relationship(type = "FOUNDED_BY")
    private Grant grant;

    @Relationship(type = "PRESENTED_AT")
    private Conference conference;

    @Relationship(type = "RELATED_TO")
    private ResearchArea researchArea;
}
