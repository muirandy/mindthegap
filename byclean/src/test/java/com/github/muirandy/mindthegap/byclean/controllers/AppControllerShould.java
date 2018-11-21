package com.github.muirandy.mindthegap.byclean.controllers;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.github.muirandy.mindthegap.byclean.entities.Data;
import com.github.muirandy.mindthegap.byclean.entities.DataBuilder;
import com.github.muirandy.mindthegap.byclean.usecases.AppUseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AppControllerShould {

    @Mock
    private AppUseCase AppUseCase;

    @Test
    public void getDataFromService() {
        AppController appController = new AppController(AppUseCase);
        Data data1 = new DataBuilder().withName("1").build();
        Data data2 = new DataBuilder().withName("2").build();
        given(AppUseCase.fetchAllData()).willReturn(Arrays.asList(data1, data2));

        String data = appController.readData();
        JsonArray arrayOfValues = Json.parse(data).asArray();


        assertThat(arrayOfValues).containsExactlyInAnyOrder(Json.value("1"), Json.value("2"));
    }
}
