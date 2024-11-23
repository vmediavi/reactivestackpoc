package iiot.poc.reactivestack.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@Table(schema = "public", name = "film_category")
public class FilmCategory implements Serializable {
    @Id
    private Long filmId;
    private Long categoryId;
    private java.time.LocalDateTime lastUpdate;
}

