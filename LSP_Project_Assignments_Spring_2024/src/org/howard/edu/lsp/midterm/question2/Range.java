package org.howard.edu.lsp.midterm.question2;

/** 
 * Range interface defines common interface of range.
 */
public interface Range {

  /**
   * Method returns true if v is ≥ lower bound and ≤ upper bound and false otherwise
   * 
   * @param value int value to check.
   * @return boolean true if range contains value, false otherwise.
   */
  public boolean contains( int value );

  /**
   * Method returns true if the receiver contains at least one value in common with other 
   * and false otherwise
   * 
   * @param other range to be checked against this one for overlap.
   * @return boolean true if this range and other range overlap, false otherwise.
   */
  public boolean overlaps( Range other );

  /**
   * Method returns the number of integers in the range
   * 
   * @return int containing number of integers in range.
   */
  public int size();
}
