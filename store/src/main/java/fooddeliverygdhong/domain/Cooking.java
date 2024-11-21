package fooddeliverygdhong.domain;

import fooddeliverygdhong.domain.OrderInfoAdded;
import fooddeliverygdhong.domain.StatusUpdated;
import fooddeliverygdhong.domain.CookCancelled;
import fooddeliverygdhong.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Cooking_table")
@Data

//<<< DDD / Aggregate Root
public class Cooking  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String foodid;
    
    
    
    
    private String options;
    
    
    
    
    private String status;
    
    
    
    
    private String orderid;
    
    
    
    
    private String address;
    
    
    
    
    private String customerid;

    @PostPersist
    public void onPostPersist(){


        OrderInfoAdded orderInfoAdded = new OrderInfoAdded(this);
        orderInfoAdded.publishAfterCommit();



        StatusUpdated statusUpdated = new StatusUpdated(this);
        statusUpdated.publishAfterCommit();



        CookCancelled cookCancelled = new CookCancelled(this);
        cookCancelled.publishAfterCommit();

    
    }

    public static CookingRepository repository(){
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(CookingRepository.class);
        return cookingRepository;
    }



//<<< Clean Arch / Port Method
    public void accept(AcceptCommand acceptCommand){
        
        //implement business logic here:
        

        fooddeliverygdhong.external.CookingQuery cookingQuery = new fooddeliverygdhong.external.CookingQuery();
        // cookingQuery.set??()        
          = CookingApplication.applicationContext
            .getBean(fooddeliverygdhong.external.Service.class)
            .cooking(cookingQuery);

        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void reject(RejectCommand rejectCommand){
        
        //implement business logic here:
        

        fooddeliverygdhong.external.CookingQuery cookingQuery = new fooddeliverygdhong.external.CookingQuery();
        // cookingQuery.set??()        
          = CookingApplication.applicationContext
            .getBean(fooddeliverygdhong.external.Service.class)
            .cooking(cookingQuery);

        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void cookStart(CookStartCommand cookStartCommand){
        
        //implement business logic here:
        


        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void cookFinish(CookFinishCommand cookFinishCommand){
        
        //implement business logic here:
        


        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }
//>>> Clean Arch / Port Method

//<<< Clean Arch / Port Method
    public static void addOrderInfo(OrderPlaced orderPlaced){
        
        //implement business logic here:

        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        OrderInfoAdded orderInfoAdded = new OrderInfoAdded(cooking);
        orderInfoAdded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            OrderInfoAdded orderInfoAdded = new OrderInfoAdded(cooking);
            orderInfoAdded.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void updatePayStatus(Paid paid){
        
        //implement business logic here:

        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        StatusUpdated statusUpdated = new StatusUpdated(cooking);
        statusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            StatusUpdated statusUpdated = new StatusUpdated(cooking);
            statusUpdated.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void cancelOrder(OrderCancelled orderCancelled){
        
        //implement business logic here:

        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        CookCancelled cookCancelled = new CookCancelled(cooking);
        cookCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            CookCancelled cookCancelled = new CookCancelled(cooking);
            cookCancelled.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
