package fooddeliverygdhong.domain;

import fooddeliverygdhong.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Paid extends AbstractEvent {

    private Long id;
    private String price;
    private String orderid;
    private String status;
}
