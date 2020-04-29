/*
 * This file was automatically generated by EvoSuite
 * Wed Apr 29 08:43:34 GMT 2020
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
public class SortBubble_ESTest extends SortBubble_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Integer[] integerArray0 = new Integer[5];
      int int0 = 1;
      Integer[] integerArray1 = SortBubble.sort(integerArray0, (Integer) int0);
      assertSame(integerArray0, integerArray1);
      assertSame(integerArray1, integerArray0);
      assertEquals(5, integerArray0.length);
      assertEquals(5, integerArray1.length);
      assertNotNull(integerArray1);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Integer integer0 = new Integer((-1));
      assertEquals((-1), (int)integer0);
      assertNotNull(integer0);
      
      Integer[] integerArray0 = SortBubble.sort((Integer[]) null, integer0);
      assertNull(integerArray0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Integer[] integerArray0 = new Integer[5];
      int int0 = 1;
      Integer integer0 = new Integer(1);
      assertTrue(integer0.equals((Object)int0));
      assertEquals(1, (int)integer0);
      assertNotNull(integer0);
      
      integerArray0[0] = integer0;
      integerArray0[1] = (Integer) int0;
      Integer integer1 = new Integer(3160);
      assertFalse(integer1.equals((Object)integer0));
      assertFalse(integer1.equals((Object)int0));
      assertEquals(3160, (int)integer1);
      assertNotNull(integer1);
      
      integerArray0[2] = integer1;
      integerArray0[3] = integer0;
      // Undeclared exception!
      try { 
        SortBubble.sort(integerArray0, integer1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("locogp.SortBubble", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      SortBubble sortBubble0 = new SortBubble();
      assertNotNull(sortBubble0);
  }
}
