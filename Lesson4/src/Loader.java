public class Loader {
    private static MyLinkedList<Integer> list;

    public static void main(String[] args) {
        System.out.println("LinkedDeque TEST\n");

        MyLinkedDeque<Integer> deque = new MyLinkedDeque<>();
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertRight(3);
        deque.insertRight(4);
        System.out.println(deque.toString());

        System.out.println("Left: " + deque.peekLeft());
        System.out.println("Right: " + deque.peekRight());
        deque.insertLeft(555);
        deque.insertLeft(88);
        deque.insertRight(777);
        System.out.println(deque.toString());

        System.out.println("Removed from left: " + deque.removeLeft());
        System.out.println("Removed from right: " + deque.removeRight());
        System.out.println("Removed from right: " + deque.removeRight());
        System.out.println(deque.toString());


        System.out.println("\n-------------------------------------\nLinkedList TEST\n");

        list = new MyLinkedList<>();
        list.insertFirst(9);
        list.insertFirst(8);
        list.insertFirst(7);
        list.insertFirst(6);
        list.insertFirst(5);
        showList();

        list.insertLast(11);
        list.insertLast(7);
        list.insertLast(15);
        list.insertFirst(15);
        list.insertLast(19);
        list.insertLast(30);
        showList();

        System.out.println("\nDeleted first: " + list.deleteFirst());
        showList();
        System.out.println("\nFirst element now: " + list.getFirst());

        System.out.println("\nDeleted last: " + list.deleteLast());
        showList();
        System.out.println("\nLast element now: " + list.getLast());

        System.out.println("\nChanged 4th and now we have:");
        list.set(4, 999);
        showList();

        System.out.println("\nDeleted first number \"7\"");
        list.delete(7);
        showList();

        System.out.println("\nInserted new in position \"3\"");
        list.insert(3, 111);
        showList();

        System.out.println("\nTrying to get 5th: " + list.get(5));
        System.out.println("Trying to get 10th:");
        System.out.println(list.get(10));
    }

    private static void showList() {
        StringBuilder sb = new StringBuilder("< ");
        for (Integer current : list) {
            sb.append(current).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" >");
        System.out.println(sb.toString());
    }
}
