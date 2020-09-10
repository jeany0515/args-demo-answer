package args.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArgTest {
    private List<FlagSchema> flagSchemas;

    @BeforeEach
    void beforeEach() {
        flagSchemas = new ArrayList<>();
        flagSchemas.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagSchemas.add(new FlagSchema("p", ValueType.INTEGER));
        flagSchemas.add(new FlagSchema("b", ValueType.STRING));
    }

    @Test
    void should_return_8080_when_get_value_given_arg_p_8080() {
        //given
        String argPair = "p 8080";
        Schema schema = new Schema(flagSchemas);
        Arg arg = new Arg(argPair, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals(8080, actual);
    }

    @Test
    void should_return_true_when_get_value_given_arg_l_true_() {
        //given
        String argPair = "l true";
        Schema schema = new Schema(flagSchemas);
        Arg arg = new Arg(argPair, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals(true, actual);
    }

    @Test
    void should_return_yes_when_get_value_given_arg_b_yes() {
        //given
        String argPair = "b yes";
        Schema schema = new Schema(flagSchemas);
        Arg arg = new Arg(argPair, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals("yes", actual);
    }

    @Test
    void should_return_false_when_check_is_arg_with_flag() {
        //given
        String argPair = "p 8080";
        Schema schema = new Schema(flagSchemas);
        Arg arg = new Arg(argPair, schema);

        //when
        boolean actual = arg.withFlag("l");

        //then
        assertFalse(actual);
    }

    @Test
    void should_return_error_message_when_flag_length_2() {
        //given
        String argPair = "pp 8080";
        Schema schema = new Schema(flagSchemas);

        //when
        Exception exception = assertThrows(RuntimeException.class, () -> new Arg(argPair, schema));

        //then
        assertEquals("Invalid arg", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_arg_value_with_blank_space() {
        //given
        String argPair = "p 80 80";
        Schema schema = new Schema(flagSchemas);

        //when
        Exception exception = assertThrows(RuntimeException.class, () -> new Arg(argPair, schema));

        //then
        assertEquals("Invalid arg", exception.getMessage());
    }
}
