package com.github.muirandy.mindthegap.byfeature.app;

import java.util.Arrays;
import java.util.List;

public class InMemoryAppRepository implements AppRepository {
    @Override
    public List<StoredData> retrieveAllData() {
        return Arrays.asList(new StoredData("one"), new StoredData("two"));
    }
}
