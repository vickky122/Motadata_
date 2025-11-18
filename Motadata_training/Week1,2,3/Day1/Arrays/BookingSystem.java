import java.util.*;


    // Create an array of 300 seats (0 = empty, 1 = booked).
    // Display available seats.
    // Book a seat by entering seat number.


public class BookingSystem{
    public static void main(String[] args){
        int seats[]=new int[300];
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("---- Booking System ---");
            System.out.println("1. See available seats");
            System.out.println("2. Book a seat");
            System.err.println("3. Cancel a seat");
            System.err.println("4. Count of booked seats");
            System.err.println("5. Count of empty seats");
            System.err.println("6. Exit");
            System.out.println("Enter your choice : ");
            int choice=sc.nextInt();

            if(choice==1){
                showAvailableSeats(seats);
            }else if(choice==2){
                bookSeat(seats);
            }else if (choice==3) {
                cancelSeat(seats);
            }
            else if(choice==4){
                countBookedSeats(seats);
            }else if(choice==5){
                countEmptySeats(seats);
            }
            else if(choice==6){
                System.out.println("Exiting.....");
                break;
            }else{
                System.err.println("Invalid selection. Please try again");
            }
        }
        
    }
    private static void showAvailableSeats(int[] seats){
        System.err.println("\nAvailable Seats");
        for (int i = 0; i < seats.length; i++) {
            if(seats[i]==0){
                System.out.print((i+1)+" ");
            }
            
        }
        System.out.println();
    }
    private static void bookSeat(int[] seats){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter seat number to book : ");
        int seat=sc.nextInt();
        if(seat<1 || seat>seats.length){
            System.err.println("Invalid seat number. Please try again");
        }
        if(seats[seat-1]==0){
            seats[seat-1]=1;
            System.out.println("Seat "+seat+" has been booked");
        }else{
            System.err.println("Seat "+seat+" is already booked");
        }
    }
    private static void cancelSeat(int[] seats){
        Scanner sc=new Scanner(System.in);
        System.err.println("Enter seat number to cancel : ");
        int seat=sc.nextInt();
        if(seat<1 || seat>seats.length){
            System.err.println("Invalid seat number. Please try again");
        }
        if(seats[seat-1]==1){
            seats[seat-1]=0;
            System.out.println("Seat "+seat+" has been cancelled");
        }else{
            System.err.println("Seat "+seat+" is not booked");
        }
    }
    private static void countBookedSeats(int[] seats){
        int count=0;
        for (int i = 0; i < seats.length; i++) {
            if(seats[i]==1){
                count++;
            }
        }
        System.out.println("Total booked seats: "+count);
    }
    private static void countEmptySeats(int[] seats){
        // Total seats - booked seats
        int count=0;
        for (int i = 0; i < seats.length; i++) {
            if(seats[i]==0){
                count++;                
            }            
        }
        System.out.println("Total empty seats: "+count);
    }

}