package fooddeliverygdhong.infra;

import fooddeliverygdhong.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/riders")
@Transactional
public class RiderController {

    @Autowired
    RiderRepository riderRepository;

    @RequestMapping(
        value = "/riders/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Rider accept(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptCommand acceptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rider/accept  called #####");
        Optional<Rider> optionalRider = riderRepository.findById(id);

        optionalRider.orElseThrow(() -> new Exception("No Entity Found"));
        Rider rider = optionalRider.get();
        rider.accept(acceptCommand);

        riderRepository.save(rider);
        return rider;
    }

    @RequestMapping(
        value = "/riders/{id}/deliverystart",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Rider deliveryStart(
        @PathVariable(value = "id") Long id,
        @RequestBody DeliveryStartCommand deliveryStartCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rider/deliveryStart  called #####");
        Optional<Rider> optionalRider = riderRepository.findById(id);

        optionalRider.orElseThrow(() -> new Exception("No Entity Found"));
        Rider rider = optionalRider.get();
        rider.deliveryStart(deliveryStartCommand);

        riderRepository.save(rider);
        return rider;
    }

    @RequestMapping(
        value = "/riders/{id}/deliverycomplete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Rider deliveryComplete(
        @PathVariable(value = "id") Long id,
        @RequestBody DeliveryCompleteCommand deliveryCompleteCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rider/deliveryComplete  called #####");
        Optional<Rider> optionalRider = riderRepository.findById(id);

        optionalRider.orElseThrow(() -> new Exception("No Entity Found"));
        Rider rider = optionalRider.get();
        rider.deliveryComplete(deliveryCompleteCommand);

        riderRepository.save(rider);
        return rider;
    }
}
//>>> Clean Arch / Inbound Adaptor
