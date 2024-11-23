package iiot.poc.reactivestack.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "public", name = "film")
public class Film {
    @Id
    private Long filmId;
    private String title;
    private String description;
    private Integer releaseYear;
    private Long languageId;
    private Long originalLanguageId;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;
    private String specialFeatures;
    private String fulltext;
    private java.time.LocalDateTime lastUpdate;
}
