import java.util.Scanner;
public class SingleLinkedList
{

    private static class Node{
        int data;
        public Node next;
        public Node(int e,Node n){
            data = e;
            next = n;
        }
        //getElements() return data in node
        public int getElement(){
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

    public void AddFirst(int e){
        head = new Node(e,head);
        size++;
    }
    public void AddLast(int e){
    Node tmp = new Node(e,null);
    tail.setNext(tmp);
    tail=tmp;
    size++;
    }

    public void insert(int e){
    if(size==0){
    head = new Node(e,null);
    tail = head;
    size++;
    return ;}

    if(head.getElement()<e){
    AddFirst(e);
    }
    else if(tail.getElement()>e){
    AddLast(e);
    }
    else{
    Node tempPrev = head;
    Node temp = head.getNext();
    for(int i=0;i<size-1;i++){
    if(temp.getElement()<e){
    Node newnode = new Node(e,temp);
    tempPrev.setNext(newnode);
    size++;
    return;
    }
    tempPrev=temp;
    temp=temp.getNext();
    }
    }
    }

    public void print(){
    System.out.print("The elements of the linked list: ");
    Node temp = head;
    for(int i=0;i<size;i++){
    System.out.print(temp.getElement()+"  ");
    temp = temp.getNext();
    }
    }

       public static void main(String[] args)
       {
        SingleLinkedList scll = new SingleLinkedList();
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the number of nodes of the singly linked list: ");
        n = sc.nextInt();
        System.out.println("Enter the elements of the linked list:");
        for(int i=0;i<n;i++){
        scll.insert(sc.nextInt());
        }
        scll.print();
       }
         }
