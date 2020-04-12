/*
 * This file was automatically generated by EvoSuite
 * Sun Apr 12 16:10:35 GMT 2020
 */

package locogp;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import locogp.SortBubbleDouble;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true) 
public class SortBubbleDouble_ESTest_SAMPLED extends SortBubbleDouble_ESTest_scaffolding {

/*  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Integer[] integerArray0 = new Integer[3];
      Integer integer0 = new Integer(3);
      assertNotNull(integer0);
      assertEquals(3, (int)integer0);
      
      integerArray0[0] = integer0;
      integerArray0[1] = integerArray0[0];
      integerArray0[2] = integerArray0[0];
      Integer[] integerArray1 = SortBubbleDouble.sort(integerArray0, integer0);
      assertNotNull(integerArray1);
      assertSame(integerArray0, integerArray1);
      assertSame(integerArray1, integerArray0);
      assertEquals(3, integerArray0.length);
      assertEquals(3, integerArray1.length);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      SortBubbleDouble sortBubbleDouble0 = new SortBubbleDouble();
      assertNotNull(sortBubbleDouble0);
  }

*/  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Integer[] integerArray0 = new Integer[2];
      Integer integer0 = new Integer(2789);
      assertNotNull(integer0);
      assertEquals(2789, (int)integer0);
      
      integerArray0[0] = integer0;
      Integer integer1 = new Integer(0);
      assertNotNull(integer1);
      assertEquals(0, (int)integer1);
      assertFalse(integer1.equals((Object)integer0));
      
      integerArray0[1] = integer1;
      Integer integer2 = new Integer(1401);
      assertNotNull(integer2);
      assertEquals(1401, (int)integer2);
      assertFalse(integer2.equals((Object)integer1));
      assertFalse(integer2.equals((Object)integer0));
      
      // Undeclared exception!
      try { 
        SortBubbleDouble.sort(integerArray0, integer2);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 2
         //
         verifyException("locogp.SortBubbleDouble", e);
      }
  }
}