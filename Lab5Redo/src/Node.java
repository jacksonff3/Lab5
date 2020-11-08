public class Node<X> {                  //<X> is a generic type, doesn't tie us down to just string, int or double
    private X data;
    private Node next;

    public Node(X data) {

        this.data = data;

    }

    public void setData(X data) {

        this.data = data;

    }

    public void setNext(Node next) {

        this.next = next;

    }

    public X getData() {

        return data;

    }

    public Node getNext() {

        return next;

    }



}