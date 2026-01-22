package Gui;
import ToDos.TodoItem;
import ToDos.TodoList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class MyGUI extends JFrame implements ActionListener, KeyListener {

    private final TodoList todo_ObjectForGUI;
    private int currentState = 0;
    private String tempTitle;
    private String tempContent;
    private String tempDate;
    private JButton newNoteButton;
    private JButton viewNoteButton;
    private JButton removeNoteButton;
    private JTextField userEntryField;
    private JTextArea userEntryArea;
    private JTextArea outputArea;

    public MyGUI(TodoList todo_ListForGUI) {
        super("To-Do's");

        this.todo_ObjectForGUI = todo_ListForGUI;
        StringBuilder stringBuilder = new StringBuilder();

        newNoteButton = new JButton("Write New Note");
        viewNoteButton = new JButton("View Notes");
        removeNoteButton = new JButton("Remove Note");

        userEntryArea = new JTextArea(1, 20);
        userEntryField = new JTextField(20);
        outputArea = new JTextArea(15, 20);

        userEntryArea.setEditable(true);
        userEntryField.setEditable(true);
        outputArea.setEditable(false);

        JMenu jmenu = new JMenu("Test Menu");
        jmenu.add(jmenu);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        userEntryField.addKeyListener((KeyListener) this);
        userEntryArea.addKeyListener((KeyListener) this);
        newNoteButton.addActionListener((ActionListener) this);
        viewNoteButton.addActionListener((ActionListener) this);
        removeNoteButton.addActionListener((ActionListener) this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JLabel("Test Label"));
        buttonPanel.add(newNoteButton);
        buttonPanel.add(viewNoteButton);
        buttonPanel.add(removeNoteButton);

        JPanel inputPanel = new JPanel();
        inputPanel.add(userEntryField);

        JPanel outputPanel = new JPanel();
        outputPanel.add(outputArea);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.EAST);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        mainPanel.add(outputPanel, BorderLayout.CENTER);
        //mainPanel.add(jmenu, BorderLayout.NORTH);

        add(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newNoteButton) {
            currentState = 1;
            outputArea.setText("Enter Title: ");
        }

        if (e.getSource() == viewNoteButton) {

        }

        if (e.getSource() == removeNoteButton) {

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            if (currentState == 1) {
                tempTitle = userEntryField.getText();
                outputArea.setText("Title: " + tempTitle);
                userEntryField.setText("");
                outputArea.setText("Enter Note Contents: ");
                currentState = 2;

            } else if (currentState == 2) {
                tempContent = userEntryField.getText();
                outputArea.setText(tempContent);
                userEntryField.setText("");
                outputArea.setText("Enter Due Date (MM-dd-yyyy): ");
                currentState = 3;

            } else if (currentState == 3) {
                tempDate = userEntryField.getText();
                outputArea.setText(tempDate);
                userEntryField.setText("");
                currentState = 4;
                outputArea.setText("**New Note has been added!**\n\n" + "\t" + tempTitle + "\n" + tempContent + "\n" + tempDate);

            } else if (currentState == 4) {
                TodoItem newTodo = new TodoItem(tempTitle);
                newTodo.setContents(tempContent);
                newTodo.setDueDate(tempDate);
                todo_ObjectForGUI.pushTodoIntoArray(newTodo);
                currentState = 0;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}

