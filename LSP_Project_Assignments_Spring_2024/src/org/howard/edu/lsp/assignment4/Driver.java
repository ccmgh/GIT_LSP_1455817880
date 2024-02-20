package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is the project main class and also the test harness class for
 * class IntegerSet class {@link org.howard.edu.lsp.assignment4.IntegerSet}.
 * 
 * @author Claude Cockfield
 * @version %I%, %G%
 * @since 0.1
 */
public class Driver {
  
  /**
   * Default constructor for {@link org.howard.edu.lsp.assignment4.Driver}.
   */
  public Driver() {
  }
  
  /**
   * Main method.
   * 
   * @param args standard command line argument array. It should be empty. This
   *             code does not use any command line arguments so the content of
   *             parameter "args" if any) is ignored.
   */
  public static void main(String[] args) {
  
    System.out.println("start.");
    System.out.println();
  
    ADD_test();
    System.out.println();
    CLEAR_test();
    System.out.println();
    COMPLEMENT_test();
    System.out.println();
    CONTAINS_test();
    System.out.println();
    DIFFERENCE_test();
    System.out.println();
    EQUALS_test();
    System.out.println();
    INTERSECT_test();
    System.out.println();
    ISEMPTY_test();
    System.out.println();
    LARGEST_test();
    System.out.println();
    LENGTH_test();
    System.out.println();
    REMOVE_test();
    System.out.println();
    SMALLEST_test();
    System.out.println();
    UNION_test();
  
    System.out.println();
    System.out.println("stop.");
  }

  /**
   * Method which generates a small  IntegerSet. Set values are hard-wired.
   * @return IntegerSet result.
   */
  static IntegerSet setA() {
    return new IntegerSet(new ArrayList<Integer>(Arrays.asList(3, 4, 3, 2, 10, 11, 12)));  
  }

  /**
   * Method which generates a small IntegerSet. Set values are hard-wired.
   * @return IntegerSet result.
   */
  static IntegerSet setB() {
    return new IntegerSet(new ArrayList<Integer>(Arrays.asList(15, 2, 11, 1)));
  }

  /**
   * Method which generates an empty IntegerSet. Set values are hard-wired.
   * @return IntegerSet result.
   */
  static IntegerSet setC() {
    return new IntegerSet(new ArrayList<Integer>());
  }

  /**
   * Method which generates a small  IntegerSet. Set values are hard-wired.
   * @return IntegerSet result.
   */
  static IntegerSet setD() {
    return new IntegerSet(new ArrayList<Integer>(Arrays.asList(3, 4, 3, 21, 2, 18, 10, 11, 12)));  
  }

  /**
   * Method which generates a small  IntegerSet. Set values are hard-wired.
   * @return IntegerSet result. SetE has the same content as setA.
   */
  static IntegerSet setE() {
    IntegerSet setA = setA();
    IntegerSet setE = new IntegerSet();
    
    try {
      while (!setA.isEmpty()) {
        setE.add(setA.largest());
        setA.remove(setE.smallest());
      }
      return setE;  
    } catch (Exception e) {
      System.out.println(e);
      System.out.println(e.getMessage());
    }
    
    return new IntegerSet();
  }

  /**
   * Method which generates a small  IntegerSet. Set values are hard-wired.
   * @return IntegerSet result.
   */
  static IntegerSet setF() {
    return new IntegerSet(new ArrayList<Integer>(Arrays.asList(3, 4, 3, 2, 10, 11, 12)));  
  }

