package fooddeliverygdhong.infra;

import fooddeliverygdhong.config.kafka.KafkaProcessor;
import fooddeliverygdhong.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setFoodid(orderPlaced.getFoodid());
            dashboard.setOptions(orderPlaced.getOptions());
            dashboard.setPrice(orderPlaced.getPrice());
            dashboard.setCustomerid(orderPlaced.getCustomerid());
            dashboard.setStoreid(orderPlaced.getStoreid());
            dashboard.setOrderid(orderPlaced.getId());
            dashboard.setStatus(주문);
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                paid.getOrderid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(결제완료);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_2(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                accepted.getOrderid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(주문수락);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_3(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                rejected.getOrderid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(주문거절);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_4(
        @Payload CookStarted cookStarted
    ) {
        try {
            if (!cookStarted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                cookStarted.getOrderid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(요리시작);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_5(
        @Payload CookFinished cookFinished
    ) {
        try {
            if (!cookFinished.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                cookFinished.getOrderid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(요리완료);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_6(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                deliveryStarted.getOrderid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(배송시작);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryAccepted_then_UPDATE_7(
        @Payload DeliveryAccepted deliveryAccepted
    ) {
        try {
            if (!deliveryAccepted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                deliveryAccepted.getOrderid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(배송접수);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_8(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        try {
            if (!deliveryCompleted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                deliveryCompleted.getOrderid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(배송완료);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
