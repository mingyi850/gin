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
    File testtest = new File("C:\\Users\\Admin\\Documents\\Computer Science\\Y3\\Final Year Project\\gin-fork\\examples\\maven-simple\\src\\test\\java\\com\\mycompany\\app\\App_ESTest.java");

    TestSampler sampler = new TestSampler(testtest);

    @Test
    public void testSampleNTests() {
        int totalTests = sampler.getTotalTests();
        System.out.println(totalTests);
        sampler.commentOutNTests(sampler.getSampledTestFile(),(totalTests - 3), 22);
        Assert.assertEquals(sampler.getTestsToSample(), 3);
    }
}
