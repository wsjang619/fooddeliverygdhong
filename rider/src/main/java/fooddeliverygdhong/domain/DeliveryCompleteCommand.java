package fooddeliverygdhong.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeliveryCompleteCommand {

    private String orderid;
}
