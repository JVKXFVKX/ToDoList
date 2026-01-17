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
        userEntryField = new JTextArea(5, 20);
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
        inputPanel.add(userEntryField);
        inputPanel.add(newNoteButton);
        inputPanel.add(viewNoteButton);
        inputPanel.add(removeNoteButton);

        //JPanel inputPanel2 = new JPanel();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        // mainPanel.add(inputPanel2, BorderLayout.SOUTH);

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
            String userTitle = userEntryField.getText();

        }

        if (e.getSource() == viewNoteButton) {

        }

        if (e.getSource() == removeNoteButton) {

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // User pressed Enter - same logic as if they clicked Submit

            if (currentState == 1) {
                // Grab title, move to state 2
            } else if (currentState == 2) {
                // Grab content, move to state 3
            } else if (currentState == 3) {
                // Grab date, create Todo, reset to state 0
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

