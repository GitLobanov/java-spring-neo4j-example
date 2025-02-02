package by.lobanov.example.model.nodes;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDate;

@Node
@Data
public class Grant {

    @Id @GeneratedValue private Long id;
    private String title;
    private String sponsor;
    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;
}
