package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class client1 extends JFrame implements ActionListener,Runnable{
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;
    BufferedWriter writer;
    BufferedReader reader;

    client1() {

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7, 94, 184));
        p1.setBounds(0,0,450,70);
        add(p1);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2=i1.getImage().getScaledInstance(70,90,Image.SCALE_DEFAULT);//changing the size of the panel
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
        l1.setBounds(395,7,50,60);
        p1.add(l1);//adding image on the panel
        l1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae)
        { //System.exit(0);
            client1.this.setVisible(false);
            }
        });

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/client1.png"));
        Image i5=i4.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);//changing the size of the panel
        ImageIcon i6=new ImageIcon(i5);
        JLabel l2= new JLabel(i6);
        l2.setBounds(20,5,60,60);
        p1.add(l2);//adding image on the panel

        JLabel l3=new JLabel("Client 1");
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        l3.setForeground(new Color(0,0,0));
        l3.setBounds(110,13,100,20);
        p1.add(l3);


        JLabel l4=new JLabel("active now");
        l4.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        l4.setForeground(new Color(0,0,0));
        l4.setBounds(110,35,100,20);
        p1.add(l4);

        t1=new JTextField();
        t1.setBounds(10,655,315,40);
        t1.setFont(new Font("SAN_SERIF",Font.HANGING_BASELINE,17));
        t1.setBackground(new Color(126, 222, 234, 255));
        t1.setForeground(new Color(9, 9, 9));
        add(t1);
        b1=new JButton("SEND");
        b1.setFont(new Font("SANS_SERIF",Font.HANGING_BASELINE,16));
        b1.setBounds(330,655,110,40);
        b1.setBackground(new Color(7,94,184));
        b1.setForeground(Color.white);
        b1.addActionListener(this::actionPerformed);
        add(b1);
        a1= new JTextArea();
        a1.setBounds(5,75,440,570);
        a1.setFont(new Font("SAN_SERIF",Font.HANGING_BASELINE,16));
        a1.setBackground(new Color(252, 249, 249));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);


        setLayout(null);
        setSize(450,700);
        setLocation(470,0);
       setUndecorated(true);
        setVisible(true);
        try{
            Socket socketClient = new Socket("localhost",2001);
            writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String str = "Client 1 :\n" + t1.getText();
        try {
            writer.write(str);
            writer.write("\r\n");
            writer.flush();
        } catch (Exception e) {

        }
        t1.setText("");
    }
    public void run(){
        try{
            String msg="";
            while ((msg = reader.readLine()) !=null) {
                a1.append(msg +"\n");
            }

        }catch(Exception e){

        }
    }
//    public static void main(String[]args){
//        client1 two=new client1();
//        Thread t1=new Thread(two);
//        t1.start();
//    }
}
