package kit.edu.informatik.u3.a;

/**
 * Class for Task B
 * @author ugpsy
 * @version 1.0
 */
public class UnrolledLinkedList {
    private final int arraySize;

    private class ListCell {
        private int[] array;
        private ListCell prev;
        private ListCell next;
        private ListCell(int[] a, ListCell p, ListCell n) {
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
            // return true;
        } else if (this.last.array.length == this.arraySize) { // create new array if the last array is full.
            this.last.next = newListCell;
            this.last = newListCell;
            // return true;
        } else { // add to the last list whose size is under the given maximum array size.
            this.last.array = extendArray(this.last.array, element);
            // return false;
        }
        return true;
    }

    public boolean pop() {
        if (this.last.array.length == 1) {
            this.last = this.last.prev;
            return true;
        }
        else {
            this.last.array = shrinkArray(this.last.array);
            return false;
        }
    }

    public int get(int i) {
        ListCell cell = this.first;
        int index = 0;
        while (cell != null) {
            for (int element : cell.array) {
                if (index == i) {
                    return element;
                }
                index++;
            }
            cell = cell.next;
        }
        return -1;
    }

    public int size() {
        ListCell cell = this.first;
        int index = 0;
        while (cell != null) {
            index += cell.array.length;
            cell = cell.next;
        }
        return index;
    }

    public String toString(String separator) {
        String result = "";
        ListCell cell = this.first;
        while (cell != null) {
            for (int element:
                    cell.array) {
                result += element + separator;
            }
            cell = cell.next;
        }
        return result.substring(0, result.length() - 1);
    }

    private int[] extendArray(int[] oldArray, int newElem) {
        int[] extendedArray = new int[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            extendedArray[i] = oldArray[i];
        }
        extendedArray[oldArray.length] = newElem;
        return extendedArray;
    }

    private int[] shrinkArray(int[] oldArray) {
        int[] extendedArray = new int[oldArray.length - 1];
        for (int i = 0; i < oldArray.length - 1; i++) {
            extendedArray[i] = oldArray[i];
        }
        return extendedArray;
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
