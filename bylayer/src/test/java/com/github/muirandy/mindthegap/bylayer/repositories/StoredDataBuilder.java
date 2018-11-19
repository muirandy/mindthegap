package com.github.muirandy.mindthegap.bylayer.repositories;

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