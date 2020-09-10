package args.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlagSchemaTest {
    @Test
    void should_return_boolean_when_get_type_given_l_boolean() {
        //given
        FlagSchema flagSchema = new FlagSchema("l", ValueType.BOOLEAN);

        //when
        String actual = flagSchema.getType();

        //then
        assertEquals("boolean", actual);
    }

    @Test
    void should_return_0_when_get_default_value_given_l_integer() {
        //given
        FlagSchema flagSchema = new FlagSchema("l", ValueType.INTEGER);

        //when
        Object actual = flagSchema.getDefaultValue();

        //then
        assertEquals(0, actual);
    }

    @Test
    void should_return_p_when_get_flag_given_p_string() {
        //given
        FlagSchema flagSchema = new FlagSchema("p", ValueType.STRING);

        //when
        String actual = flagSchema.getFlag();

        //then
        assertEquals("p", actual);
    }
}
