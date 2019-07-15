package com.cwg.view;


import com.cwg.util.FontAndColor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainView extends JFrame implements ActionListener{

    JPanel contentPane;
    JLabel jl = null; //背景图标
    BorderLayout borderLayout1 = new BorderLayout();
    JDesktopPane desktop = new JDesktopPane();
    JMenuBar jMenuBarMain = new JMenuBar(); // 定义界面中的主菜单控件
    JToolBar jToolBarMain = new JToolBar(); // 定义界面中的工具栏控件

    JMenu[] _jMenu = { new JMenu("系统设置"), new JMenu("基本信息"), new JMenu("信息查询"), new JMenu("更换背景"),new JMenu("系统管理") };
    JMenuItem[] _jMenuItem0 = { new JMenuItem("年级设置"), new JMenuItem("班级设置"), new JMenuItem("考试科目"), new JMenuItem("考试类别") };
    JMenuItem[] _jMenuItem1 = { new JMenuItem("学生信息"), new JMenuItem("教师信息"), new JMenuItem("考试成绩") };
    JMenuItem[] _jMenuItem2 = { new JMenuItem("基本信息"), new JMenuItem("成绩信息"), new JMenuItem("汇总查询") };
    JMenuItem[] _jMenuItem3 = { new JMenuItem("梦幻飞马"), new JMenuItem("暗黑世界"), new JMenuItem("黑客轮盘")};
    JMenuItem[] _jMenuItem4 = { new JMenuItem("管理员信息"), new JMenuItem("退出系统") };

    public MainView() {
        setResizable(false);
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            BuildMenuBar();
            jbInit();
            loadBackgroundImage("bg1.jpg");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jToolBarMain.setFloatable(false);
        this.setJMenuBar(jMenuBarMain);
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(900, 740));
        setTitle("学生成绩管理系统");
        contentPane.add(desktop, java.awt.BorderLayout.CENTER);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        setVisible(true);

    }

    protected void loadBackgroundImage(String img) {
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/" + img));
        jl = new JLabel(icon);
        jl.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        desktop.add(jl, new Integer(Integer.MIN_VALUE));
    }

    private void BuildMenuBar() {

        Font _MenuItemFont = new Font("微软雅黑", 0, 12);
        for (int i = 0; i < _jMenu.length; i++) {
            _jMenu[i].setFont(_MenuItemFont);
            jMenuBarMain.add(_jMenu[i]);
        }

        for (int j = 0; j < _jMenuItem0.length; j++) {
            _jMenuItem0[j].setFont(_MenuItemFont);
            _jMenuItem0[j].addActionListener(this);
            _jMenu[0].add(_jMenuItem0[j]);
            if (j == 1) {
                _jMenu[0].addSeparator();
            }
        }

        for (int j = 0; j < _jMenuItem1.length; j++) {
            _jMenuItem1[j].setFont(_MenuItemFont);
            _jMenuItem1[j].addActionListener(this);
            _jMenu[1].add(_jMenuItem1[j]);
            if (j == 1) {
                _jMenu[1].addSeparator();
            }
        }

        for (int j = 0; j < _jMenuItem2.length; j++) {
            _jMenuItem2[j].setFont(_MenuItemFont);
            _jMenuItem2[j].addActionListener(this);
            _jMenu[2].add(_jMenuItem2[j]);
            if ((j == 0)) {
                _jMenu[2].addSeparator();
            }
        }

        for (int j = 0; j < _jMenuItem3.length; j++) {
            _jMenuItem3[j].setFont(_MenuItemFont);
            _jMenuItem3[j].addActionListener(this);
            _jMenu[3].add(_jMenuItem3[j]);
            if (j == 0 || j == 1) {
                _jMenu[3].addSeparator();
            }
        }

        for (int j = 0; j < _jMenuItem4.length; j++) {
            _jMenuItem4[j].setFont(_MenuItemFont);
            _jMenuItem4[j].addActionListener(this);
            _jMenu[4].add(_jMenuItem4[j]);
            if (j == 0) {
                _jMenu[4].addSeparator();
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /* 更换背景 */
        if (e.getSource() == _jMenuItem3[0]) {

            desktop.remove(jl);
            loadBackgroundImage("bg1.jpg");
            return;
        }
        if (e.getSource() == _jMenuItem3[1]) {
            desktop.remove(jl);
            loadBackgroundImage("bg2.jpg");
            return;
        }
        if (e.getSource() == _jMenuItem3[2]) {
            desktop.remove(jl);
            loadBackgroundImage("bg3.jpg");
            return;
        }

        /* 打开管理员信息维护界面 */
        if (e.getSource() == _jMenuItem4[0]) {
            AdminView adminView = new AdminView();
            adminView.setLocation(50,30);
            desktop.add(adminView);
            adminView.setTitle("管理员信息");
            adminView.show();
            desktop.getDesktopManager().activateFrame(adminView);
        }

        /* 退出事件处理 */
        if (e.getSource() == _jMenuItem4[1]) {
            int result = JOptionPane.showOptionDialog(null, "是否真的退出学生管理系统?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new String[] { "是", "否" }, "否");
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            return;
        }

        /* 系统设置菜单事件 */
        if (e.getSource() == _jMenuItem0[0]) {
            GradeView gradeView = new GradeView();
            gradeView.setLocation(80,20);
            desktop.add(gradeView);
            gradeView.setTitle("年级信息");
            gradeView.show();
            desktop.getDesktopManager().activateFrame(gradeView);
        }

        if (e.getSource() == _jMenuItem0[1]) {
            ClassView classView = new ClassView();
            classView.setLocation(100,60);
            desktop.add(classView);
            classView.setTitle("班级信息");
            classView.show();
            desktop.getDesktopManager().activateFrame(classView);
        }

        if (e.getSource() == _jMenuItem0[2]) {
            SubjectView subjectView = new SubjectView();
            subjectView.setLocation(200,30);
            desktop.add(subjectView);
            subjectView.setTitle("考试科目信息");
            subjectView.show();
            desktop.getDesktopManager().activateFrame(subjectView);
        }

        if (e.getSource() == _jMenuItem0[3]) {
            ExamKindView examKindView = new ExamKindView();
            examKindView.setLocation(180,50);
            desktop.add(examKindView);
            examKindView.setTitle("考试类别信息");
            examKindView.show();
            desktop.getDesktopManager().activateFrame(examKindView);
        }

        /* 基本信息菜单事件 */

        if (e.getSource() == _jMenuItem1[0]) {
            StudentView studentView = new StudentView();
            studentView.setLocation(50,50);
            desktop.add(studentView);
            studentView.setTitle("学生基本信息");
            studentView.show();
            desktop.getDesktopManager().activateFrame(studentView);
        }

        if (e.getSource() == _jMenuItem1[1]) {
            TeacherView teacherView = new TeacherView();
            teacherView.setLocation(60,60);
            desktop.add(teacherView);
            teacherView.setTitle("教师基本信息");
            teacherView.show();
            desktop.getDesktopManager().activateFrame(teacherView);
        }

        if (e.getSource() == _jMenuItem1[2]) {

            GradeSubView gradeSubView = new GradeSubView();
            gradeSubView.setLocation(20,20);
            gradeSubView.setTitle("成绩基本信息");
            gradeSubView.show();
            desktop.add(gradeSubView);

            String str = "<html><body>修改学生成绩步骤：<br>1.单击表格选中学生信息<br>2.点击上方修改按钮<br>3.正确录入学生成绩<br>4.点击上方保存按钮保存成绩信息</body></html>";
            JLabel labelTip = new JLabel(str);
            labelTip.setFont(FontAndColor.tipFont());
            labelTip.setForeground(FontAndColor.tipColor());
            JOptionPane.showMessageDialog(this,labelTip,"操作提示",1);

            desktop.getDesktopManager().activateFrame(gradeSubView);
        }

        /* 信息查询菜单事件处理 */

        if (e.getSource() == _jMenuItem2[0]) {
            BasicQueryView basicQueryView = new BasicQueryView();
            basicQueryView.setLocation(30,20);
            basicQueryView.setTitle("基本信息查询");
            basicQueryView.show();
            desktop.add(basicQueryView);
            desktop.getDesktopManager().activateFrame(basicQueryView);
        }

        if (e.getSource() == _jMenuItem2[1]) {
            GradeQueryView gradeQueryView = new GradeQueryView();
            gradeQueryView.setLocation(40,30);
            gradeQueryView.setTitle("成绩查询");
            gradeQueryView.show();
            desktop.add(gradeQueryView);
            desktop.getDesktopManager().activateFrame(gradeQueryView);
        }

        if (e.getSource() == _jMenuItem2[2]) {
            GradeGatherQueryView gradeGatherQueryView = new GradeGatherQueryView();
            gradeGatherQueryView.setLocation(30,30);
            gradeGatherQueryView.setTitle("汇总查询");
            gradeGatherQueryView.show();
            desktop.add(gradeGatherQueryView);
            desktop.getDesktopManager().activateFrame(gradeGatherQueryView);
        }

    }

}
