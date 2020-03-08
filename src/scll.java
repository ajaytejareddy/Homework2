import java.util.Scanner;
import java.util.Random;
public class scll {
    //node class is used to create nodes using node object
    public static class node {
        private int n;
        private node next;
        public node(int n, node next) {
            this.n = n;
            this.next = next;
        }

        public int getElement() {
            return n;
        }

        public node getNext() {
            return next;
        }

        public void setNum(int num){
            n = num;
        }

        public void setNext(node Next) {
            next = Next;
        }
    }
    private node head = null;
    public int size = 0;

//insertElement() is used to insert children in linked list
    public void insertElements(int size){
        this.size = size;
        for (int i=1 ; i<=size ; i++){
            if(head == null){
                head = new node(i, head);
                head.setNext(head);
            }
            else {
                node temp = head;
                while (temp.getNext() != head) {
                    temp = temp.getNext();
                }
                temp.setNext(new node(i, head));
            }
        }

    }

    //shifts head position to designated node
    public void setHead(int num){
            node temp = head;
            for(int i=0;i<size;i++){
                if(temp.getElement() == num){
                    head = temp;
                    break;
                }
                temp = temp.getNext();
            }
            //System.out.println("head set to : "+head.getElement());
            head.setNum(1);

            temp = head.getNext();
            //for loop to number in counter clockwise
            for(int i = 2; i<=size; i++){

                temp.setNum(i);
                temp = temp.getNext();
                //print();
            }

    }

    //game() counts from node to mth node and deletes mth node and links m-1 th node to m+1 th node
    //starts counting from m+1th node
    
   public int game(int m){
        node curr,currPrev;
        int n = size;

        //print();

        for (int i=1;i<n;i++){

            curr=head;
            currPrev = curr;
            for(int j=1;j<m;j++){
                //print();
                currPrev = curr;
                curr = curr.getNext();
            }
                head = curr.getNext();
                currPrev.setNext(curr.getNext());
                size--;
                //print();
            }
            return head.getElement();
    }

/*
    public void print(){
        node temp = head;
        for(int i=0;i<size;i++){
            System.out.printf("%d  ",temp.getElement());
            temp = temp.getNext();
        }
        System.out.println();
    }

*/

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random rand = new Random();
            scll LL = new scll();


            System.out.print("Enter the number of children: ");
            int n = sc.nextInt();
            LL.insertElements(n);
     //       LL.print();

            int numberOne = rand.nextInt(n) + 1;
            System.out.println("The child designated as number 1: "+numberOne);
            LL.setHead(numberOne);
       //     LL.print();

            int luckyNum;
            System.out.print("Enter the lucky number: ");
            luckyNum = sc.nextInt();

            int result =  LL.game(luckyNum);
            System.out.println("The winner is "+result);
         //   LL.print();

    }
}
