package org.howard.edu.lsp.midterm.question2;

/**
 * Class implementing an integer range. If implements the Range interface.
 */
public class IntegerRange implements Range {

  /**
   * Constructor
   * 
   * @param lower int containing lower value of range.
   * @param upper int containing upper value of range.
   */
  public IntegerRange(int lower, int upper) {
    
    _lower = lower;
    
    _upper = upper;
    
    _valid = _upper >= _lower;
  }
 
  /**
   * Returns true if v is ≥ lower bound and ≤ upper bound and false otherwise
   *  
   * @param value int value to check.
   * @return boolean true if range contains value, false otherwise.
   */
  public boolean contains( int value ) {

    if (!_valid) {
      
      return false;
    }

    return value >= _lower && value <= _upper;
  }

  /**
   * Returns true if the receiver contains at least one value in common with other,
   * and false otherwise.
   * 
   * @param other range to be checked against this one for overlap.
   * @return boolean true if this range and other range overlap, false otherwise.
   */
  public boolean overlaps( Range other ) {

    if (!_valid ||
        !(other instanceof IntegerRange)) {
      
      return false;
    }

    IntegerRange range = (IntegerRange) other;
    
    if (_lower <= range._lower &&
        _upper >= range._lower) {
    
      return true;
    }
  
    if (_lower >= range._lower &&
        _lower <= range._upper) {
    
      return true;
    }
  
    return false;
  }

  /**
   * Returns the number of integers in the range. If invalid range returns -1;
   * 
   * @return int containing the number of integers in the range. If range is invalid it returns -1;
   */
  public int size() {

    if (!_valid) {
    
      return -1;
    }
    
    return (_upper - _lower) + 1;
  }
  
  /**
   * Lower value in range.
   */
  private int _lower;

  /**
   * Upper value in range.
   */
  private int _upper;
  
  /**
   * 
   * Boolean indicating whether range is valid.
   */
  private boolean _valid;
}
