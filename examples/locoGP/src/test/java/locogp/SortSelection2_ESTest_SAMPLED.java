/*
 * This file was automatically generated by EvoSuite
 * Sun May 03 14:07:39 GMT 2020
 */

package locogp;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import locogp.SortSelection2;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true) 
public class SortSelection2_ESTest_SAMPLED extends SortSelection2_ESTest_scaffolding {

/*  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      SortSelection2 sortSelection2_0 = new SortSelection2();
      assertNotNull(sortSelection2_0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Integer[] integerArray0 = new Integer[3];
      Integer integer0 = new Integer(0);
      assertEquals(0, (int)integer0);
      assertNotNull(integer0);
      
      integerArray0[0] = integer0;
      Integer integer1 = new Integer((-3534));
      assertFalse(integer1.equals((Object)integer0));
      assertEquals((-3534), (int)integer1);
      assertNotNull(integer1);
      
      integerArray0[1] = integer1;
      Integer integer2 = new Integer(2691);
      assertFalse(integer2.equals((Object)integer0));
      assertFalse(integer2.equals((Object)integer1));
      assertEquals(2691, (int)integer2);
      assertNotNull(integer2);
      
      // Undeclared exception!
      try { 
        SortSelection2.sort(integerArray0, integer2);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("locogp.SortSelection2", e);
      }
  }

*/  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Integer[] integerArray0 = new Integer[2];
      Integer integer0 = new Integer(2);
      assertEquals(2, (int)integer0);
      assertNotNull(integer0);
      
      integerArray0[0] = integer0;
      integerArray0[1] = integerArray0[0];
      Integer[] integerArray1 = SortSelection2.sort(integerArray0, integer0);
      assertSame(integerArray0, integerArray1);
      assertSame(integerArray1, integerArray0);
      assertNotNull(integerArray1);
      assertEquals(2, integerArray0.length);
      assertEquals(2, integerArray1.length);
  }
}
