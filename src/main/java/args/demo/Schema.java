package args.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private final Map<String, String> flagTypes = new HashMap<>();

    public Schema(String schema) {
        List<String> flagSchemas = Arrays.asList(schema.split(" "));
        flagSchemas.forEach(flagSchema -> {
            String[] flagTypes = flagSchema.split(":");
            isFlagDuplicated(flagTypes[0]);
            this.flagTypes.put(flagTypes[0], flagTypes[1]);
        });
    }

    private void isFlagDuplicated(String flagType) {
        if(flagTypes.containsKey(flagType)) {
            throw new RuntimeException("Schema flag duplicated");
        }
    }

    public String getTypeOf(String flag) {
        String type = flagTypes.get(flag);
        if(type == null) {
            throw new RuntimeException("Flag not found");
        }
        return type;
    }
}
