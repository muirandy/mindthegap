package com.github.muirandy.mindthegap.byclean.usecases;

import java.util.List;

public interface StorageGateway {
    List<StoredData> retrieveAllData();
}
