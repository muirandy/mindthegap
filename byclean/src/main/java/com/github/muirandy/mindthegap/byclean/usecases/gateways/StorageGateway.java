package com.github.muirandy.mindthegap.byclean.usecases.gateways;

import com.github.muirandy.mindthegap.byclean.usecases.StoredData;

import java.util.List;

public interface StorageGateway {
    List<StoredData> retrieveAllData();
}
