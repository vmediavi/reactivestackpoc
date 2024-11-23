package iiot.poc.reactivestack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "public", name = "inventory")
public class Inventory {
    @Id
    private Long inventoryId;
    private Long filmId;
    private Long storeId;
    private java.time.LocalDateTime lastUpdate;
}
