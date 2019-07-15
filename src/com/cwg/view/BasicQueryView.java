package com.cwg.view;

import com.cwg.util.RetrieveObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicQueryView extends JInternalFrame {

    BorderLayout borderLayout1 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    JPanel jPanel1 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JLabel jLabel1 = new JLabel();
    JComboBox jComboBox1 = new JComboBox();
    JLabel jLabel2 = new JLabel();
    JComboBox jComboBox2 = new JComboBox();
    JLabel jLabel3 = new JLabel();
    JComboBox jComboBox3 = new JComboBox();
    JLabel jLabel4 = new JLabel();
    JButton jByes = new JButton();
    JButton jBexit = new JButton();
    JTextField jTextField1 = new JTextField();

    String tabname = null;
    String zdname = null;
    String ysfname = null;
    String[] jTname = null;
    JLabel jLabel5 = new JLabel();

    public BasicQueryView () {
        try {
            jbInit();
            initsize();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void initsize() {
        jComboBox1.addItem("学生信息");
        jComboBox1.addItem("教师信息");

        jComboBox3.addItem("like");
        jComboBox3.addItem(">");
        jComboBox3.addItem("=");
        jComboBox3.addItem("<");
        jComboBox3.addItem(">=");
        jComboBox3.addItem("<=");
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(borderLayout1);
        jTextField1.setPreferredSize(new Dimension(111, 26));
        jTextField1.addKeyListener(new BasicQueryView_jTextField1_keyAdapter(this));
        this.setClosable(true);
        jByes.addActionListener(new BasicQueryView_jByes_actionAdapter(this));
        jComboBox1.addItemListener(new BasicQueryView_jComboBox1_itemAdapter(this));
        jComboBox2.addItemListener(new BasicQueryView_jComboBox2_itemAdapter(this));
        jComboBox3.addItemListener(new BasicQueryView_jComboBox3_itemAdapter(this));
        jBexit.addActionListener(new BasicQueryView_jBexit_actionAdapter(this));
        jLabel5.setForeground(Color.red);
        this.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);
        jLabel1.setText("查询类型");
        jPanel1.setLayout(flowLayout1);
        jLabel2.setToolTipText("");
        jLabel2.setText("字段");
        jLabel3.setText("运算符");
        jLabel4.setText("数值");
        jByes.setText("确定");
        jBexit.setText("退出");
        jTextField1.setText("");
        jPanel1.add(jLabel1);
        jPanel1.add(jComboBox1);
        jPanel1.add(jLabel2);
        jPanel1.add(jComboBox2);
        jPanel1.add(jLabel3);
        jPanel1.add(jComboBox3);
        jPanel1.add(jLabel4);
        jPanel1.add(jTextField1);
        jPanel1.add(jByes);
        jPanel1.add(jBexit);
        this.getContentPane().add(jLabel5, java.awt.BorderLayout.SOUTH);

        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        this.setSize(680, 460);
        this.setVisible(true);
    }

    public void jByes_actionPerformed(ActionEvent e) {
        String sqlSelect = null, whereSql = null;
        String valueStr = jTextField1.getText().trim();

        sqlSelect = this.tabname;

        if (ysfname == "like") {
            whereSql = " and " + this.zdname + " " + this.ysfname + " '%" + valueStr + "%'";
        } else {
            whereSql = " and " + this.zdname + " " + this.ysfname + " '" + valueStr + "'";
        }
        RetrieveObject retrieve = new RetrieveObject();
        javax.swing.table.DefaultTableModel defaultmodel = null;
        defaultmodel = retrieve.getTableModel(jTname, sqlSelect + whereSql);
        jTable1.setModel(defaultmodel);
        if (jTable1.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "没有找到满足条件的数据!!!", "系统提示", JOptionPane.INFORMATION_MESSAGE);
        }
        jTable1.setRowHeight(24);
        jLabel5.setText("共有数据【" + String.valueOf(jTable1.getRowCount()) + "】条");
    }

    public void jComboBox1_itemStateChanged(ItemEvent itemEvent) {
        if (jComboBox1.getSelectedIndex() == 0) {
            this.tabname = "SELECT s.stuID, c.className, s.stuName, s.sex, s.age, s.addr, s.phone FROM tb_student s ,tb_class c where s.classID = c.classID";
            String[] name = { "学生编号", "班级名称", "学生姓名", "性别", "年龄", "家庭住址", "联系电话" };
            jTname = name;
            jComboBox2.removeAllItems();
            jComboBox2.addItem("学生编号");
            jComboBox2.addItem("班级编号");

        }
        if (jComboBox1.getSelectedIndex() == 1) {
            this.tabname = "SELECT t.teaID, c.className, t.teaName, t.sex, t.knowledge, t.level FROM tb_teacher t INNER JOIN tb_class c ON c .classID = t.classID";
            String[] name = { "教师编号", "班级名称", "教师姓名", "性别", "教师职称", "教师等级" };
            jTname = name;
            jComboBox2.removeAllItems();
            jComboBox2.addItem("教师编号");
            jComboBox2.addItem("班级编号");
        }
    }

    public void jComboBox2_itemStateChanged(ItemEvent itemEvent) {
        if (jComboBox1.getSelectedIndex() == 0) {
            if (jComboBox2.getSelectedIndex() == 0)
                this.zdname = "s.stuid";
            if (jComboBox2.getSelectedIndex() == 1)
                this.zdname = "s.classID";
        }
        if (jComboBox1.getSelectedIndex() == 1) {
            if (jComboBox2.getSelectedIndex() == 0)
                this.zdname = "t.teaid";
            if (jComboBox2.getSelectedIndex() == 1)
                this.zdname = "t.classID";
        }
    }

    public void jComboBox3_itemStateChanged(ItemEvent itemEvent) {
        this.ysfname = String.valueOf(jComboBox3.getSelectedItem());
    }

    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否退出基本信息情况查询?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }

    }

    public void jTextField1_keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            ActionEvent event = new ActionEvent(jByes, 0, null);
            this.jByes_actionPerformed(event);
        }
    }
}
class BasicQueryView_jTextField1_keyAdapter extends KeyAdapter {
    private BasicQueryView adapter;

    BasicQueryView_jTextField1_keyAdapter(BasicQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        adapter.jTextField1_keyPressed(keyEvent);
    }
}

class BasicQueryView_jBexit_actionAdapter implements ActionListener {
    private BasicQueryView adapter;

    BasicQueryView_jBexit_actionAdapter(BasicQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        adapter.jBexit_actionPerformed(actionEvent);
    }
}

class BasicQueryView_jByes_actionAdapter implements ActionListener {
    private BasicQueryView adapter;

    BasicQueryView_jByes_actionAdapter(BasicQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        adapter.jByes_actionPerformed(actionEvent);
    }
}

class BasicQueryView_jComboBox1_itemAdapter implements ItemListener {
    private BasicQueryView adapter;

    BasicQueryView_jComboBox1_itemAdapter(BasicQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        adapter.jComboBox1_itemStateChanged(itemEvent);
    }
}

class BasicQueryView_jComboBox2_itemAdapter implements ItemListener {
    private BasicQueryView adapter;

    BasicQueryView_jComboBox2_itemAdapter(BasicQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        adapter.jComboBox2_itemStateChanged(itemEvent);
    }
}

class BasicQueryView_jComboBox3_itemAdapter implements ItemListener {
    private BasicQueryView adapter;

    BasicQueryView_jComboBox3_itemAdapter(BasicQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        adapter.jComboBox3_itemStateChanged(itemEvent);
    }
}
