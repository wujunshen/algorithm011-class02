import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/25 17:18<br>
 */
public class AddFirstDeque {

  public static void main(String[] args) {
    Deque<String> deque = new ArrayDeque<>();
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.pop());
    }

    System.out.println(deque);

    // c
    // [c, b, a]
    // c
    // b
    // a
    // []
  }
}
