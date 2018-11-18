package com.github.muirandy.mindthegap.services;

import com.github.muirandy.mindthegap.entities.Data;
import com.github.muirandy.mindthegap.repositories.AppRepository;
import com.github.muirandy.mindthegap.repositories.StoredData;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleAppService implements AppService {
    private AppRepository appRepository;

    public SimpleAppService(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public List<Data> fetchAllData() {
        List<StoredData> storedData = appRepository.retrieveAllData();

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
