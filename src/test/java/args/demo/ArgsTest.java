package args.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void should_return_8080_when_get_value_given_args_p8080_schema_p_integer() {
        //given
        String argsString = "-p 8080";
        Schema schema = new Schema(flagSchemas);
        String flag = "p";
        Args args = new Args(argsString, schema);

        //when
        Object actual = args.getValueOf(flag);

        //then
        assertEquals(8080, actual);
    }

    @Test
    void should_return_error_message_when_args_start_without_flag_middle_line() {
        //given
        String argsString = "p 8080";
        Schema schema = new Schema(flagSchemas);

        //when
        Exception exception = assertThrows(RuntimeException.class, () -> new Args(argsString, schema));

        //then
        assertEquals("Arg format invalid", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_args_flag_duplicated() {
        //given
        String argsString = "-p 8080 -p true";
        Schema schema = new Schema(flagSchemas);

        //when
        Exception exception = assertThrows(RuntimeException.class, () -> new Args(argsString, schema));

        //then
        assertEquals("Args flag duplicated", exception.getMessage());
    }
}
