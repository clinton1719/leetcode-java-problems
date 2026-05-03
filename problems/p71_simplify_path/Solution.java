package problems.p71_simplify_path;

import java.util.Stack;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.simplifyPath("/home/user/Documents/../Pictures"));
  }

  public String simplifyPath(String path) {
    String[] components = path.split("/");
    Stack<String> st = new Stack<>();

    for (String comp : components) {
      if (comp.equals("") || comp.equals(".")) {
        continue;
      }

      if (comp.equals("..")) {
        if (!st.isEmpty()) {
          st.pop();
        }
      } else {
        st.push(comp);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!st.isEmpty()) {
      sb.insert(0, "/" + st.pop());
    }

    return sb.length() == 0 ? "/" : sb.toString();
  }
}
