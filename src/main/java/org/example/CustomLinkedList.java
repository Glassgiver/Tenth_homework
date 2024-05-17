package org.example;

public class CustomLinkedList {
    private Node head;

    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void print() {
        if(head != null) {
            Node currentNode = head;
            System.out.print("[");
            while (currentNode.getNextNode() != null) {
                System.out.print(currentNode.getData() + ", ");
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData() + "]");
        } else {
            System.out.println("[]");
        }
    }

    public void add(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node newNode = new Node(data);
        if (index == 0) {
            newNode.setNextNode(head);
            head = newNode;
        } else {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }
        size++;
    }

    public void add(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        } else {
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(node);
        }
        size++;
    }

    public void removeByData(int data) {
        Node currentNode = head;
        if(currentNode.getData() == data) {
            removeFirst();
            return;
        }
        while (currentNode.getNextNode() != null) {
            if(currentNode.getNextNode().getData() == data) {
                break;
            }
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        size--;

    }

    public void removeByIndex(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if(index == 0){
            removeFirst();
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        size--;
    }

    public void removeFirst() {
        head = head.getNextNode();
        size--;
    }
    public void removeLast(){
        removeByIndex(size-1);
    }

    public int get(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node currentNode = head;
        if(index == 0){
            return getFirst();
        }

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
    }

    public int getFirst(){
       return head.getData();
    }

    public int getLast(){
        Node currentNode = head;
        while (currentNode.getNextNode() != null){
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
    }

    public boolean contains(int data){
        if (head == null){
            return false;
        }
        if(head.getData() == data){
            return true;
        }
        Node currentNode = head;
        while(currentNode.getNextNode() != null){
            if(currentNode.getData() == data){
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    public void clear(){
        Node currentNode = head;
        for (int i = 0; i < size-1; i++) {
            currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        }
        removeFirst();
    }

    public int indexOf(int data){
        if(head.getData() == data){
            return 0;
        }

        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if(currentNode.getData() == data){
                return i;
            }
            currentNode = currentNode.getNextNode();
        }
        return -1;
    }

    public void set(int index, int data){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if(index == 0){
            head.setData(data);
        }
        if(index == size){
            add(data);
            return;
        }

        Node currentNode = head;
        for (int i = 0; i < index-1; i++) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.getNextNode().setData(data);
    }
    public int size(){
        return this.size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        Node currentNode = head;
        int index = 0;
        while(currentNode.getNextNode() != null){
            array[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        array[index] = currentNode.getData();
        return array;
    }

    public boolean isEmpty(){
        return head == null;
    }
}
