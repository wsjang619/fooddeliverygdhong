package fooddeliverygdhong.infra;

import fooddeliverygdhong.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CookingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Cooking>> {

    @Override
    public EntityModel<Cooking> process(EntityModel<Cooking> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/accept")
                .withRel("accept")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/reject")
                .withRel("reject")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cookstart")
                .withRel("cookstart")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cookfinish")
                .withRel("cookfinish")
        );

        return model;
    }
}
