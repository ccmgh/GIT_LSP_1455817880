package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements a mathematical set of {@link java.lang.Integer}.
 * Stored values ate unique. 
 * Internally values are maintained in sorted order as that makes 
 * insert, delete, lookup and set level operations far cheaper 
 * algorithmically. 
 * 
 * @author Claude Cockfield
 * @version %I%, %G%
 * @since 0.1
 */
public class IntegerSet {

  /**
   * {@link java.util.ArrayList} collection used to store set values.
   */
  private List<Integer> _set = new ArrayList<Integer>();

  /**
   * Default constructor for {@link org.howard.edu.lsp.assignment4.IntegerSet}.
   */
  public IntegerSet() {
  }

  /**
   * Constructor to construct this collection using am {@link java.util.ArrayList} of values. 
   * NOTE: As there is no guarantee that the parameter set has unique values the list
   * is filtered and duplicate values removed.
   * 
   * @param set is am array list containing data to be imported into this
   *            IntegerSet.
   */
  public IntegerSet(ArrayList<Integer> set) {
    this._set = set.stream().sorted().distinct().collect(Collectors.toList());
  }

  /**
   * Adds an item to the set or does nothing if it already there.
   * 
   * @param item value to be added to the set.
   */
  public void add(int item) {
    int position = Collections.binarySearch(_set, item);
    if (position < 0) {
      _set.add(Math.abs(position) - 1, item);
    }
  }

  /**
   * Clears the set by removing all elements.
   */
  public void clear() {
    this._set.clear();
  };

  /**
   * Performs a set complement operation between this set and the parameter set. 
   * This set is altered contain only the elements from the parameter set which 
   * were not in this set (prior to this operation). 
   *
   * @param setB IntegerSet for complement with this set.
   */
  public void complement(IntegerSet setB) {

    if (this == setB ||
        setB._set.isEmpty()) {
      this._set.clear();
      return;
    }

    if (this._set.isEmpty()) {
      this._set.addAll(setB._set);
      return;
    }

    List<Integer> this_copy = this._set;
    
    this._set = new ArrayList<Integer>();
    
    int i = 0;
    int iB = 0;
    
    while (iB < setB._set.size() && i < this_copy.size()) {

      if (setB._set.get(iB) < this_copy.get(i)) {

        while (iB < setB._set.size()) {

          if (setB._set.get(iB) == this_copy.get(i)) {

            iB++;

          } else if (setB._set.get(iB) > this_copy.get(i)) {

            break;

          } else {

            this._set.add(setB._set.get(iB++));
          }
        }
      } else if (setB._set.get(iB) > this_copy.get(i)) {
        i++;
      } else {
        iB++;
      }
    }    
    
    while (iB < setB._set.size()) {
      this._set.add(setB._set.get(iB++));
    }
  }

  /**
   * Returns true if the set contains the value in the parameter 'value', otherwise false.
   * 
   * @param value contains the value to be checked.
   * @return boolean the result of this function.
   */
  public boolean contains(int value) {
    return Collections.binarySearch(_set, value) >= 0;
  }

  /**
   * Performs a set difference operation between this set and the parameter set. 
   * This set is adjusted by removing all values that are in the 
   * parameter set.
   *
   * @param setB IntegerSet for difference with this set.
   */
  public void diff(IntegerSet setB) {
    
    if (this._set.isEmpty() ||
        setB._set.isEmpty()) {
      return;
    }

    if (this == setB) {
      this._set.clear();
      return;
    }

    int i = 0;
    int iB = 0;

    while (i < _set.size() && iB < setB._set.size()) {

      if (_set.get(i) < setB._set.get(iB)) {

        while (i < _set.size()) {

          if (_set.get(i) == setB._set.get(iB)) {

            _set.remove(i);

          } else if (_set.get(i) > setB._set.get(iB)) {

            break;

          } else {

            i++;
          }
        }
      } else if (_set.get(i) > setB._set.get(iB)) {
        iB++;
      } else {
        _set.remove(i);
      }
    }
  }

  /**
   * Returns true if the this set and the parameter object are equal, false otherwise. 
   * Two sets are equal if they contain all of the same values in ANY order. 
   * This overrides the equals method from the Object class.
   * 
   * @param o contains object to compare to this collection.
   * @return boolean true if sets are equal, false otherwise.
   */
  public boolean equals(Object o) {
    if (!(o instanceof IntegerSet)) {
      return false;
    }

    IntegerSet other = (IntegerSet) o;

    if (other.isEmpty() && this.isEmpty()) {
      return true;
    }

    if (other._set.size() != this._set.size()) {
      return false;
    }

    for (int i = 0; i < this.length(); i++) {
      if (other._set.get(i) != this._set.get(i)) {
        return false;
      }
    }

    return true;
  };

