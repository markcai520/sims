package com.cwg.view;

import com.cwg.dao.impl.AdminDaoImpl;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class LoginView extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginView() {

        JPanel contentPane = new JPanel();		//创建主容器面板

        contentPane.setBorder(new EmptyBorder(5,5,5,5));	//主容器面板使用宽度和间距都是5像素的空边框
        setContentPane(contentPane);		//将主容器面板加载到主容器中
        contentPane.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel (new GridLayout(2,1));
        contentPane.add(centerPanel,BorderLayout.CENTER);

        FlowLayout centerLayout = new FlowLayout();
        centerLayout.setHgap(10); 	//布局中组件间隔10像素

        //创建存放第一行组件的面板，并使用流布局
        JPanel aFloorPanel = new JPanel (centerLayout);
        centerPanel.add(aFloorPanel); 		//第一行面板放入中部面板中
        JLabel usernameLabel = new JLabel("账号：");
        //设置标签对齐方式为居中
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        aFloorPanel.add(usernameLabel);	//第一行面板中添加标签

        usernameField = new JTextField();
        usernameField.setColumns(20);	//设置用户名输入框长度为20个字符
        aFloorPanel.add(usernameField);	//第一行面板添加用户名输入框

        //创建存放第二行组件的面板，并使用流布局
        JPanel bFloorPanel = new JPanel(centerLayout);
        centerPanel.add(bFloorPanel);
        JLabel pwdLabel = new JLabel("密码：");

        pwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bFloorPanel.add(pwdLabel);

        passwordField = new JPasswordField();
        passwordField.setColumns(20);
        passwordField.setEchoChar('*');
        bFloorPanel.add(passwordField);

        passwordField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    loginAction();
                }
            }
        });

        JPanel southPanel = new JPanel(centerLayout);
        contentPane.add(southPanel,BorderLayout.SOUTH);

        final JButton loginBtn = new JButton("登录");
        southPanel.add(loginBtn);

        JButton registerBtn = new JButton ("注册");
        southPanel.add(registerBtn);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction ();
            }
        });

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterView();
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(310,210);
        this.setTitle("管理员登录");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }

    public void loginAction () {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        boolean result = new AdminDaoImpl().queryByInfo(username,password);

        if (result) {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
            new MainView();
            dispose();

        }
        else {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
            JOptionPane.showMessageDialog(LoginView.this,"登录失败");
        }
    }
}
