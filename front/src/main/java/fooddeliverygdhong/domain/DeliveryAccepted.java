package fooddeliverygdhong.domain;

import fooddeliverygdhong.domain.*;
import fooddeliverygdhong.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryAccepted extends AbstractEvent {

    private Long id;
    private String orderid;
    private String address;
    private String status;
    private String customerid;
}