  /**
   * Method which generates a small  IntegerSet. Set values are hard-wired.
   * @return IntegerSet result.
   */
  static IntegerSet setG() {
    return new IntegerSet(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 7, 8, 11)));  
  }

  /**
   * Method which generates a small  IntegerSet. Set values are hard-wired.
   * @return IntegerSet result.
   */
  static IntegerSet setH() {
    return new IntegerSet(new ArrayList<Integer>(Arrays.asList(0, 1, 10, 2, 5, 8, 6, 9, 19)));  
  }

  /**
   * Method which generates a small  IntegerSet. Set values are hard-wired.
   * @return IntegerSet result.
   */
  static IntegerSet setI() {
    return new IntegerSet(new ArrayList<Integer>(Arrays.asList(0, 1, 10, 2, 5, 8, 6, 9, 19, 22, 32, 40, -1, 7)));  
  }

  /**
   * Tests add operation.
   */
  static void ADD_test() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setA = setA();
        
    System.out.println();
    System.out.println(setA.toString());
  
    setA.add(1);
    setA.add(3);
    setA.add(2);
    setA.add(4);
    setA.add(-1);
    setA.add(-1);
    setA.add(-10);
    setA.add(-10);
    setA.add(-10);
    setA.add(-10);
    setA.add(-10);
    setA.add(1);
  
    System.out.println();
    System.out.println(setA.toString());
  }

  /**
   * Tests clear operation.
   */
  static void CLEAR_test() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setA = setA();
        
    System.out.println();
    System.out.println(setA.toString());
  
    setA.clear();
    
    System.out.println();
    System.out.println(setA.toString());
  }

  /**
   * Tests complement operation.
   */
  static void COMPLEMENT_test() {
    COMPLEMENT_test_I();
    System.out.println();
    COMPLEMENT_test_II();
    System.out.println();
    COMPLEMENT_test_III();
    System.out.println();
    COMPLEMENT_test_IIII();
    System.out.println();
    COMPLEMENT_test_V();
  }
  
  /**
   * Tests complement operation I.
   */
  static void COMPLEMENT_test_I() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setF = setF();
    IntegerSet setB = setB();
        
    System.out.println();
    System.out.println(setF.toString());
    System.out.println(setB.toString());
  
    setF.complement(setB);
    
    System.out.println();
    System.out.println(setF.toString());
    System.out.println(setB.toString());
  }

  /**
   * Tests complement operation II.
   */
  static void COMPLEMENT_test_II() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setG = setG();
    IntegerSet setH = setH();
        
    System.out.println();
    System.out.println(setG.toString());
    System.out.println(setH.toString());
  
    setG.complement(setH);
    
    System.out.println();
    System.out.println(setG.toString());
    System.out.println(setH.toString());
  }

  /**
   * Tests complement operation III.
   */
  static void COMPLEMENT_test_III() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setB = setB();
    IntegerSet setF = setF();
        
    System.out.println();
    System.out.println(setB.toString());
    System.out.println(setF.toString());
  
    setB.complement(setF);
    
    System.out.println();
    System.out.println(setB.toString());
    System.out.println(setF.toString());
  }

  /**
   * Tests complement operation IIII.
   */
  static void COMPLEMENT_test_IIII() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setH = setH();
    IntegerSet setG = setG();
        
    System.out.println();
    System.out.println(setH.toString());
    System.out.println(setG.toString());
  
    setH.complement(setG);
    
    System.out.println();
    System.out.println(setH.toString());
    System.out.println(setG.toString());
  }

  /**
   * Tests complement operation V.
   */
  static void COMPLEMENT_test_V() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setH = setH();
    IntegerSet setI = setI();
        
    System.out.println();
    System.out.println(setH.toString());
    System.out.println(setI.toString());
  
    setH.complement(setI);
    
    System.out.println();
    System.out.println(setH.toString());
    System.out.println(setI.toString());
  }

  /**
   * Tests contains operation.
   */
  static void CONTAINS_test() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setA = new IntegerSet();
        
    int target = 20;
    
    setA.add(30);
    setA.add(target);
    setA.add(10);
  
    System.out.println();
    System.out.println(setA.toString());

    System.out.println();
    if (setA.contains(20)) {
      System.out.println("setA contains " + target);      
    } else {
      System.out.println("setA NOT contains " + target);            
    }
  }

  /**
   * Tests difference operation.
   */
  static void DIFFERENCE_test() {
    DIFFERENCE_test_I();
    System.out.println();
    DIFFERENCE_test_II();
  }

  /**
   * Tests difference operation I.
   */
  static void DIFFERENCE_test_I() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setA = setA();
    IntegerSet setB = setB();

    System.out.println();
    System.out.println(setA.toString());
    System.out.println(setB.toString());
  
    setA.diff(setB);
  
    System.out.println();
    System.out.println(setA.toString());
    System.out.println(setB.toString());
  }

  /**
   * Tests difference operation II.
   */
  static void DIFFERENCE_test_II() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setA = setA();

    System.out.println();
    System.out.println(setA.toString());
  
    setA.diff(setA);
  
    System.out.println();
    System.out.println(setA.toString());
  }

  /**
   * Tests equals operation.
   */
  static void EQUALS_test() {
    EQUALS_test_I();
    System.out.println();
    EQUALS_test_II();
  }

  /**
   * Tests equals operation I.
   */
  static void EQUALS_test_I() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setA = setA();
    IntegerSet setB = setB();
        
    System.out.println();
    System.out.println(setA.toString());
    System.out.println(setB.toString());

    System.out.println();
    if (setA.equals(setB)) {
      System.out.println("setA == setB");      
    } else {      
      System.out.println("setA != setB");      
    }
  }

  /**
   * Tests equals operation II.
   */
  static void EQUALS_test_II() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setA = setA();
    IntegerSet setE = setE();
        
    System.out.println();
    System.out.println(setA.toString());
    System.out.println(setE.toString());

    System.out.println();
    if (setA.equals(setE)) {
      System.out.println("setA == setE");      
    } else {      
      System.out.println("setA != setE");      
    }
  }

  /**
   * Tests intersect operation.
   */
  static void INTERSECT_test() {
    INTERSECT_test_I();
    System.out.println();
    INTERSECT_test_II();
    System.out.println();
    INTERSECT_test_III();
  }

  /**
   * Tests intersect operation I.
   */
  static void INTERSECT_test_I() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setD = setD();
    IntegerSet setB = setB();
        
    System.out.println();
    System.out.println(setD.toString());
    System.out.println(setB.toString());
  
    setD.intersect(setB);

    System.out.println();
    System.out.println(setD.toString());
    System.out.println(setB.toString());
  }

  /**
   * Tests intersect operation II.
   */
  static void INTERSECT_test_II() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setD = setD();
        
    System.out.println();
    System.out.println(setD.toString());
  
    setD.intersect(setD);

    System.out.println();
    System.out.println(setD.toString());
  }

  /**
   * Tests intersect operation III.
   */
  static void INTERSECT_test_III() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setD = setD();
    IntegerSet setC = setC();
        
    System.out.println();
    System.out.println(setD.toString());
    System.out.println(setC.toString());
  
    setD.intersect(setC);

    System.out.println();
    System.out.println(setD.toString());
    System.out.println(setC.toString());
  }

  /**
   * Tests isempty operation.
   */
  static void ISEMPTY_test() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setC = setC();
        
    System.out.println();
    System.out.println(setC.toString());

    System.out.println();
    if (setC.isEmpty()) {
      System.out.println("setC is empty");      
    } else {      
      System.out.println("setC NOT empty");      
    }
  }

  /**
   * Tests largest operation.
   */
  static void LARGEST_test() { 
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
  
    try {
      IntegerSet setC = setC();
      
      System.out.println();
      System.out.println(setC.toString());
      
      System.out.println();
      System.out.println("largest " + setC.largest());
  
    } catch (Exception e) {
      
      System.out.println("exception " + e.toString());
    }
  
    try {
      IntegerSet setA = setA();
      
      System.out.println();
      System.out.println(setA.toString());
      
      System.out.println();
      System.out.println("largest " + setA.largest());
  
    } catch (Exception e) {
      
      System.out.println("exception " + e.toString());
    }
  }

  /**
   * Tests length operation.
   */
  static void LENGTH_test() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setB = setB();

    System.out.println();    
    System.out.println(setB.toString());
    
    System.out.println();
    System.out.println("length " + setB.length());
  }

  /**
   * Tests remove operation.
   */
  static void REMOVE_test() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setA = setA();
        
    int target = 16;
    
    setA.add(target);
  
    System.out.println();
    System.out.println(setA.toString());
  
    setA.remove(target);
  
    System.out.println();
    System.out.println(setA.toString());
  }

  /**
   * Tests smallest operation.
   */
  static void SMALLEST_test() {    
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());

    try {
      IntegerSet setC = setC();
      
      System.out.println();
      System.out.println(setC.toString());
      
      System.out.println();
      System.out.println("smallest " + setC.smallest());

    } catch (Exception e) {
      
      System.out.println("exception " + e.toString());
    }

    try {
      IntegerSet setA = setA();
      
      System.out.println();
      System.out.println(setA.toString());
      
      System.out.println();
      System.out.println("smallest " + setA.smallest());

    } catch (Exception e) {
      
      System.out.println("exception " + e.toString());
    }
  }

  /**
   * Tests union operation.
   */
  static void UNION_test() {
    UNION_test_I();
    System.out.println();
    UNION_test_II();
    System.out.println();
    UNION_test_III();
  }

  /**
   * Tests union operation I.
   */
  static void UNION_test_I() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setA = setA();
    IntegerSet setB = setB();
        
    System.out.println();
    System.out.println(setA.toString());
    System.out.println(setB.toString());
  
    setA.union(setB);
  
    System.out.println();
    System.out.println(setA.toString());
    System.out.println(setB.toString());
  }
  
  /**
   * Tests union operation II.
   */
  static void UNION_test_II() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setC = setC();
    IntegerSet setB = setB();
        
    System.out.println();
    System.out.println(setC.toString());
    System.out.println(setB.toString());
  
    setC.union(setB);
  
    System.out.println();
    System.out.println(setC.toString());
    System.out.println(setB.toString());
  }

  /**
   * Tests union operation III.
   */
  static void UNION_test_III() {
    System.out.println("> ====== running " + new Object(){}.getClass().getEnclosingMethod().getName());
    
    IntegerSet setC = setC();
    IntegerSet setB = setB();
        
    System.out.println();
    System.out.println(setC.toString());
    System.out.println(setB.toString());
  
    setB.union(setC);
  
    System.out.println();
    System.out.println(setC.toString());
    System.out.println(setB.toString());
  }

}
