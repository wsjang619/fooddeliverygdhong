package fooddeliverygdhong.domain;

import fooddeliverygdhong.domain.*;
import fooddeliverygdhong.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryAccepted extends AbstractEvent {

    private Long id;
    private String orderid;
    private String address;
    private String status;
    private String customerid;

    public DeliveryAccepted(Rider aggregate) {
        super(aggregate);
    }

    public DeliveryAccepted() {
        super();
    }
}
//>>> DDD / Domain Event
