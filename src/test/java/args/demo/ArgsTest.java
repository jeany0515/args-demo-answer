package args.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsTest {
    private List<FlagSchema> flagSchemas;

    @BeforeEach
    void beforeEach() {
        flagSchemas = new ArrayList<>();
        flagSchemas.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagSchemas.add(new FlagSchema("p", ValueType.INTEGER));
        flagSchemas.add(new FlagSchema("b", ValueType.STRING));
    }

    @Test
    void should_return_8080_when_get_value_given_command_p8080_schema_p_integer() {
        //given
        String command = "-p 8080";
        Schema schema = new Schema(flagSchemas);
        String flag = "p";
        Args args = new Args(command, schema);

        //when
        Object actual = args.getValueOf(flag);

        //then
        assertEquals(8080, actual);
    }
}
