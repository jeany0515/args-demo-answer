package args.demo;

import java.util.*;

public class Schema {
    private List<FlagSchema> flagSchemas;

    public Schema(List<FlagSchema> flagSchemas) {
        this.flagSchemas = flagSchemas;
        validateFlagDistinct();
    }

    private void validateFlagDistinct() {
        long flagCount = flagSchemas.stream().map(FlagSchema::getFlag).distinct().count();
        boolean isFlagDistinct = flagSchemas.size() == flagCount;
        if(!isFlagDistinct) {
            throw new RuntimeException("Schema flag duplicated");
        }
    }

    public String getTypeOf(String flag) {
        try {
            return flagSchemas.stream().filter(flagSchema -> flagSchema.getFlag().equals(flag)).findFirst().orElse(null).getType();
        } catch (NullPointerException err) {
            throw new RuntimeException("Flag not found");
        }
    }

    public Object getDefaultValueOf(String flag) {
        return flagSchemas.stream().filter(flagSchema -> flagSchema.getFlag().equals(flag)).findFirst().get().getDefaultValue();
    }
}
