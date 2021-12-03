package kit.edu.informatik.u3.a;

public class UnrolledLinkedList {
    private int arraySize;

    private class ListCell {
        int[] array;
        ListCell prev;
        ListCell next;

        ListCell(int[] a, ListCell p, ListCell n) {
            this.array = a;
            this.prev = p;
            this.next = n;
        }


    }
    private ListCell first, last;
    public UnrolledLinkedList(int arraySize) {
        this.arraySize = arraySize;
        this.first = this.last = null;
    }

    public boolean push(int element) {
        ListCell newListCell = new ListCell(new int[] {element}, this.last, null);

        if (this.first == null) { // add to empty list.
            this.first = this.last = newListCell;

        } else if (this.last.array.length == this.arraySize) { // create new array if the last array is full.
            this.last.next = newListCell;
            this.last = newListCell;


        } else { // add to the last list whose size is under the given maximum array size.
            int[] temp = this.last.array;
            this.last.array = new int[temp.length + 1];
            System.arraycopy(temp, 0, this.last.array, 0, temp.length);
            this.last.array[temp.length] = element;
        }

        printList(this.last.array);
        return true;
    }

    public boolean pop() {
        System.out.println();
        if (this.last.array.length == 1) {
            this.last = this.last.prev;
            return true;
        }
        else {
            int[] temp = this.last.array;
            this.last.array = new int[temp.length - 1];
            System.arraycopy(temp, 0, this.last.array, 0, temp.length - 1);
            return false;
        }
        /*
        printList(this.last.prev.prev.array);
        printList(this.last.prev.array);
        printList(this.last.array);
        return true; */
    }

    public int get(int i) {
        int index = 0;
        var cell = this.first;
        while (cell != null) {
            for (int elem:
                 cell.array) {

                if (elem == i) { return index; }
                index += 1;
            }
            cell = cell.next;
        }
        return -1;
    }

    public int size() {
        var cell = this.first;
        int index = 0;
        while (cell.next != null) {
            index += arraySize;
            cell = cell.next;
        }
        index += this.last.array.length;
        return index;
    }

    public String toString(String separator) {
        String result = "";
        var cell = this.first;
        while (cell != null) {
            for (int elem:
                    cell.array) {
                result += elem + separator;
            }
            cell = cell.next;
        }
        return result.substring(0, result.length() - 1);
    }
    private void printList(int[] array) {
        for (int elem:
             array) {
            System.out.print(elem);
            System.out.print(" ");
        }
        System.out.println();
    }

}
