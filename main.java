//Реализовать поворот односвязанного списка

import java.util.Iterator;

public class main

{
    public static void main(String[] args) {
        SingleLinkList<Data> listValues = new SingleLinkList<>();

        listValues.addToEnd(new Data(87));
        listValues.addToEnd(new Data(6));
        listValues.addToEnd(new Data(90));

        for(Data contact: listValues) {
            System.out.println(contact);
        }

        listValues.reverse();

        System.out.println("Список после поворота");

        for(Data dataV: listValues) {
            System.out.println(dataV);
        }
    }

    static class Data {
        int value;

        public Data(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value = " + value;
        }
    }

    public static class SingleLinkList<T> implements Iterable<T> {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T> {
            T data;
            ListItem<T> next;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addToEnd(T item) {
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;
            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        public void reverse() {
            if (!isEmpty() && head.next != null) {
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}