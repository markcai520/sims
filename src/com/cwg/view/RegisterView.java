package com.cwg.view;

import com.cwg.dao.impl.AdminDaoImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RegisterView extends JFrame{

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;

    public RegisterView () {
        JPanel contentPane = new JPanel();		//创建主容器面板

        contentPane.setBorder(new EmptyBorder(5,5,5,5));	//主容器面板使用宽度和间距都是5像素的空边框
        setContentPane(contentPane);		//将主容器面板加载到主容器中
        contentPane.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel (new GridLayout(3,1));
        contentPane.add(centerPanel,BorderLayout.CENTER);

        FlowLayout centerLayout = new FlowLayout();
        centerLayout.setHgap(10); 	//布局中组件间隔10像素

        //创建存放第一行组件的面板，并使用流布局
        JPanel aFloorPanel = new JPanel (centerLayout);
        centerPanel.add(aFloorPanel); 		//第一行面板放入中部面板中
        JLabel usernameLabel = new JLabel("账    号：");
        //设置标签对齐方式为居中
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        aFloorPanel.add(usernameLabel);	//第一行面板中添加标签

        usernameField = new JTextField();
        usernameField.setColumns(20);	//设置用户名输入框长度为20个字符
        aFloorPanel.add(usernameField);	//第一行面板添加用户名输入框

        //创建存放第二行组件的面板，并使用流布局
        JPanel bFloorPanel = new JPanel(centerLayout);
        centerPanel.add(bFloorPanel);
        JLabel pwdLabel = new JLabel("密    码：");

        pwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bFloorPanel.add(pwdLabel);

        passwordField = new JPasswordField();
        passwordField.setColumns(20);
        passwordField.setEchoChar('*');
        bFloorPanel.add(passwordField);

        //创建存放第三行组件的面板，并使用流布局
        JPanel cFloorPanel = new JPanel(centerLayout);
        centerPanel.add(cFloorPanel);
        JLabel repwdLabel = new JLabel("确定密码：");

        repwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cFloorPanel.add(repwdLabel);

        passwordField2 = new JPasswordField();
        passwordField2.setColumns(20);
        passwordField2.setEchoChar('*');
        cFloorPanel.add(passwordField2);

        usernameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    passwordField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    passwordField2.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        passwordField2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    registerAction();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JPanel southPanel = new JPanel(centerLayout);
        contentPane.add(southPanel,BorderLayout.SOUTH);

        final JButton registerBtn = new JButton("注册");
        southPanel.add(registerBtn);

        JButton closeBtn = new JButton ("关闭");
        southPanel.add(closeBtn);

        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerAction ();
            }
        });

        this.setSize(310,240);
        this.setTitle("管理员注册");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void registerAction() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String repassword = new String (passwordField2.getPassword());

        if (username == null || username.equals("")) {
            JOptionPane.showMessageDialog(RegisterView.this,"请输入用户名！");
        } else {
            if (!password.equals(repassword)) {
                JOptionPane.showMessageDialog(RegisterView.this,"两次密码不一致！");
                passwordField.setText("");
                passwordField2.setText("");
            } else {
                if (password == null || password.equals("")) {
                    JOptionPane.showMessageDialog(RegisterView.this,"请输入密码！");
                } else {
                    if (!new AdminDaoImpl().queryByUsername(username)) {
                        AdminDaoImpl adminDao = new AdminDaoImpl();
                        boolean flag = adminDao.addAdmin(username,password);

                        if (flag){
                            JOptionPane.showMessageDialog(RegisterView.this,"注册成功");
                            dispose();
                        }

                        else
                            JOptionPane.showMessageDialog(RegisterView.this,"注册失败");
                    } else {
                        JOptionPane.showMessageDialog(RegisterView.this,"用户名" + username + "已存在");
                        usernameField.setText("");
                    }
                }
            }
        }
    }

}

