package iiot.poc.reactivestack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@Table(schema = "public", name = "inventory")
public class Inventory implements Serializable {
    @Id
    private Long inventoryId;
    private Long filmId;
    private Long storeId;
    private java.time.LocalDateTime lastUpdate;
}
