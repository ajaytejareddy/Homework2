import java.util.Scanner;
//linkedList Class is used to create singleLinkedList(OBJECT)
public class linkedList {
    //Node class is used to create nodes in single linked list with data and next fields
    private static class Node{
    String data;
    public Node next;
    public Node(String e,Node n){
        data = e;
        next = n;
    }
    //getElements() return data in node
    public String getElement(){
        return data;
    }
    //getNext() returns next node reference
    public Node getNext(){
        return next;
    }
    //setNext(Node n) methods sets reference of next Node to current Node next field
    public void setNext(Node n){
        next = n;
    }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;
    //insertElement(String ) methods inserts Node into singleLinkedList in ascending order of alphabets
    public void insertElement(String e){
        //adds elements when size is null
        if (size == 0){
            head = new Node(e,head);
            tail = head;
            size++;
            return;
        }


        Node newest=new Node(e,null);
        Node tempprev = head;
        Node temp = head;

        //loop to  insert new node in List in ascending order
        for (int i=0;i<size;i++){
            //String1.compareTo(String) compares strings and returns 1 if String1 is greater than String
            if (temp.getElement().compareTo(e)>0){
                newest.setNext(temp);
                if (temp == head)
                    head = newest;
                else
                    tempprev.setNext(newest);
                size++;
                return;
            }
            //string e is equals a string in linkedList
            else if (temp.getElement().compareTo(e)==0) {
                tempprev = temp;
                temp = temp.getNext();
                newest.setNext(temp);
                tempprev.setNext(newest);
                if(tail==tempprev)
                    tail = newest;
                size++;
                return;

            }
            else {
                tempprev = temp;
                temp = temp.getNext();
            }
        }
        if (tail.getElement().compareTo(e)<0){
            tail.setNext(newest);
            tail=newest;
            size++;
        }

    }
    //display() method prints
    public void display(){
        Node temp = head;
        System.out.print("The elements of the linked list: ");
        while (temp.getNext()!=null){
            System.out.print(temp.getElement()+" \t");
            temp = temp.getNext();
        }
        System.out.println(temp.getElement());

    }

    public static void main(String[] args) {
        //linkedList object l is created
        linkedList l= new linkedList();
        int listSize;

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the number of nodes of the singly linked list: ");
        listSize = sc.nextInt();

        //inserts elements into linkedList l using insertElement() method
        System.out.println("Enter the elements of the linked list:");
        for (int i=0;i<=listSize ; i++){
            l.insertElement(sc.nextLine());
        }
        //PRINTS LINKEDLIST
        l.display();
    }

}
