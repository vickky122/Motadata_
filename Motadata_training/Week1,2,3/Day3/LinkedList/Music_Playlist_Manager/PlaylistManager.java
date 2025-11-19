import java.util.Scanner;

class SongNode{
    String title;
    SongNode next;
    SongNode prev;

    SongNode(String title){
        this.title=title;
        this.next=null;
        this.prev=null;
    }
}
class Playlist{
    SongNode head, tail;
    int size;

    public void addSongAtBeginning(String title){
        SongNode songNode=new SongNode(title);
        if(head==null){
            head=tail=songNode;
        }else{
            songNode.next=head;
            head.prev=songNode;
            head=songNode;
        }
        size++;
    }
    public void addSongAtEnd(String title){
        SongNode songNode=new SongNode(title);
        if(head==null){
            head=tail=songNode;
        }else{
            tail.next=songNode;
            songNode.prev=tail;
            tail=songNode;
        }
        size++;
    }
    public void deleteSong(String title){
        if(head==null){
            System.out.println("Playlist is empty.");
            return;
        }
        SongNode curr=head;
        while(curr!=null){
            if(curr.title.equals(title)){
                if(curr==head){
                    head=curr.next;
                    if(head!=null){
                        head.prev=null;

                    }
                }else if(curr==tail){
                    tail=curr.prev;
                    if(tail!=null){
                        tail.next=null;
                    }
                }else{
                    curr.prev.next=curr.next;
                    curr.next.prev=curr.prev;
                }
                size--;
                System.err.println("Song deleted successfully.");
                return;
            } 
            curr=curr.next;
        }
        System.out.println("Song not found in the playlist.");

    }
    public void displayForward(){
        System.out.println("\nPlaylist (Forward):");
        if(head==null){
            System.out.println("Playlist is empty.");
            return;
        }
        SongNode temp=head;
        while(temp!=null){
            System.out.print(temp.title + " -> ");
            temp=temp.next;
        }
        System.out.println("null");


    }
    public void displayBackward(){
        System.out.println("\nPlaylist (Backward):");
        if(tail==null){
            System.out.println("Playlist is empty.");
            return;
        }
        SongNode temp=tail;
        while(temp!=null){
            System.out.print(temp.title + " -> ");
            temp=temp.prev;
        }
        System.out.println("null");
    }
}

public class PlaylistManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();

        while (true) {
            System.out.println("\n--- Music Playlist Manager ---");
            System.out.println("1. Add Song at Beginning");
            System.out.println("2. Add Song at End");
            System.out.println("3. Delete Song");
            System.out.println("4. Display Playlist (Forward)");
            System.out.println("5. Display Playlist (Backward)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter song title: ");
                String title = sc.nextLine();
                playlist.addSongAtBeginning(title);

            } else if (choice == 2) {
                System.out.print("Enter song title: ");
                String title = sc.nextLine();
                playlist.addSongAtEnd(title);

            } else if (choice == 3) {
                System.out.print("Enter song title to delete: ");
                String title = sc.nextLine();
                playlist.deleteSong(title);

            } else if (choice == 4) {
                playlist.displayForward();

            } else if (choice == 5) {
                playlist.displayBackward();

            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
