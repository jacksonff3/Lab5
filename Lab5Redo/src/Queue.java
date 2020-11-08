public class Queue {

    private Node<String> head;
    private Node<String> tail;
    private int size;

    public boolean isEmpty() {

        return head == null;                //isEmpty checks if the Linkedlist is empty, if it's empty we can conclude the head is also empty

    }

    public void append(String data) {      //This method adds nodes to the queue

        Node node = new Node(data);       //Creates a new node

        if(tail != null) {

            tail.setNext(node);

        }

        tail = node;                  //If the current tail is NOT empty set the new node we made above as the tail

        if(head == null) {

            head = node;            //If the current head is empty, make the new node the head

        }

        size++;                    //Size allows us to keep track of the size of the LinkedList or in this case the Queue
    }

    public void append2(Song song) {      //This method adds nodes to the queue (used for song objects/ top was used for strings)

        Node node = new Node(song);       //Creates a new node

        if(tail != null) {

            tail.setNext(node);

        }

        tail = node;                  //If the current tail is NOT empty set the new node we made above as the tail

        if(head == null) {

            head = node;            //If the current head is empty, make the new node the head

        }

        size++;                    //Size allows us to keep track of the size of the LinkedList or in this case the Queue
    }

    public String peek() {

        return head.getData();   //Peak allows us to retrieve the data that's currently in the head

    }

    public void remove() {

        String data = head.getData();
        head = head.getNext();            //Makes the head of the Queue the next node

        if(head == null) {               //If the head is empty that means the tail is also empty

            tail = null;

        }

        size--;                       //Size keeps track of the size of queue since we're removing the size decreases

    }

    public String getHead() {

        return head.getData();       //Gets the value of the head node

    }

    public String getTail() {

        return tail.getData();     //Gets the data of the tail node

    }

    public int getSize() {        //Gets the size of the Queue that we've been keeping track of above

        return size;

    }


}