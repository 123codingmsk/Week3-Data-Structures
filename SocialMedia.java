import java.util.List;
import java.util.ArrayList;
class UserNode{

    int userId;
    String name;
    int age;
    List<UserNode> friendsList;
    UserNode next;

    UserNode(int userId, String name, int age){
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendsList = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMedia {

    static UserNode head = null;

    static void addUser(UserNode user){
        if(head==null){
            head = user;
            return;
        }
        UserNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = user;
    }

    static void addFriend(UserNode user1, UserNode user2){
        if(!user1.friendsList.contains(user2)){
            user1.friendsList.add(user2);
        }
        if(!user2.friendsList.contains(user1)){
            user2.friendsList.add(user1);
        }
    }

    static void removeFriend(UserNode user1, UserNode user2){
        if(user1.friendsList.contains(user2)) user1.friendsList.remove(user2);
        if(user2.friendsList.contains(user1)) user2.friendsList.remove(user1);
    }
    
    static void mutualFriends(UserNode user1, UserNode user2){
        System.out.println("\nMutual friends list : ");
        for(UserNode friend1: user1.friendsList){
            for(UserNode friend2: user2.friendsList){
                if(friend1.equals(friend2)){
                    System.out.println(friend1.name + "( Id : " + friend1.userId+ ")");
                }
            }
        }
    }

    static void searchByName(String name){
        UserNode curr = head;
        System.out.println();
        while (curr!=null) {
            if(curr.name.equals(name)){
                System.out.println("\nUser Name : " + curr.name);
                System.out.println("User id : " + curr.userId);
                System.out.println("Age : " + curr.age);
            }
            curr = curr.next;
        }
    }

    static void countFriendsForAll(){
        UserNode curr = head;
        while (curr!=null) {
            int s = curr.friendsList.size();
            System.out.println("No of friends for the user " + curr.name + " : " + s); 
            curr = curr.next;  
        }
        
    }

    static void displayAllFriends(UserNode user){
        for(UserNode friend:user.friendsList){
            System.out.println(friend.name + " (id : " + friend.userId + ")");
        }
        System.out.println();   
    }
    
    static void displayUsers(){
        UserNode curr = head;
        while (curr!=null) {
            System.out.print(curr.name + " -> ");
            curr = curr.next;            
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        UserNode u1 = new UserNode(1, "Nivas", 22);
        UserNode u2 = new UserNode(2, "Rahul", 22);
        UserNode u3 = new UserNode(3,"Devaa", 22);
        UserNode u4 = new UserNode(4,"Varadha",22);
        addUser(u1);
        addUser(u2);
        addUser(u3);
        displayUsers();
        addFriend(u1, u2);
        addFriend(u1, u3);
        addFriend(u2, u3);
        addFriend(u1, u4);
        addFriend(u2, u4);
        addFriend(u3, u4);
        //displayAllFriends(u1);
        removeFriend(u1, u2);
        displayAllFriends(u2);
        mutualFriends(u1, u2);
        searchByName("Rahul");
        countFriendsForAll();
    }
}