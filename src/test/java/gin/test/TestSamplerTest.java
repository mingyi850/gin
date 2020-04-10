package gin.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.nio.file.Files;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class TestSamplerTest {
    File testtest = new File(new File(".").getAbsolutePath() + File.separator + "examples" + File.separator + "maven-simple" + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "mycompany" + File.separator + "app" + File.separator + "App_ESTest.java");

    TestSampler sampler = new TestSampler(testtest);

    @Test
    public void testSampleNTests() {
        int totalTests = sampler.getTotalTests();
        System.out.println(totalTests);
        sampler.commentOutNTests(sampler.getSampledTestFile(),(totalTests - 3), 22);
        Assert.assertEquals(sampler.getTestsToSample(), 3);
    }
}
