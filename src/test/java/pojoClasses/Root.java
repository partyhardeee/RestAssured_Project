package pojoClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Data data;

    public Data getData() {
        return data;
    }
}
