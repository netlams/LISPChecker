import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *  Unit Tests
 *
 * @author Dau Lam
 * @Date 07/17/2019
 */
public class UnitTest {

    LISPChecker lispChecker = new LISPChecker();

    @Test
    public void oneSetvalidateShouldReturnTrueTest() {
        assertEquals(true, lispChecker.validate("( foo )"));
    }

    @Test
    public void nestedSetValidateShouldReturnTrueTest() {
        assertEquals(true, lispChecker.validate("( (foo) bar)"));
    }

    @Test
    public void multipleNestedSetValidateShouldReturnTrueTest() {
        assertEquals(true, lispChecker.validate("( (list 5) list 2 ( + 1 2 (foo)))"));
    }

    @Test
    public void unclosedSetValidateShouldReturnFalseTest() {
        assertEquals(false, lispChecker.validate("( ( foo )"));
    }

    @Test
    public void extraClosingValidateShouldReturnFalseTest() {
        assertEquals(false, lispChecker.validate("( foo ) )"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateEmptyStringThrowsIllegalArgumentException() {
        lispChecker.validate("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateNullThrowsIllegalArgumentException() {
        lispChecker.validate(null);
    }
}
