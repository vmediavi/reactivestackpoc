package iiot.poc.reactivestack.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "public", name = "film_actor")
public class FilmActor {
    @Id
    private Long actorId;
    private Long filmId;
    private java.time.LocalDateTime lastUpdate;
}

