package fooddeliverygdhong.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliverygdhong.config.kafka.KafkaProcessor;
import fooddeliverygdhong.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CookingRepository cookingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_AddOrderInfo(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener AddOrderInfo : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        Cooking.addOrderInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_UpdatePayStatus(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener UpdatePayStatus : " + paid + "\n\n"
        );

        // Sample Logic //
        Cooking.updatePayStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_CancelOrder(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener CancelOrder : " + orderCancelled + "\n\n"
        );

        // Sample Logic //
        Cooking.cancelOrder(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
