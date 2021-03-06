package org.checkerframework.checker.test.junit.wpirunners;

import java.io.File;
import java.util.List;
import org.checkerframework.checker.testchecker.wholeprograminference.WholeProgramInferenceTestChecker;
import org.checkerframework.framework.test.CheckerFrameworkPerDirectoryTest;
import org.junit.experimental.categories.Category;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests whole-program inference with the aid of ajava files. This test is the first pass on the
 * test data, which generates the ajava files.
 *
 * <p>IMPORTANT: The errors captured in the tests located in tests/wpi-testchecker/ are not
 * relevant. The meaning of this test class is to test if the generated ajava files are similar to
 * the expected ones. The errors on .java files must be ignored.
 */
@Category(WholeProgramInferenceTestCheckerAjavaTest.class)
public class WholeProgramInferenceTestCheckerAjavaTest extends CheckerFrameworkPerDirectoryTest {

    /** @param testFiles the files containing test code, which will be type-checked */
    public WholeProgramInferenceTestCheckerAjavaTest(List<File> testFiles) {
        super(
                testFiles,
                WholeProgramInferenceTestChecker.class,
                "wpi-testchecker/non-annotated",
                "-Anomsgtext",
                "-Ainfer=ajava",
                "-Awarns");
    }

    @Parameters
    public static String[] getTestDirs() {
        return new String[] {"wpi-testchecker/non-annotated"};
    }
}
