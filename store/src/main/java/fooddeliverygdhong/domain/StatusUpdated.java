package fooddeliverygdhong.domain;

import fooddeliverygdhong.domain.*;
import fooddeliverygdhong.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StatusUpdated extends AbstractEvent {

    private Long id;
    private String foodid;
    private String options;
    private String status;
    private String orderid;
    private String address;
    private String customerid;

    public StatusUpdated(Cooking aggregate) {
        super(aggregate);
    }

    public StatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
