package com.github.muirandy.mindthegap.byfeature.data;

import org.junit.Test;

import java.util.List;

import static com.github.muirandy.mindthegap.byfeature.data.StoredDataBuilder.aStoredDataBuilder;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class InMemoryAppRepositoryShould {

    @Test
    public void alwaysHaveTwoEntities() {
        AppRepository inMemoryAppRepository = new InMemoryAppRepository();

        List<StoredData> storedData = inMemoryAppRepository.retrieveAllData();

        assertThat(storedData).contains(aStoredDataBuilder().setDataName("one").build());
        assertThat(storedData).contains(aStoredDataBuilder().setDataName("two").build());
    }
}
