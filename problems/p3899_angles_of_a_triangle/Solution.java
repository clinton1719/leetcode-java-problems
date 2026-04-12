package problems.p3899_angles_of_a_triangle;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    solution.internalAngles(new int[] {3, 4, 5});
  }

  public double[] internalAngles(int[] sides) {
    double a = sides[0], b = sides[1], c = sides[2];

    if (a > b) {
      double t = a;
      a = b;
      b = t;
    }
    if (b > c) {
      double t = b;
      b = c;
      c = t;
    }
    if (a > b) {
      double t = a;
      a = b;
      b = t;
    }

    if (a + b <= c) return new double[0];

    double A = Math.acos((b * b + c * c - a * a) / (2 * b * c));
    double B = Math.acos((a * a + c * c - b * b) / (2 * a * c));
    double C = Math.acos((a * a + b * b - c * c) / (2 * a * b));

    double degA = Math.toDegrees(A);
    double degB = Math.toDegrees(B);
    double degC = Math.toDegrees(C);

    double[] res = new double[] {degA, degB, degC};

    return res;
  }
}
