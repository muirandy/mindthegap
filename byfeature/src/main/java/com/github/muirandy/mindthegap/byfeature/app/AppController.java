package com.github.muirandy.mindthegap.byfeature.app;

import com.eclipsesource.json.JsonArray;

import java.util.List;

public class AppController {

    private AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    public String readData() {
        return DataJson.jsonFor(appService.fetchAllData());
    }

    private static class DataJson {
        static String jsonFor(List<Data> data) {
            JsonArray userArray = new JsonArray();
            data.stream().forEach(datum -> userArray.add(datum.name));
            return userArray.toString();
        }
    }
}
