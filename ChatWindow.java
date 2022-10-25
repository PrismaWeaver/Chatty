import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ChatWindow {
    private JFrame frame;
	private JTextField text;
	private JTextArea chat;
	private JLabel name;
	private JButton send;

    public ChatWindow() {
        frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(41, 42, 353, 150);
		frame.getContentPane().add(scroll);

        chat = new JTextArea();
        scroll.setViewportView(chat);
        chat.setEditable(false);

        name = new JLabel();
        name.setBounds(41, 17, 46, 14);
        frame.getContentPane().add(name);

        text = new JTextField();
		text.setBounds(41, 202, 231, 20);
		frame.getContentPane().add(text);
		text.setColumns(10);

        send = new JButton("Send");
		send.setBounds(300, 201, 89, 23);
		frame.getContentPane().add(send);
    }

    //getters
    public JTextArea getChat() {
        return chat;
    }
    public JButton getButton() {
        return send;
    }
    public JTextField getTextEntry() {
        return text;
    }
    public JFrame getFrame() {
        return frame;
    }

    //setters
    public void setName(String entry) {
        name.setText(entry);
    }
    public void setVisible(Boolean v) {
        frame.setVisible(v);
    }
}
