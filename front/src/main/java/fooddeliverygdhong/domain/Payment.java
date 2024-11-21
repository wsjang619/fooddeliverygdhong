package fooddeliverygdhong.domain;

import fooddeliverygdhong.FrontApplication;
import fooddeliverygdhong.domain.PayCancelled;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String price;

    private String orderid;

    private String status;

    @PostPersist
    public void onPostPersist() {
        PayCancelled payCancelled = new PayCancelled(this);
        payCancelled.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = FrontApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    //<<< Clean Arch / Port Method
    public void payComplete(PayCompleteCommand payCompleteCommand) {
        //implement business logic here:

        Paid paid = new Paid(this);
        paid.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void payCancel(PayCancelCommand payCancelCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void pay(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void payReject(OrderCancelled orderCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
