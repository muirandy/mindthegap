package com.github.muirandy.mindthegap.byclean.usecases;

import com.github.muirandy.mindthegap.byclean.entities.Data;
import com.github.muirandy.mindthegap.byclean.usecases.gateways.StorageGateway;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleAppUseCase implements AppUseCase {
    private StorageGateway storageGateway;

    public SimpleAppUseCase(StorageGateway storageGateway) {
        this.storageGateway = storageGateway;
    }

    public List<Data> fetchAllData() {
        List<StoredData> storedData = storageGateway.retrieveAllData();

        return storedData.stream()
                         .map(sd -> Converter.dataFor(sd))
                         .collect(Collectors.toList());
    }

    private static class Converter {
        static Data dataFor(StoredData storedData) {
            Data data = new Data(storedData.dataName);
            return data;
        }
    }
}
