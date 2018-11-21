package com.github.muirandy.mindthegap.byclean;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.github.muirandy.mindthegap.byclean")
public class LayersShould {

    @ArchTest
    public static final ArchRule exhibitCleanArchitecture =

        layeredArchitecture()
                .layer("Web").definedBy("com.github.muirandy.mindthegap.byclean.web..")
                .layer("Services").definedBy("com.github.muirandy.mindthegap.byclean.services..")
                .layer("Repositories").definedBy("com.github.muirandy.mindthegap.byclean.repositories..")
                .layer("Entities").definedBy("com.github.muirandy.mindthegap.byclean.entities..")


                .whereLayer("Web").mayNotBeAccessedByAnyLayer()
                .whereLayer("Repositories").mayNotBeAccessedByAnyLayer()
//                .whereLayer("Services").mayNotBeAccessedByAnyLayer();
                .whereLayer("Services").mayOnlyBeAccessedByLayers("Web", "Repositories");

}
