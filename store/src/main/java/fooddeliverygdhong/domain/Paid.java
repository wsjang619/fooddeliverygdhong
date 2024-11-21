package fooddeliverygdhong.domain;

import fooddeliverygdhong.domain.*;
import fooddeliverygdhong.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private String price;
    private String orderid;
    private String status;
}
