import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *  Main class to test the LISPChecker
 *
 * @author Dau Lam
 * @Date 07/17/2019
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Running LISP Unit Tests");

        Result result = JUnitCore.runClasses(UnitTest.class);
        if (result.wasSuccessful())
            System.out.println("All tests passed");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

    }



}
