package fooddeliverygdhong.domain;

import fooddeliverygdhong.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeliveryAccepted extends AbstractEvent {

    private Long id;
    private String orderid;
    private String address;
    private String status;
    private String customerid;
}
