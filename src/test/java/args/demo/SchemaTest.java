package args.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SchemaTest {
    private List<FlagSchema> flagSchemas;

    @BeforeEach
    void beforeEach() {
        flagSchemas = new ArrayList<>();
        flagSchemas.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagSchemas.add(new FlagSchema("p", ValueType.INTEGER));
        flagSchemas.add(new FlagSchema("b", ValueType.STRING));
    }

    @Test
    void should_return_integer_when_get_type_given_flag_p_and_schema_p_integer() {
        //given
        String flag = "p";
        Schema schema = new Schema(flagSchemas);

        //when
        String actual = schema.getTypeOf(flag);

        //then
        assertEquals("integer", actual);
    }

    @Test
    void should_return_error_message_when_get_type_given_flag_m_and_schema_l_boolean() {
        //given
        String flag = "m";
        Schema schema = new Schema(flagSchemas);

        //then
        assertThrows(FlagNotFound.class, () -> schema.getTypeOf(flag));
    }

    @Test()
    void should_return_error_message_given_schema_duplicate_flag_l() {
        //given
        flagSchemas.add(new FlagSchema("p", ValueType.BOOLEAN));

        //then
        assertThrows(SchemaFlagDuplicated.class, () -> new Schema(flagSchemas));
    }
}
