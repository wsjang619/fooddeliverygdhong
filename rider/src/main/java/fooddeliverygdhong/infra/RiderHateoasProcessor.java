package fooddeliverygdhong.infra;

import fooddeliverygdhong.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RiderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Rider>> {

    @Override
    public EntityModel<Rider> process(EntityModel<Rider> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/accept")
                .withRel("accept")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/deliverystart")
                .withRel("deliverystart")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/deliverycomplete"
                )
                .withRel("deliverycomplete")
        );

        return model;
    }
}
