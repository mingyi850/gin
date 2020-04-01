/*
 * This file was automatically generated by EvoSuite
 * Wed Apr 01 10:08:11 GMT 2020
 */

package locogp;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import locogp.SortBubble;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true) 
public class SortBubble_ESTest_SAMPLED extends SortBubble_ESTest_scaffolding {

/*  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      SortBubble sortBubble0 = new SortBubble();
      assertNotNull(sortBubble0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Integer[] integerArray0 = new Integer[6];
      Integer integer0 = new Integer(1);
      assertEquals(1, (int)integer0);
      assertNotNull(integer0);
      
      Integer[] integerArray1 = SortBubble.sort(integerArray0, integer0);
      assertSame(integerArray0, integerArray1);
      assertSame(integerArray1, integerArray0);
      assertNotNull(integerArray1);
      assertEquals(6, integerArray0.length);
      assertEquals(6, integerArray1.length);
  }

*/  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Integer[] integerArray0 = new Integer[6];
      Integer integer0 = new Integer(0);
      assertEquals(0, (int)integer0);
      assertNotNull(integer0);
      
      integerArray0[0] = integer0;
      integerArray0[1] = integerArray0[0];
      Integer integer1 = new Integer(1588);
      assertFalse(integer1.equals((Object)integer0));
      assertEquals(1588, (int)integer1);
      assertNotNull(integer1);
      
      integerArray0[2] = integer1;
      integerArray0[3] = integer0;
      // Undeclared exception!
      try { 
        SortBubble.sort(integerArray0, integerArray0[2]);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("locogp.SortBubble", e);
      }
  }
}
