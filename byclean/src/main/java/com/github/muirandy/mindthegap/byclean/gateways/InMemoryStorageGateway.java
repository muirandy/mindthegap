package com.github.muirandy.mindthegap.byclean.gateways;

import com.github.muirandy.mindthegap.byclean.usecases.gateways.StorageGateway;
import com.github.muirandy.mindthegap.byclean.usecases.StoredData;

import java.util.Arrays;
import java.util.List;

public class InMemoryStorageGateway implements StorageGateway {
    @Override
    public List<StoredData> retrieveAllData() {
        return Arrays.asList(new StoredData("one"), new StoredData("two"));
    }
}
