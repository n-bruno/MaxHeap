import java.util.Scanner;
public class MaxHeapTestClient {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        
        heap.insert(1);
        heap.delete(1);
        heap.delete(22);
        
        heap.insert(2);
        heap.insert(3);
        heap.insert(42);
        heap.insert(33);
        heap.insert(11);
        heap.insert(4);
        
        heap.printArray();
        
        heap.delete(42);
        //heap.delete(1);
        
        heap.printArray();
        heap.printShowPreds();
        System.out.println("*******************************");
        System.out.println("*                             *");
        System.out.println("*     Custom manipulation     *");
        System.out.println("*                             *");
        System.out.println("*******************************");
        
        System.out.println("******Insert stuff******");
        int value;
        Scanner keyboard = new Scanner(System.in);
        value = keyboard.nextInt();
        
        MaxHeap A1 = new MaxHeap();

        while (value != 0) {
            A1.insert(value);
            value = keyboard.nextInt();
        }
        System.out.println("************************");
        A1.printShowPreds();
       
        System.out.println("******Delete stuff******");
        value = keyboard.nextInt();
        while (value != 0) {
            A1.delete(value);
            value = keyboard.nextInt();
        }
    }
}