  /**
   * Performs a set intersection operation between this set and the 
   * parameter set. This set is adjusted by removing all values which 
   * are not in the parameter set.
   *
   * @param setB IntegerSet for intersection with this set.
   */
  public void intersect(IntegerSet setB) {
    
    if (this == setB ||
        this._set.isEmpty()) {
      return;
    }

    if (setB._set.isEmpty()) {
      this._set.clear();;
      return;
    }

    int i = 0;
    int iB = 0;

    while (i < _set.size() && iB < setB._set.size()) {

      if (_set.get(i) < setB._set.get(iB)) {

        while (i < _set.size()) {

          if (_set.get(i) == setB._set.get(iB)) {

            i++;

          } else if (_set.get(i) > setB._set.get(iB)) {

            break;
            
          } else {
        
            _set.remove(i);
          }
        }
      } else if (_set.get(i) > setB._set.get(iB)) {
        iB++;
      } else {
        i++;
      }
    }

    while (i < this._set.size()) {
      this._set.remove(_set.size() - 1);
    }
  }

  /**
   * Returns true if the set is empty, false otherwise.
   * 
   * @return boolean value indicating whether set is empty.
   */
  public boolean isEmpty() {
    return _set.isEmpty();
  }

  /**
   * Returns the largest item in the set;
   * Throws an  {@link org.howard.edu.lsp.assignment4.IntegerSetException} 
   * if the set is empty.
   * 
   * @return int largest value in the set.
   * @throws IntegerSetException if set is empty.
   */
  public int largest() throws IntegerSetException {
    if (this.isEmpty()) {
      throw new IntegerSetException("called largest on an empty set.");
    }
    return _set.get(_set.size() - 1);
  };

  /**
   * Returns the length (aka size) of the set.
   * 
   * @return int value containing the set length value.
   */
  public int length() {
    return _set.size();
  }

  /**
   * Removes an item from the set or does nothing if item is not in set.
   * 
   * @param item the value of the item to be removed.
   */
  void remove(int item) {
    if (!_set.isEmpty()) {
      int index = Collections.binarySearch(_set, item);
      if (index >= 0) {
        _set.remove(index);
      }
    }
  }

  /**
   * Returns the smallest item in the set; 
   * Throws an {@link org.howard.edu.lsp.assignment4.IntegerSetException} 
   * if the set is empty.
   * 
   * @return int smallest value in the set.
   * @throws IntegerSetException if set is empty.
   */
  public int smallest() throws IntegerSetException {
    if (this.isEmpty()) {
      throw new IntegerSetException("called smallest on an empty set.");
    }
    return _set.get(0);
  }

  /**
   * Returns a {@link java.lang.String} representation of this IntegerSet object.
   * This overrides the toString method of the {@link java.lang.Object} class.
   * 
   * @return String containing a string representation of the set.
   */
  public String toString() {
    StringBuilder buffer = new StringBuilder();
  
    buffer.append("{");
    
    for (Integer item : _set) {
      if (buffer.length() > 1) {
        buffer.append(',');
      }
      buffer.append(item);
    }
    
    buffer.append("}");
  
    return buffer.toString();
  }

  /**
   * Performs a set union operation between this set and the parameter set. 
   * This set is  adjusted by adding all values in the parameter set 
   * which are not already in this objects data.
   * 
   * @param setB IntegerSet for union with this set.
   */
  public void union(IntegerSet setB) {

    if (this == setB ||
        setB._set.isEmpty()) {
      return;
    }

    if (this._set.isEmpty()) {
      this._set.addAll(setB._set);
      return;
    }

    int i = 0;
    int iB = 0;

    while (i < _set.size() && iB < setB._set.size()) {

      if (_set.get(i) < setB._set.get(iB)) {

        while (i < _set.size()) {

          if (_set.get(i) == setB._set.get(iB)) {

            break;

          } else if (_set.get(i) > setB._set.get(iB)) {

            _set.add(i, setB._set.get(iB++));

            break;
          }
          
          i++;
        }
      } else if (_set.get(i) > setB._set.get(iB)) {

        _set.add(i++, setB._set.get(iB++));

      } else {
        
        iB++;
      }
    }

    while (iB < setB._set.size()) {
      this._set.add(_set.size(), setB._set.get(iB++));
    }
  }

}
