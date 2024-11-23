package iiot.poc.reactivestack.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "public", name = "film_category")
public class FilmCategory {
    @Id
    private Long filmId;
    private Long categoryId;
    private java.time.LocalDateTime lastUpdate;
}

