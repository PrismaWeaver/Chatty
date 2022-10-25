import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chatty {
    private JFrame frame;
    private JButton create;
    private JTextField username;
    private ChatRoom CR; 

    public static void main(String[] args) {
        Chatty window = new Chatty();
        window.frame.setVisible(true);
	}
    
    public Chatty() {
        frame = new JFrame();
		frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CR = new ChatRoom();

        username = new JTextField();
        username.setBounds(81, 109, 86, 20);
        frame.getContentPane().add(username);
        username.setColumns(10);

        create = new JButton("Create User");
        create.setBounds(81, 140, 89, 23);
		frame.getContentPane().add(create);
        create.addActionListener(new createButtonListener());

        JLabel label = new JLabel("Username");
        label.setBounds(81, 84, 108, 14);
		frame.getContentPane().add(label);
    }

    class createButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            boolean exists = false;
            for (int i = 0; i < CR.getUsers().size() && exists == false; i++) {
                if (CR.getUsers().get(i).getName().matches(username.getText()))
                    exists = true;
            }
            if (exists == false) {
                User user = new User(CR, username.getText(), new ChatWindow());
                CR.addUser(user);
            } else {
                JOptionPane.showMessageDialog(null, "There is an user with the same nick already in the chat room");
            }
        }
    }
}
