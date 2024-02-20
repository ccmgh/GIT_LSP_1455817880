package org.howard.edu.lsp.assignment4;

/**
 * This class is a custom exception for use in
 * {@link org.howard.edu.lsp.assignment4.IntegerSet}.
 * 
 * @author Claude Cockfield
 * @version %I%, %G%
 * @since 0.1
 */
public class IntegerSetException extends Exception {

  /**
   * Serialization UID set to default value.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor method.
   * 
   * @param message exception message parameter.
   */
  public IntegerSetException(String message) {
    super(message);
  }
}
