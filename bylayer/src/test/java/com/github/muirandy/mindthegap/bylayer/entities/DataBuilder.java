package com.github.muirandy.mindthegap.bylayer.entities;

public class DataBuilder {
    private String name = "";

    public static DataBuilder aDataBuilder() {
        return new DataBuilder();
    }

    public DataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Data build() {
        return new Data(name);
    }
}