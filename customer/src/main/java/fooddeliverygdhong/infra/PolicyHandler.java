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

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderInfoAdded'"
    )
    public void wheneverOrderInfoAdded_SendKakaoMessageToManager(
        @Payload OrderInfoAdded orderInfoAdded
    ) {
        OrderInfoAdded event = orderInfoAdded;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToManager : " +
            orderInfoAdded +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StatusUpdated'"
    )
    public void wheneverStatusUpdated_SendKakaoMessageToManager(
        @Payload StatusUpdated statusUpdated
    ) {
        StatusUpdated event = statusUpdated;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToManager : " +
            statusUpdated +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookInfoAdded'"
    )
    public void wheneverCookInfoAdded_SendKakaoMessageToManager(
        @Payload CookInfoAdded cookInfoAdded
    ) {
        CookInfoAdded event = cookInfoAdded;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToManager : " +
            cookInfoAdded +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_SendKakaoMessageToCustomer(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            deliveryStarted +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_SendKakaoMessageToCustomer(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            orderPlaced +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Accepted'"
    )
    public void wheneverAccepted_SendKakaoMessageToCustomer(
        @Payload Accepted accepted
    ) {
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            accepted +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Rejected'"
    )
    public void wheneverRejected_SendKakaoMessageToCustomer(
        @Payload Rejected rejected
    ) {
        Rejected event = rejected;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            rejected +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_SendKakaoMessageToCustomer(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            cookStarted +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookCancelled'"
    )
    public void wheneverCookCancelled_SendKakaoMessageToCustomer(
        @Payload CookCancelled cookCancelled
    ) {
        CookCancelled event = cookCancelled;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            cookCancelled +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
