package com.github.muirandy.mindthegap.byclean.usecases;

import com.github.muirandy.mindthegap.byclean.entities.Data;
import com.github.muirandy.mindthegap.byclean.entities.DataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class SimpleAppUseCaseShould {

    @Mock
    private StorageGateway storageGateway;

    @Test
    public void returnDataForStoredData() {
        SimpleAppUseCase simpleAppUseCase = new SimpleAppUseCase(storageGateway);
        StoredData storedData1 = StoredDataBuilder.aStoredDataBuilder().setDataName("1").build();
        StoredData storedData2 = StoredDataBuilder.aStoredDataBuilder().setDataName("2").build();
        given(storageGateway.retrieveAllData()).willReturn(Arrays.asList(storedData1, storedData2));

        List<Data> data = simpleAppUseCase.fetchAllData();

        Data data1 = DataBuilder.aDataBuilder().withName("1").build();
        Data data2 = DataBuilder.aDataBuilder().withName("2").build();
        assertThat(data).contains(data1);
        assertThat(data).contains(data2);
    }
}
