import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User {
    private String username;
    private ChatRoom CR; 
    private ChatWindow CW; 

    public User(ChatRoom cr, String name, ChatWindow cw) {
        CR = cr;
        username = name;
        CW = cw;
        CW.setName(username);
        CW.getButton().addActionListener(new sendButtonListener());
        for (int i = 0; i < CR.getMessages().size(); i++) {
            CW.getChat().setText(CW.getChat().getText() + CR.getMessages().get(i) + "\n");
        }
        CR.send("User <" + this.username + "> has logged in");
        User user= this;
        CW.getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                CR.send("User <" + username + "> has logged off");
                CR.removeUser(user);
            }
        });
        CW.setVisible(true);
    }
    

    class sendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            send(CW.getTextEntry().getText());
        }
    }

    //sending and receiving messages
    public void send(String message) {
        CR.send("<" + this.username + ">: " + message);
    }
    public void receive(String message) {
        CW.getChat().setText(CW.getChat().getText() + message + "\n");
    }

    //setting and getting usernames
    public void setName(String name) {
        username = name;
    }
    public String getName() {
        return username;
    }
}
