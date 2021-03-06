/*
 * This file was automatically generated by EvoSuite
 * Sun May 03 19:17:44 GMT 2020
 */

package locogp;

import org.junit.Test;
import static org.junit.Assert.*;
import locogp.SortCocktail;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true) 
public class SortCocktail_ESTest_SAMPLED extends SortCocktail_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Integer[] integerArray0 = new Integer[4];
      Integer integer0 = new Integer(0);
      assertNotNull(integer0);
      assertEquals(0, (int)integer0);
      
      integerArray0[0] = integer0;
      Integer integer1 = new Integer((-1590));
      assertNotNull(integer1);
      assertFalse(integer1.equals((Object)integer0));
      assertEquals((-1590), (int)integer1);
      
      integerArray0[1] = integer1;
      Integer integer2 = new Integer(2);
      assertNotNull(integer2);
      assertFalse(integer2.equals((Object)integer1));
      assertFalse(integer2.equals((Object)integer0));
      assertEquals(2, (int)integer2);
      
      Integer[] integerArray1 = SortCocktail.sort(integerArray0, integer2);
      assertNotNull(integerArray1);
      assertFalse(integer2.equals((Object)integer1));
      assertFalse(integer2.equals((Object)integer0));
      assertSame(integerArray0, integerArray1);
      assertSame(integerArray1, integerArray0);
      assertEquals(4, integerArray0.length);
      assertEquals(4, integerArray1.length);
  }

/*  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Integer[] integerArray0 = new Integer[9];
      Integer integer0 = new Integer((-663));
      assertNotNull(integer0);
      assertEquals((-663), (int)integer0);
      
      integerArray0[0] = integer0;
      integerArray0[1] = integer0;
      integerArray0[2] = integer0;
      integerArray0[3] = integerArray0[2];
      Integer integer1 = new Integer((-1635));
      assertNotNull(integer1);
      assertFalse(integer1.equals((Object)integer0));
      assertEquals((-1635), (int)integer1);
      
      integerArray0[4] = integer1;
      integerArray0[5] = integer1;
      Integer integer2 = new Integer(6);
      assertNotNull(integer2);
      assertFalse(integer2.equals((Object)integer0));
      assertFalse(integer2.equals((Object)integer1));
      assertEquals(6, (int)integer2);
      
      Integer[] integerArray1 = SortCocktail.sort(integerArray0, integer2);
      assertNotNull(integerArray1);
      assertFalse(integer2.equals((Object)integer0));
      assertFalse(integer2.equals((Object)integer1));
      assertSame(integerArray0, integerArray1);
      assertSame(integerArray1, integerArray0);
      assertEquals(9, integerArray0.length);
      assertEquals(9, integerArray1.length);
  }

*/  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      SortCocktail sortCocktail0 = new SortCocktail();
      assertNotNull(sortCocktail0);
  }
}
