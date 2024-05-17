package org.example;

public class App 
{
    public static void main( String[] args ) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.print();

        System.out.println(list.get(3));  //int get(int index);
        System.out.println(list.getFirst()); // int getFirst();
        System.out.println(list.getLast()); // int getLast();
        System.out.println(list.contains(2)); // boolean contains(int data);
        // list.clear();  // void clear();
        System.out.println(list.indexOf(3)); // int indexOf(int data);
        list.removeByIndex(3); // void remove(int index);
        list.print();
        list.add(4);
        list.print();
        list.removeByData(4); // void remove(int data);
        list.print();
        list.add(4);
        list.print();
        list.removeLast();  // void removeLast();
        list.set(3,4); // void set(int index, int data);
        list.print();
        System.out.println(list.size()); // int size();
        int[] array = list.toArray(); // int[] toArray();
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list.isEmpty());


        // boolean isEmpty()


    }
}
