import java.util.ArrayList;

public class ChatRoom {
    private ArrayList<User> users; 
    private ArrayList<String> messages;

    public ChatRoom() {
        users = new ArrayList<User>();
        messages = new ArrayList<String>();
    }

    //getters
    public ArrayList<String> getMessages() {
        return messages;
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    //setters
    public void send(String message) {
        messages.add(message);
        for (User user: users) {
            user.receive(message); 
        }
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void removeUser(User user) {
        users.remove(user);
    }
}
