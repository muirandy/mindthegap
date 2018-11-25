package com.github.muirandy.mindthegap.byclean;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.github.muirandy.mindthegap.byclean")
public class LayersShould {

    private static final String CONTROLLERS = "Web";
    private static final String USE_CASES = "Services";
    private static final String GATEWAYS = "Repositories";
    private static final String ENTITIES = "Entities";
    private static final String USE_CASE_GATEWAYS = "Use Case Gateways";

    @ArchTest
    public static final ArchRule exhibitCleanArchitecture =

        layeredArchitecture()
                .layer(CONTROLLERS).definedBy("com.github.muirandy.mindthegap.byclean.controllers..")
                .layer(USE_CASES).definedBy("com.github.muirandy.mindthegap.byclean.usecases..")
                .layer(USE_CASE_GATEWAYS).definedBy("com.github.muirandy.mindthegap.byclean.usecases.gateways..")
                .layer(GATEWAYS).definedBy("com.github.muirandy.mindthegap.byclean.gateways..")
                .layer(ENTITIES).definedBy("com.github.muirandy.mindthegap.byclean.entities..")


                .whereLayer(CONTROLLERS).mayNotBeAccessedByAnyLayer()
                .whereLayer(GATEWAYS).mayNotBeAccessedByAnyLayer()
//                                .whereLayer(USE_CASES).mayOnlyBeAccessedByLayers(CONTROLLERS);
                .whereLayer(USE_CASES).mayOnlyBeAccessedByLayers(CONTROLLERS, GATEWAYS)
                .whereLayer(USE_CASE_GATEWAYS).mayOnlyBeAccessedByLayers(USE_CASES, GATEWAYS);

}
