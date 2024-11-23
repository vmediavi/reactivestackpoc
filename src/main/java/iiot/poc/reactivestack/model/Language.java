package iiot.poc.reactivestack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "public", name = "language")
public class Language {
    @Id
    private Long languageId;
    private String name;
    private java.time.LocalDateTime lastUpdate;
}

