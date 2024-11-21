package fooddeliverygdhong.domain;

import fooddeliverygdhong.domain.*;
import fooddeliverygdhong.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private String id;
    private String foodid;
    private String options;
    private String price;
    private String status;
    private String address;
    private String customerid;
    private String storeid;
}
