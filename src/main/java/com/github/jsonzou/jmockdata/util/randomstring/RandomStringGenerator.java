package com.github.jsonzou.jmockdata.util.randomstring;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Generator of random string.
 * 
 * <p>
 * This class doesn't generate secure strings. So please use SecureRandom class if you want to use
 * with such a purpose.
 * 
 * @author moznion
 *
 */
public class RandomStringGenerator {
  private int numOfUpperLimit;
  private final Map<String, RandomLetterPicker> userDefinedPickers;
  private final Random random;
  private final RandomLetterPickers pickers;

  private static final int DEFAULT_NUM_OF_UPPER_LIMIT = 10;

  /**
   * Instantiate generator with a default number of upper limit for regex quantifiers (for example
   * {@code *}, {@code +} and etc; default value is 10) and a default instance of Random.
   */
  public RandomStringGenerator() {
    this(new Random(), DEFAULT_NUM_OF_UPPER_LIMIT);
  }

  /**
   * Instantiate generator with a number of upper limit for regex quantifiers (for example {@code *}
   * , {@code +} and etc) and a default instance of Random.
   * 
   * @param numOfUpperLimit Number of upper limit for quantifiers
   */
  public RandomStringGenerator(int numOfUpperLimit) {
    this(new Random(), numOfUpperLimit);
  }

  /**
   * Instantiate generator with a default number of upper limit for regex quantifiers (for example
   * {@code *}, {@code +} and etc; default value is 10) and an instance of Random.
   *
   * @param random Instance of Random
   */
  public RandomStringGenerator(Random random) {
    this(random, DEFAULT_NUM_OF_UPPER_LIMIT);
  }

  /**
   * Instantiate generator with a number of upper limit for regex quantifiers (for example {@code *}
   * , {@code +} and etc) and an instance of Random.
   *
   * @param random Instance of Random
   * @param numOfUpperLimit Number of upper limit for quantifiers
   */
  public RandomStringGenerator(Random random, int numOfUpperLimit) {
    this.numOfUpperLimit = numOfUpperLimit;
    this.random = random;
    this.userDefinedPickers = new HashMap<>();
    this.pickers = new RandomLetterPickers(this.random);
  }

