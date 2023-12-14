package com.quarkus.rest.application.api;

import com.quarkus.rest.application.model.Person;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuarkusRestApiRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        restConfiguration().bindingMode(RestBindingMode.json);
        rest("/persons")
                .get()
                .to("direct:getPersons")
                .post()
                .type(Person.class)
                .to("direct:addPerson");

        from("direct:getPersons")
                .to(ExchangePattern.InOut,"jpa://com.quarkus.rest.application.model.Person?resultClass=com.quarkus.rest.application.model.Person&namedQuery=findAll")
                .log("Person List:_${body}");

        from("direct:addPerson")
                .log("Insert Data into H2 DB")
                .to("jpa://com.quarkus.rest.application.model.Person?usePersist=true")
                .log("Response From Add person route");

    }
}
