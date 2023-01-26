package LA1Q1;

import java.io.NotActiveException;

public class SinglyLinkedList<T> {
        //define fields
        private Node<T> head;
        private Node<T> tail;
        private int size;



        //define constructor
        public SinglyLinkedList(Node<T> h, Node<T> t , int s){
            head = h;
            tail = t;
            size = s;
        }

        public SinglyLinkedList(){}

        //define methods
        public void enqueueAtTail(T t){
                addLast(t);
        }

        public T removeFirst(){ //removes head, returns it, assigns next element as head
                if (isEmpty()){ //check if empty
                        return null;}
                T answer = head.getElement();
                head = head.getNext();
                size--;
                if(size==0){  //set new tail if there are 0 nodes
                        tail = null;}
                return answer; //return previous head
        }

        public T popFromTail(){//return popped last value
                return removeLast();
        }

        public T dequeueAtHead(){
                if (head == tail){
                        System.out.println("Queue is empty");
                }
                return removeFirst();//do we need? no
        }

        public int searchStack(T t){ //searched from headside, returns integer value based on position of element
                Node<T> current = head;
                int index = 0;
                while(current.getElement() != null){
                        if (t.equals(current.getElement())){
                                return (index+1);
                        } else if (current.getNext() == null){
                                break;
                        }else{
                        index++;
                        current = current.getNext();}
                }
                return 0;
        }


        public void addFirst(T t){ //adds element e to the front of the list
                head = new Node<T>(t, head); //create and link new node
                if(size==0){
                        tail=head;}
                size++;
        }

        public Boolean isEmpty(){ //returns true if the list is empty.
            if(size == 0) {
                    return true;
            }
            return false;
        }

        public int getSize(){
            return size;
        }

        public T removeLast() { //removes tail, returns it, assigns preceeding element as head
                T last = tail.getElement();
                if (size == 0) {//check if empty
                        return null;}
                tail = head;
                size--;
                for (int i = 0; i < size - 1; i++) {
                        tail = tail.getNext();}//move up the tail of the list
                if (size == 0) {//check if empty after removing
                        tail = null;}
                return last;
        }

        @Override
        public String toString() { //return the list as a string
            if (size == 0){//empty string
                    return "[]";
            }
            String list = String.format("[");
            int counter = size;
            Node<T> current = head;
            while (counter >= 1){
                list += String.format(current.getElement()+", "); //add elements to the toString list
                if (current.getNext()!= null){
                        current = current.getNext(); //move current to the next node
                }
                counter--;
            }
            list += String.format("\b\b]\n");
            return list;
        }

        public void pushAtHead(T t){ //realized linked list is a stack
                addFirst(t);
        }

        public void pushAtTail(T t){
                addLast(t);
        }

        public void addLast(T t){
                Node<T> newest = new Node<T>(t, null);
                if (size == 0) //if list is empty
                        head = newest;//added value becomes head
                else
                        tail.setNext(newest);//otherwise null after tail becomes new tail
                tail = newest;
                size++;
        }

        public T popFromHead(){//pops and returns first element from the top of the stack
                return removeFirst(); //return previous head
        }


}
