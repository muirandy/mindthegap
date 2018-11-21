package com.github.muirandy.mindthegap.byfeature.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.github.muirandy.mindthegap.byfeature.app.DataBuilder.aDataBuilder;
import static com.github.muirandy.mindthegap.byfeature.app.StoredDataBuilder.aStoredDataBuilder;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class SimpleAppServiceShould {

    @Mock
    private AppRepository appRepository;

    @Test
    public void returnDataForStoredData() {
        SimpleAppService simpleAppService = new SimpleAppService(appRepository);
        StoredData storedData1 = aStoredDataBuilder().setDataName("1").build();
        StoredData storedData2 = aStoredDataBuilder().setDataName("2").build();
        given(appRepository.retrieveAllData()).willReturn(Arrays.asList(storedData1, storedData2));

        List<Data> data = simpleAppService.fetchAllData();

        Data data1 = aDataBuilder().withName("1").build();
        Data data2 = aDataBuilder().withName("2").build();
        assertThat(data).contains(data1);
        assertThat(data).contains(data2);
    }
}
