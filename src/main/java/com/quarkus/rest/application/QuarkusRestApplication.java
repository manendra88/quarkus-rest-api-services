package com.quarkus.rest.application;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

@QuarkusMain
public class QuarkusRestApplication {

    public static void main(String[] args) {
        Quarkus.run(CamelMainApplication.class);
    }
}
