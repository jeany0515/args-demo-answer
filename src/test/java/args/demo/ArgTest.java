package args.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ArgTest {
    @Test
    void should_return_8080_when_get_value_give_flag_p_8080_and_schem_p_integer() {
        //given
        String command = "p 8080";
        Schema schema = new Schema("p:integer");
        Arg arg = new Arg(command, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals(8080, actual);
    }

    @Test
    void should_return_false_when_check_is_arg_with_flag() {
        //given
        String command = "p 8080";
        Schema schema = new Schema("p:integer");
        Arg arg = new Arg(command, schema);

        //when
        boolean actual = arg.withFlag("l");

        //then
        assertFalse(actual);
    }


}
