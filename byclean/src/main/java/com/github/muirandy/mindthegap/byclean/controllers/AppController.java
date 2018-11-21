package com.github.muirandy.mindthegap.byclean.controllers;

import com.eclipsesource.json.JsonArray;
import com.github.muirandy.mindthegap.byclean.entities.Data;
import com.github.muirandy.mindthegap.byclean.usecases.AppUseCase;

import java.util.List;

public class AppController {

    private AppUseCase appUseCase;

    public AppController(AppUseCase appUseCase) {
        this.appUseCase = appUseCase;
    }

    public String readData() {
        return DataJson.jsonFor(appUseCase.fetchAllData());
    }

    private static class DataJson {
        static String jsonFor(List<Data> data) {
            JsonArray userArray = new JsonArray();
            data.stream().forEach(datum -> userArray.add(datum.name));
            return userArray.toString();
        }
    }
}
