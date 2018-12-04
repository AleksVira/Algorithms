import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {

    public static void main(String[] args) throws IOException {

        MyDequeArray<Integer> myDeque = new MyDequeArray<>();
        myDeque.insertRight(7);
        System.out.println(myDeque);
        myDeque.insertRight(6);
        myDeque.insertRight(8);
        myDeque.insertRight(9);
        System.out.println(myDeque);
        myDeque.insertLeft(5);
        System.out.println(myDeque);
        myDeque.insertLeft(4);
        System.out.println(myDeque);
        myDeque.insertLeft(3);
        System.out.println(myDeque);
        myDeque.insertLeft(2);
        myDeque.insertRight(99);
        System.out.println(myDeque);
        System.out.println(myDeque.peekRight());
        System.out.println(myDeque.peekLeft());
        myDeque.removeLeft();
        myDeque.removeLeft();
        myDeque.removeLeft();
        System.out.println(myDeque);
        myDeque.removeLeft();
        System.out.println(myDeque);

        myDeque.removeRight();
        myDeque.removeRight();
        myDeque.removeRight();
        System.out.println(myDeque);

        System.out.println("---------------------");
        stackReverseLine();

    }


    private static void stackReverseLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (true) {
            System.out.println("Enter new string: ");
            input = reader.readLine();
            if (input.equals("")) {
                break;
            }
            System.out.println("Source string: " + input);
            String result = reverseLine(input);
            System.out.println("Reversed line: " + result);
        }
        reader.close();
        System.out.println("Bye!");
    }

    private static String reverseLine(String input) {
        MyArrayStack<Character>  myStack = new MyArrayStack<>();
        for (int i = 0; i < input.length(); i++) {
            myStack.push(input.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(myStack.pop());
        }
        return sb.toString();
    }
}
