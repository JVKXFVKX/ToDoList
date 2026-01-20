package Gui;
import ToDos.Todo;
import ToDos.TodoList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class MyGUI extends JFrame implements ActionListener, KeyListener {

    private int currentState = 0;
    private String tempTitle;
    private String tempContent;
    private String tempDate;
    private JButton newNoteButton;
    private JButton viewNoteButton;
    private JButton removeNoteButton;
    private JTextArea userEntryField;
    private JTextArea outputArea;
    private final TodoList todo_ObjectForGUI;

    public MyGUI(TodoList todo_ListForGUI) {
        super("To-Do's");

        this.todo_ObjectForGUI = todo_ListForGUI;
        StringBuilder stringBuilder = new StringBuilder();

        newNoteButton = new JButton("Write New Note");
        viewNoteButton = new JButton("View Notes");
        removeNoteButton = new JButton("Remove Note");
        userEntryField = new JTextArea(1, 20);
        userEntryField.setEditable(true);
        outputArea = new JTextArea(15, 20);
        outputArea.setEditable(false);


        JScrollPane scrollPane = new JScrollPane(outputArea);

        userEntryField.addKeyListener((KeyListener) this);
        newNoteButton.addActionListener((ActionListener) this);
        viewNoteButton.addActionListener((ActionListener) this);
        removeNoteButton.addActionListener((ActionListener) this);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Test Label"));
        inputPanel.add(newNoteButton);
        inputPanel.add(viewNoteButton);
        inputPanel.add(removeNoteButton);

        JPanel inputPanel2 = new JPanel();
        inputPanel2.add(userEntryField);

        JPanel inputPanel3 = new JPanel();
        inputPanel3.add(outputArea);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.EAST);
        mainPanel.add(inputPanel2, BorderLayout.SOUTH);
        mainPanel.add(inputPanel3, BorderLayout.NORTH);

        add(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param e the event to be processed
     */
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
                outputArea.setText("**New Note has been added!**\n\n" + "\t" + tempTitle + "\n" + tempContent + tempDate);

            } else if (currentState == 4) {
                Todo newTodo = new Todo(tempTitle);
                newTodo.setNoteContents(tempContent);
                newTodo.setUserDefinedEndDateOfNote(tempDate);
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

