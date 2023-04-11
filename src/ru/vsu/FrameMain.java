package ru.vsu;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FrameMain extends JFrame {
    private JPanel panel1;
    private JTextField textField2;
    private JButton loadButton;
    private JButton saveButton;
    private JButton buttonJavaQueue;
    private JButton buttonQueueSelf;
    private JTextField textField1;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    public FrameMain() {
        this.setTitle("Queue");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");
        buttonJavaQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String n = textField2.getText();
                LinkedList<Queue<String>> list = new LinkedList<>();
                list = QueueJava.Testing2(n);
                textField1.setText(list.toString());

            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooserOpen.showOpenDialog(panel1);

                File file = fileChooserOpen.getSelectedFile();
                try {
                    Scanner scanner = new Scanner(file);
                    String n = scanner.nextLine();
                    textField2.setText(n);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooserSave.showSaveDialog(panel1);

                File file = fileChooserSave.getSelectedFile();
                try {
                    FileWriter fw = new FileWriter(file);
                    String text = textField1.getText();
                    fw.write(text);
                    fw.close();
                } catch (IOException e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonQueueSelf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String n = textField2.getText();
                LinkedList<String> list = new LinkedList<>();
                list = QueueLinkListSolve.Testing3(n);
                textField1.setText(list.toString());
            }
        });
    }


}
