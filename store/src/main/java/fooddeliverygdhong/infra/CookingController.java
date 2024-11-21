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
// @RequestMapping(value="/cookings")
@Transactional
public class CookingController {

    @Autowired
    CookingRepository cookingRepository;

    @RequestMapping(
        value = "/cookings/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking accept(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptCommand acceptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/accept  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.accept(acceptCommand);

        cookingRepository.save(cooking);
        return cooking;
    }

    @RequestMapping(
        value = "/cookings/{id}/reject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking reject(
        @PathVariable(value = "id") Long id,
        @RequestBody RejectCommand rejectCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/reject  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.reject(rejectCommand);

        cookingRepository.save(cooking);
        return cooking;
    }

    @RequestMapping(
        value = "/cookings/{id}/cookstart",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking cookStart(
        @PathVariable(value = "id") Long id,
        @RequestBody CookStartCommand cookStartCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/cookStart  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.cookStart(cookStartCommand);

        cookingRepository.save(cooking);
        return cooking;
    }

    @RequestMapping(
        value = "/cookings/{id}/cookfinish",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking cookFinish(
        @PathVariable(value = "id") Long id,
        @RequestBody CookFinishCommand cookFinishCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/cookFinish  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.cookFinish(cookFinishCommand);

        cookingRepository.save(cooking);
        return cooking;
    }
}
//>>> Clean Arch / Inbound Adaptor
