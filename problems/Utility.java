package problems;

public class Utility {
  public static void printIntegerArray(int[] arr) {
    StringBuilder string = new StringBuilder();
    for (int e : arr) {
      string.append(e + ", ");
    }
    string.delete(string.length() - 2, string.length());
    System.out.println(string);
  }
}
