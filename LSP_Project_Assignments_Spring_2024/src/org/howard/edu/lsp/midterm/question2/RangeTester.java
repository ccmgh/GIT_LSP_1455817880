package org.howard.edu.lsp.midterm.question2;

/**
 * Class test harness.
 */
public class RangeTester {

  /**
   * Main method
   * 
   * @param args ignored.
   */
  public static void main(String[] args) {
    
    System.out.println("start.");

    if (!test1() ||
        !test2() ||
        !test3() ||
        !test4() ||
        !test5() ||
        !test6() ||
        !test7() ||
        !test8() ||
        !test9()) {
      
      System.err.println("failed tests");

      System.exit(1);
    }

    System.out.println("all ok");

    System.out.println("stop.");
  }	

  /**
   * Test method 1
   * @return boolean true if test passed, else false.
   */
  static boolean test1() {
    
    IntegerRange range = new IntegerRange(1, 10);
    
    if (range.size() == 10) {
      
      return true;
    }
   
    System.err.println("test1 failed");
    
    return false;
  }
  
  /**
   * Test method 2
   * @return boolean true if test passed, else false.
   */
  static boolean test2() {
    
    IntegerRange range = new IntegerRange(-10, 10);
    
    if (range.size() == 21) {
      
      return true;
    }
   
    System.err.println("test2 failed");
    
    return false;
  }

  /**
   * Test method 3
   * @return boolean true if test passed, else false.
   */
  static boolean test3() {
    
    IntegerRange range = new IntegerRange(1, 1);
    
    if (range.size() == 1) {
      
      return true;
    }
   
    System.err.println("test3 failed");
    
    return false;
  }

  /**
   * Test method 4
   * @return boolean true if test passed, else false.
   */
  static boolean test4() {
    
    IntegerRange range = new IntegerRange(1, -1);
    
    if (range.size() == -1) {
      
      return true;
    }
   
    System.err.println("test4 failed");
    
    return false;
  }

  /**
   * Test method 5
   * @return boolean true if test passed, else false.
   */
  static boolean test5() {
    
    IntegerRange range = new IntegerRange(1, 10);
    
    if (!range.contains(11)) {
      
      return true;
    }
   
    System.err.println("test5 failed");
    
    return false;
  }

  /**
   * Test method 6
   * @return boolean true if test passed, else false.
   */
  static boolean test6() {
    
    IntegerRange range = new IntegerRange(-10, 10);
    
    if (range.contains(-5)) {
      
      return true;
    }
   
    System.err.println("test6 failed");
    
    return false;
  }

  /**
   * Test method 7
   * @return boolean true if test passed, else false.
   */
  static boolean test7() {
    
    IntegerRange range1 = new IntegerRange(-10, 10);

    IntegerRange range2 = new IntegerRange(-100, 100);

    if (range1.overlaps(range2)) {
      
      return true;
    }
   
    System.err.println("test7 failed");
    
    return false;
  }

  /**
   * Test method 8
   * @return boolean true if test passed, else false.
   */
  static boolean test8() {
    
    IntegerRange range1 = new IntegerRange(5, 10);

    IntegerRange range2 = new IntegerRange(19, 12);

    if (!range2.overlaps(range1)) {
      
      return true;
    }
   
    System.err.println("test8 failed");
    
    return false;
  }

  /**
   * Test method 9
   * @return boolean true if test passed, else false.
   */
  static boolean test9() {
    
    IntegerRange range1 = new IntegerRange(-1, 2);

    IntegerRange range2 = new IntegerRange(20, 20);

    if (!range1.overlaps(range2)) {
      
      return true;
    }
   
    System.err.println("test9 failed");
    
    return false;
  }

}
