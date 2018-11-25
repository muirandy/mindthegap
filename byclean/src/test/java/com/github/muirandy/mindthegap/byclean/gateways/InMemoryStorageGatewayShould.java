package com.github.muirandy.mindthegap.byclean.gateways;

import com.github.muirandy.mindthegap.byclean.usecases.gateways.StorageGateway;
import com.github.muirandy.mindthegap.byclean.usecases.StoredData;
import com.github.muirandy.mindthegap.byclean.usecases.StoredDataBuilder;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class InMemoryStorageGatewayShould {

    @Test
    public void alwaysHaveTwoEntities() {
        StorageGateway inMemoryStorageGateway = new InMemoryStorageGateway();

        List<StoredData> storedData = inMemoryStorageGateway.retrieveAllData();

        assertThat(storedData).contains(StoredDataBuilder.aStoredDataBuilder().setDataName("one").build());
        assertThat(storedData).contains(StoredDataBuilder.aStoredDataBuilder().setDataName("two").build());
    }
}
