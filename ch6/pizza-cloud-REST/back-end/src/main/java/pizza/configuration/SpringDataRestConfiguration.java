package pizza.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import pizza.model.Pizza;

@Configuration
public class SpringDataRestConfiguration {

    @Bean
    public RepresentationModelProcessor<PagedModel<EntityModel<Pizza>>> pizzaProcessor(EntityLinks links){

        return new RepresentationModelProcessor<PagedModel<EntityModel<Pizza>>>() {
            @Override
            public PagedModel<EntityModel<Pizza>> process(PagedModel<EntityModel<Pizza>> model) {

                model.add(
                        links.linkFor(Pizza.class)
                                .slash("recent")
                                .withRel("recents")
                );

                return model;
            }
        };

    }

}