  /**
   * Generate random string from pattern.
   * 
   * <p>
   * You can use following characters as pattern.
   * <ul>
   * <li>{@code c} : Any Latin lower-case character</li>
   * <li>{@code C} : Any Latin upper-case character</li>
   * <li>{@code n} : Any digit {@code [0-9]}</li>
   * <li>{@code !} : A symbol character {@code [~`!@$%^&*()-_+= []|\:;"'.<>?/#,]}</li>
   * <li>{@code .} : Any of the above</li>
   * <li>{@code s} : A "salt" character {@code [A-Za-z0-9./]}</li>
   * <li>{@code b} : An ASCIII character which has code from 0 to 255</li>
   * </ul>
   * 
   * <p>
   * e.g.
   * 
   * <pre>
   * <code>
   * RandomStringGenerator generator = new RandomStringGenerator();
   * 
   * // generates random string (e.g. "aB4@X.Ç")
   * String randomString = generator.generateFromPattern(&quot;cCn!.sb&quot;);
   * </code>
   * </pre>
   * 
   * @param pattern Pattern string
   * @return Random string which is generated according to pattern
   */
  public String generateFromPattern(final String pattern) {
    char patternCharacter;
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<pattern.length();i++){
      patternCharacter = pattern.charAt(i);
      RandomLetterPicker picker;
      switch (patternCharacter) {
        case 'c':
          picker = pickers.getLowerCase();
          break;
        case 'C':
          picker = pickers.getUpperCase();
          break;
        case 'n':
          picker = pickers.getDigit();
          break;
        case '!':
          picker = pickers.getSymbol();
          break;
        case '.':
          picker = pickers.getAny();
          break;
        case 's':
          picker = pickers.getSalt();
          break;
        case 'b':
          picker = pickers.getBinary();
          break;
        default:
          throw new RuntimeException("Detected invalid pattern character: " + patternCharacter);
      }
      sb.append(picker.pickRandomLetter());
    }
    return sb.toString();
  }

  /**
   * Generate random string from regular expression.
   * 
   * <p>
   * You can use following meta characters as regex.
   * <ul>
   * <li>{@code \w} : Alphanumeric + "_" {@code [A-Za-z0-9_]}</li>
   * <li>{@code \d} : Digits {@code [0-9]}</li>
   * <li>{@code \W} : Printable characters other than those in \w</li>
   * <li>{@code \D} : Printable characters other than those in \d</li>
   * <li>{@code \s} : Whitespace characters {@code [ \t]}</li>
   * <li>{@code \S} : Printable characters</li>
   * <li>{@code .} : Printable characters</li>
   * <li>{@code []} : Character classes (Example of usage {@code [a-zA-Z]})</li>
   * <li><code>{}</code>: Repetition</li>
   * <li>{@code *} : Same as {0,}</li>
   * <li>{@code ?} : Same as {0,1}</li>
   * <li>{@code +} : Same as {1,}</li>
   * </ul>
   * 
   * <p>
   * e.g.
   * 
   * <pre>
   * <code>
   * RandomStringGenerator generator = new RandomStringGenerator();
   * 
   * // generates random string (e.g. "a5B123 18X")
   * String randomString = generator.generateByRegex("\\w+\\d*\\s[0-9]{0,3}X");
   * </code>
   * </pre>
   * 
   * @param regex Pattern based on regular expression
   * @return Random String
   */
  public String generateByRegex(final String regex) {
    String expanded = new RegexNormalizer(numOfUpperLimit, random).normalizeQuantifiers(regex);

    final String[] regexCharacters = expanded.split("");
    final int length = regexCharacters.length;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      String character = regexCharacters[i];
      RandomLetterPicker picker = null;
      String candidateCharacter = null;
      switch (character) {
        case "\\":
          try {
            character = regexCharacters[++i];
          } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Detected invalid escape character");
          }

          switch (character) {
            case "w":
              picker = pickers.getWord();
              break;
            case "d":
              picker = pickers.getDigit();
              break;
            case "W":
              picker = pickers.getNotWord();
              break;
            case "D":
              picker = pickers.getNotDigit();
              break;
            case "s":
              picker = pickers.getSpace();
              break;
            case "S":
              picker = pickers.getAny();
              break;
            default:
              candidateCharacter = character;
          }
          break;
        case "[":
          try {
            UserDefinedLetterPickerScanner.ScannedUserDefinedPicker scannedUserDefinedPicker =
                UserDefinedLetterPickerScanner.scan(regexCharacters, i);
            String key = scannedUserDefinedPicker.getKey();
            i = scannedUserDefinedPicker.getCursor();

            if (userDefinedPickers.get(key) == null) {
              RandomLetterPicker userDefinedPicker = RandomLetterPicker
                  .constructByCharacterRange(scannedUserDefinedPicker.getBounds());
              userDefinedPickers.put(key, userDefinedPicker);
            }

            picker = userDefinedPickers.get(key);
          } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Occurs parsing error");
          }
          break;
        case ".":
          picker = pickers.getAny();
          break;
        default:
          candidateCharacter = character;
      }

      int repetitionNum = 1;
      if (i + 1 < length) {
        String nextCharacter = regexCharacters[i + 1];
        if (nextCharacter.equals("{")) {
          int j = i + 1;
          StringBuilder sbForQuantifier = new StringBuilder();
          try {
            while (!(nextCharacter = regexCharacters[++j]).equals("}")) {
              sbForQuantifier.append(nextCharacter);
            }
            try {
              repetitionNum = Integer.parseInt(sbForQuantifier.toString(), 10);
              i = j;
            } catch (RuntimeException e) {
              // do nothing
            }
          } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
          }
        }
      }

      if (picker != null) {
        for (int j = 0; j < repetitionNum; j++) {
          sb.append(picker.pickRandomLetter());
        }
      } else if (candidateCharacter != null) {
        for (int j = 0; j < repetitionNum; j++) {
          sb.append(candidateCharacter);
        }
      } else {
        throw new RuntimeException("Occurs parsing error");
      }
    }

    return sb.toString();
  }

  /**
   * Get number of upper limit for regex quantifiers, for example {@code *}, {@code +} and etc.
   * 
   * @return Number of upper limit for quantifiers
   */
  public int getNumOfUpperLimit() {
    return numOfUpperLimit;
  }

  /**
   * Set number of upper limit for regex quantifiers, for example {@code *}, {@code +} and etc.
   * 
   * @param numOfUpperLimit Number of upper limit for quantifiers
   */
  public void setNumOfUpperLimit(int numOfUpperLimit) {
    this.numOfUpperLimit = numOfUpperLimit;
  }
}
