package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {
   static JTextField sender, receiver, answer;

    public UI() {
        super("Текстовые поля");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Создание текстовых полей
        sender = new JTextField(15);
        sender.setToolTipText("sender");
        receiver = new JTextField(15);
        receiver.setToolTipText("receiver");
        answer = new JTextField(10);
        answer.setToolTipText("answer");
        // Слушатель окончания ввода
        sender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.Action(sender.getText());
            }
        });
        // Создание панели с текстовыми полями
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(sender);
        contents.add(receiver);
        contents.add(answer);
        setContentPane(contents);
        // Определяем размер окна и выводим его на экран
        setSize(400, 130);
        setVisible(true);
    }
}
