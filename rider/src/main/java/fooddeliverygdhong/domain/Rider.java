package fooddeliverygdhong.domain;

import fooddeliverygdhong.domain.CookInfoAdded;
import fooddeliverygdhong.RiderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Rider_table")
@Data

//<<< DDD / Aggregate Root
public class Rider  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String orderid;
    
    
    
    
    private String address;
    
    
    
    
    private String status;
    
    
    
    
    private String customerid;

    @PostPersist
    public void onPostPersist(){


        CookInfoAdded cookInfoAdded = new CookInfoAdded(this);
        cookInfoAdded.publishAfterCommit();

    
    }

    public static RiderRepository repository(){
        RiderRepository riderRepository = RiderApplication.applicationContext.getBean(RiderRepository.class);
        return riderRepository;
    }



//<<< Clean Arch / Port Method
    public void accept(AcceptCommand acceptCommand){
        
        //implement business logic here:
        


        DeliveryAccepted deliveryAccepted = new DeliveryAccepted(this);
        deliveryAccepted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void deliveryStart(DeliveryStartCommand deliveryStartCommand){
        
        //implement business logic here:
        

        fooddeliverygdhong.external.RiderQuery riderQuery = new fooddeliverygdhong.external.RiderQuery();
        // riderQuery.set??()        
          = RiderApplication.applicationContext
            .getBean(fooddeliverygdhong.external.Service.class)
            .rider(riderQuery);

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void deliveryComplete(DeliveryCompleteCommand deliveryCompleteCommand){
        
        //implement business logic here:
        


        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method

//<<< Clean Arch / Port Method
    public static void addCookInfo(CookStarted cookStarted){
        
        //implement business logic here:

        /** Example 1:  new item 
        Rider rider = new Rider();
        repository().save(rider);

        CookInfoAdded cookInfoAdded = new CookInfoAdded(rider);
        cookInfoAdded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(rider->{
            
            rider // do something
            repository().save(rider);

            CookInfoAdded cookInfoAdded = new CookInfoAdded(rider);
            cookInfoAdded.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
