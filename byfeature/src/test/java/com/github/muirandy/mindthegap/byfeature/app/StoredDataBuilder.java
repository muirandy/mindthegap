package com.github.muirandy.mindthegap.byfeature.app;

public class StoredDataBuilder {
    private String dataName = "name";

    public static StoredDataBuilder aStoredDataBuilder() {
        return new StoredDataBuilder();
    }

    public StoredDataBuilder setDataName(String dataName) {
        this.dataName = dataName;
        return this;
    }

    public StoredData build() {
        return new StoredData(dataName);
    }
}