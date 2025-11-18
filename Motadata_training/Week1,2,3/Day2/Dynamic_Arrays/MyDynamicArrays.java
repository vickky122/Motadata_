import java.util.*;

/* Concept: Dynamic arrays, resizing.
Example: Video streaming buffer.

Exercise:

    Implement an array that doubles in size when full.
    Add elements (simulated video packets) dynamically.
*/
/*
 * 1. internal structure of dynamic array
 * 2.add an element with auto resize
 * 3.resize method
 * 4.get method to access element at index
 * 5.get size and capacity methods
 * 6. remove last element
 * 7. print bufer to visualize packets
 */

 public class MyDynamicArrays{
    private int[] array;
    private int size;
    private int capacity;

    public MyDynamicArrays(){
        array=new int[4];
        size=0;
        capacity=array.length;
    }
    public void add(int element){
        if(size==capacity){
            resize();
        }
        array[size]=element;
        size++;
    }
    private void resize(){
        capacity=capacity*2;
        int newArray[]=new int[capacity];
        for(int i=0;i<array.length;i++){
            newArray[i]=array[i];
        }
        array=newArray;

    }
    public int get(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }else{
            return array[index];
        }
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return capacity;
    }
    public void removeLast(){
        if(size==0){
            System.err.println("Array is empty. Cannot remove element.");
        }else{
            size--;
        }
    }
    public void printBuffer(){
        System.out.print("Buffer: ");
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MyDynamicArrays buffer=new MyDynamicArrays();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("\n--- Dynamic Array (Video Buffer Simulation) ---");
            System.out.println("1. Add a packet");
            System.out.println("2. Get packet by index");
            System.out.println("3. Remove last packet");
            System.out.println("4. Show buffer");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice=sc.nextInt();
            if(choice==1){
                System.out.print("Enter packet: ");
                int packet=sc.nextInt();
                buffer.add(packet);
            }else if(choice==2){
                System.out.print("Enter index: ");
                int index=sc.nextInt();
                System.out.println("Packet at index "+index+": "+buffer.get(index));
            }else if(choice==3){
                buffer.removeLast();
            }else if(choice==4){
                buffer.printBuffer();
            }else if(choice==5){
                System.out.println("Exiting...");
                break;
            }else{
                System.err.println("Invalid choice. Please try again.");
            }
        }
    }
 }
