import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TriangulatorTest {

    @Test
    public void showTrue() {
        assertTrue(true);
    }

    @Test
    public void testCorrectness() throws InterruptedException{
        Triangulator t1 = new Triangulator("t1", 1, 2, 3);
        Triangulator t2 = new Triangulator("t2", 6, 6, 6);
        Triangulator t3 = new Triangulator("t3", 1, 2, 2);
        Triangulator t4 = new Triangulator("t4", 1, 2, 123);
        Assert.assertEquals(t1.findTriangleType(), 2) ;
        Assert.assertEquals(t2.findTriangleType(), 1);
        Assert.assertEquals(t3.findTriangleType(), 3);
        Assert.assertEquals(t4.findTriangleType(), 2);
    }
}
