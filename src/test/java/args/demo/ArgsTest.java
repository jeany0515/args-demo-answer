package args.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsTest {
    @Test
    void should_return_8080_when_get_value_given_command_p8080_schema_p_integer() {
        //given
        String command = "-p 8080";
        Schema schema = new Schema("p:integer");
        String flag = "p";
        Args args = new Args(command, schema);

        //when
        Object actual = args.getValueOf(flag);

        //then
        assertEquals(8080, actual);
    }
}
