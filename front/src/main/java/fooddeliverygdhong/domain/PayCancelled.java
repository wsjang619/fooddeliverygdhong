package fooddeliverygdhong.domain;

import fooddeliverygdhong.domain.*;
import fooddeliverygdhong.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PayCancelled extends AbstractEvent {

    private Long id;
    private String price;
    private String orderid;
    private String status;

    public PayCancelled(Payment aggregate) {
        super(aggregate);
    }

    public PayCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
