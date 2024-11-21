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
// @RequestMapping(value="/payments")
@Transactional
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @RequestMapping(
        value = "/payments/{id}/paycomplete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Payment payComplete(
        @PathVariable(value = "id") Long id,
        @RequestBody PayCompleteCommand payCompleteCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /payment/payComplete  called #####");
        Optional<Payment> optionalPayment = paymentRepository.findById(id);

        optionalPayment.orElseThrow(() -> new Exception("No Entity Found"));
        Payment payment = optionalPayment.get();
        payment.payComplete(payCompleteCommand);

        paymentRepository.save(payment);
        return payment;
    }

    @RequestMapping(
        value = "/payments/{id}/paycancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Payment payCancel(
        @PathVariable(value = "id") Long id,
        @RequestBody PayCancelCommand payCancelCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /payment/payCancel  called #####");
        Optional<Payment> optionalPayment = paymentRepository.findById(id);

        optionalPayment.orElseThrow(() -> new Exception("No Entity Found"));
        Payment payment = optionalPayment.get();
        payment.payCancel(payCancelCommand);

        paymentRepository.save(payment);
        return payment;
    }
}
//>>> Clean Arch / Inbound Adaptor
