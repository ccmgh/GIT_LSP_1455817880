package org.howard.edu.lsp.midterm.question1;

/**
 * 
 * Class containing method to encrypt Strings.
 */
public class SecurityOps {

  /**
   * Method that encrypts a string by contacting all even indexed characters followed by
   * all odd indexed characters. All spaces are ignored and indexing ignores whitespace 
   * characters,
   * 
   * @param text string containing text to be encrypted.
   * @return String containing the result of the encryption.
   */
  public static String encrypt(String text) {
    
    StringBuilder buffer1 = new StringBuilder();
    
    StringBuilder buffer2 = new StringBuilder();

    boolean even = true;
    
    for (int i = 0; i < text.length(); ++i) {
      
      if (!Character.isWhitespace(text.charAt(i))) {

        if (even) {
          
          buffer1.append(text.charAt(i));

          even = false;
        
        } else {
          
          buffer2.append(text.charAt(i));

          even = true;
        }
      }
    }
    
    return buffer1.toString() + buffer2.toString();
  }
}
