package kit.edu.informatik.u3;

public class Main {
    public static void main(String[] args) {
        UnrolledLinkedList list1 = new UnrolledLinkedList(3);
        for (int i = 0; i < 10; i++) {
            list1.push(i);
        }
        // list1.pop();
        // System.out.println(list1.get(4));
        // System.out.println(list1.size());
        System.out.println(list1.toString("-"));

    }
}
