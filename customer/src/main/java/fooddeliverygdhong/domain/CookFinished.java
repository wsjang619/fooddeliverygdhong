package fooddeliverygdhong.domain;

import fooddeliverygdhong.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CookFinished extends AbstractEvent {

    private Long id;
    private String foodid;
    private String options;
    private String status;
    private String orderid;
    private String address;
    private String customerid;
}
