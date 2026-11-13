package action;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerSearchActionTest {

    private  CustomerSearchAction action;

    @BeforeEach
    public void prepare () {
        action = new CustomerSearchAction();
    }

    @Test
    public void case1 () throws Exception {
        String[] input = {"09012345678", ""};
        String[][] result = action.execute(input);
        assertEquals(1, result.length);
    }

    
    @Test
    public void case2 () throws Exception {
        String[] input = {"", "マユミ"};
        String[][] result = action.execute(input);
        assertEquals(1, result.length);
    }

    @Test
    public void case3 () throws Exception {
        String[] input = {"09012345678", "マユミ"};
        String[][] result = action.execute(input);
        assertEquals(1, result.length);
    }

    @Test
    public void case4 () throws Exception {
        String[] input = {"01012345678", ""};
        assertEquals(0, action.execute(input).length);
    }

    @Test
    public void case5 () throws Exception {
        String[] input = {"09012345678", "　マユミ"};
        String[][] result = action.execute(input);
        assertEquals(1, result.length);
    }    
}
