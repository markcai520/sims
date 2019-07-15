package com.cwg.view;

import com.cwg.dao.impl.ClassDaoImpl;
import com.cwg.dao.impl.StudentDaoImpl;
import com.cwg.util.FontAndColor;
import com.cwg.util.RetrieveObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class StudentView extends JInternalFrame {

    BorderLayout borderLayout1 = new BorderLayout();
    JSplitPane jSplitPane1 = new JSplitPane();
    JPanel jPanel1 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JLabel jLabel1 = new JLabel();
    JComboBox jComboBox1 = new JComboBox();
    JLabel jLabel2 = new JLabel();
    JComboBox jComboBox2 = new JComboBox();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
    JPanel jPanel3 = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JLabel jLabel3 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JLabel jLabel4 = new JLabel();
    JTextField jTextField2 = new JTextField();
    JLabel jLabel5 = new JLabel();
    JTextField jTextField3 = new JTextField();
    JLabel jLabel6 = new JLabel();
    JTextField jTextField4 = new JTextField();
    JLabel jLabel7 = new JLabel();
    JComboBox jComboBox3 = new JComboBox();
    JLabel jLabel8 = new JLabel();
    JTextField jTextField5 = new JTextField();
    JLabel jLabel9 = new JLabel();
    JTextField jTextField6 = new JTextField();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    JButton jBrefresh = new JButton();
    JButton jBexit = new JButton();
    JButton jBdel = new JButton();

    String gradeID[] = null;
    String classID[] = null;

    public StudentView () {
        try {
            jbInit();
            initialize();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(borderLayout1);
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setOpaque(false);
        jSplitPane1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(flowLayout1);
        jLabel1.setText("所属年级:");
        jLabel2.setToolTipText("");
        jLabel2.setText("所属班级:");
        jBadd.setText("添加");
        jBadd.addActionListener(new StudentView_jBadd_actionAdapter(this));
        jBsave.setMnemonic('0');
        jBsave.setText("修改");
        jBsave.addActionListener(new StudentView_jBsave_actionAdapter(this));
        jPanel3.setLayout(gridLayout1);
        gridLayout1.setColumns(4);
        gridLayout1.setRows(4);
        jLabel3.setText("学号");
        jTextField1.setText("");
        jLabel4.setText("班级");
        jTextField2.setText("");
        jLabel5.setText("学生姓名");
        jTextField3.setText("");
        jLabel6.setText("年龄");
        jTextField4.setText("");
        jLabel7.setText("性别");
        jLabel8.setText("家庭地址");
        jTextField5.setText("");
        jLabel9.setText("联系电话");
        jTextField6.setText("");
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jBrefresh.setText("刷新");
        jBrefresh.addActionListener(new StudentView_jBrefresh_actionAdapter(this));
        jBexit.setText("退出");
        jBexit.addActionListener(new StudentView_jBexit_actionAdapter(this));
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        this.setClosable(true);
        jBdel.setText("删除");
        jBdel.addActionListener(new StudentView_jBdel_actionAdapter(this));
        jTable1.addMouseListener(new StudentView_jTable1_mouseAdapter(this));
        jComboBox1.addItemListener(new StudentView_jComboBox1_itemAdapter(this));
        jComboBox2.addItemListener(new StudentView_jComboBox2_itemAdapter(this));
        jPanel1.add(jLabel1);
        jPanel1.add(jComboBox1);
        jPanel1.add(jLabel2);
        jPanel1.add(jComboBox2);
        jPanel1.add(jBrefresh);
        jPanel1.add(jBadd);
        jPanel1.add(jBdel);
        jPanel1.add(jBsave);
        jPanel1.add(jBexit);
        jSplitPane1.add(jPanel3, JSplitPane.BOTTOM);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField1);
        jPanel3.add(jLabel4);
        jPanel3.add(jTextField2);
        jPanel3.add(jLabel5);
        jPanel3.add(jTextField3);
        jPanel3.add(jLabel6);
        jPanel3.add(jTextField4);
        jPanel3.add(jLabel7);
        jPanel3.add(jComboBox3);
        jPanel3.add(jLabel9);
        jPanel3.add(jTextField5);
        jPanel3.add(jLabel8);
        jPanel3.add(jTextField6);
        jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
        this.getContentPane().add(jSplitPane1, BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);
        this.getContentPane().add(jPanel1, BorderLayout.NORTH);
        setSize(640, 440);
        setVisible(true);
        jComboBox3.addItem("男");
        jComboBox3.addItem("女");
        jSplitPane1.setDividerLocation(220);
    }

    public void initialize() {
        String sqlStr = null;
        sqlStr = "select gradeID,gradeName from tb_grade;";

        RetrieveObject retrieve = new RetrieveObject();
        Collection collection = null;
        Iterator iterator = null;
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        int i = 0;
        gradeID = new String[collection.size()];
        while (iterator.hasNext()) {
            java.util.Vector vdata = (java.util.Vector) iterator.next();
            gradeID[i] = String.valueOf(vdata.get(0));
            jComboBox1.addItem(vdata.get(1));
            i++;
        }
    }


    public void jBadd_actionPerformed(ActionEvent e) {

        String stuID = jTextField1.getText().trim();
        String classID = jTextField2.getText().trim();
        String stuName = jTextField3.getText().trim();

        String sex = jComboBox3.getSelectedItem().toString();
        String ageStr = jTextField4.getText().trim();

        if(stuID == null || stuID.equals("")) {
            JLabel label = new JLabel ("学生ID不能为空");
            label.setFont(FontAndColor.errorFont());
            label.setForeground(FontAndColor.errorColor());
            JOptionPane.showMessageDialog(this,label);
            return;
        }

        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(this,"年龄非整数！");
            return;
        }

        if (!new ClassDaoImpl().queryById(classID)) {
            JOptionPane.showMessageDialog(this,"班级" + classID + "不存在");
            jTextField2.setText("");
            return;
        }

        String addr = jTextField6.getText().trim();
        String phone = jTextField5.getText().trim();

        if (new StudentDaoImpl().queryById(stuID)) {
            JOptionPane.showMessageDialog(this,"学号" + stuID + "已存在");
            jTextField1.setText("");
            return;
        }

        StudentDaoImpl studentDao = new StudentDaoImpl();
        boolean flag = studentDao.insert(stuID,classID,stuName,sex,age,addr,phone);

        if (flag) {
            JOptionPane.showMessageDialog(this,"添加成功");

        }

    }

    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否退出学生基本信息录入?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }

    }

    public void jBsave_actionPerformed(ActionEvent e) {
        String stuID = jTextField1.getText().trim();
        String classID = jTextField2.getText().trim();
        String stuName = jTextField3.getText().trim();

        String sex = jComboBox3.getSelectedItem().toString();
        String age_tr = jTextField4.getText().trim();
        String addr = jTextField6.getText().trim();
        String phone = jTextField5.getText().trim();

        if (stuID == null || stuID.equals("")) {
            JOptionPane.showMessageDialog(this,"请输入要修改的学生学号");
            return;
        }

        int age = 0;
        try {
            age = Integer.parseInt(age_tr);
        }catch (Exception e2) {
            JOptionPane.showMessageDialog(this,"年龄格式不正确！");
            return;
        }

        if (!new ClassDaoImpl().queryById(classID)) {
            JOptionPane.showMessageDialog(this,"班级" + classID + "不存在");
            jTextField2.setText("");
            return;
        }

        if (!new StudentDaoImpl().queryById(stuID)) {
            JOptionPane.showMessageDialog(this,"学号为" + stuID + "的学生不存在！");
            jTextField1.setText("");
            return;
        }

        StudentDaoImpl studentDao = new StudentDaoImpl();
        boolean flag = studentDao.update(stuID,classID,stuName,sex,age,addr,phone);

        if (flag) {
            JOptionPane.showMessageDialog(this,"修改学生信息成功");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jComboBox3.setSelectedIndex(0);
            jTextField6.setText("");

        }else {
            JOptionPane.showMessageDialog(this,"修改学生信息失败");
        }
    }

    public void jBrefresh_actionPerformed(ActionEvent e) {
        DefaultTableModel tablemodel = null;
        String[] name = { "学号", "班级", "学生姓名", "性别", "年龄", "家庭住址", "联系电话" };
        String sqlStr = "select * from tb_student";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr);
        jTable1.setModel(tablemodel);
        jTable1.setRowHeight(24);
    }

    public void jBdel_actionPerformed(ActionEvent e) {

        int result = JOptionPane.showOptionDialog(null, "是否删除学生信息数据?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;

        String stuID = null;

        try {
            stuID = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(this,"您尚未选定信息\n单击表格项可选择信息");
            return;
        }


        if (!new StudentDaoImpl().queryById(stuID)) {
            JOptionPane.showMessageDialog(this,"学号为" + stuID + "的学生不存在,删除失败");
            jTextField1.setText("");
            return;
        }
        if (new StudentDaoImpl().delete(stuID)) {
            JOptionPane.showMessageDialog(this,"已删除学号为" + stuID + "的学生信息");

        }else {
            JOptionPane.showMessageDialog(this,"删除失败！");
        }
    }

    public void jTable1_mouseClicked(MouseEvent e) {
        String id = null;
        String sqlStr = null;
        int selectrow = 0;
        selectrow = jTable1.getSelectedRow();
        if (selectrow < 0)
            return;
        id = jTable1.getValueAt(selectrow, 0).toString();

        sqlStr = "select * from tb_student where stuID = '" + id + "'";

        Vector vdata = null;
        Vector vdata1 = null;

        RetrieveObject retrive = new RetrieveObject();
        vdata = retrive.getObjectRow(sqlStr);
        String gradeid = null, classid = null;
        String gradename = null, classname = null;
        Vector vname = null;
        classid = vdata.get(1).toString();

        String sqlStr1 = "select * from tb_class where classID = '" + classid + "'";
        vdata1 = retrive.getObjectRow(sqlStr1);

        gradeid = vdata1.get(1).toString();
        vname = retrive.getObjectRow("select className from tb_class where classID = '" + classid + "'");
        classname = String.valueOf(vname.get(0));
        vname = retrive.getObjectRow("select gradeName from tb_grade where gradeID = '" + gradeid + "'");
        gradename = String.valueOf(vname.get(0));
        jTextField1.setText(vdata.get(0).toString());
        jTextField2.setText(classid);
        jTextField3.setText(vdata.get(2).toString());
        jComboBox3.setSelectedItem(vdata.get(3).toString());
        jTextField4.setText(vdata.get(4).toString());
        jTextField5.setText(vdata.get(6).toString());
        jTextField6.setText(vdata.get(5).toString());
    }

    public void jComboBox1_itemStateChanged(ItemEvent e) {
        jComboBox2.removeAllItems();
        int Index = jComboBox1.getSelectedIndex();
        String sqlStr = null;
        sqlStr = "select classID,className from tb_class where gradeID = '" + gradeID[Index] + "'";
        RetrieveObject retrieve = new RetrieveObject();
        java.util.Collection collection = null;
        java.util.Iterator iterator = null;
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        classID = new String[collection.size()];
        int i = 0;
        while (iterator.hasNext()) {
            java.util.Vector vdata = (java.util.Vector) iterator.next();
            classID[i] = String.valueOf(vdata.get(0));
            jComboBox2.addItem(vdata.get(1));
            i++;
        }
    }

    public void jComboBox2_itemStateChanged(ItemEvent e) {
        if (jComboBox2.getSelectedIndex() < 0)
            return;
        String cid = classID[jComboBox2.getSelectedIndex()];
        DefaultTableModel tablemodel = null;
        String[] name = { "学号", "班级", "姓名", "性别", "年龄", "家庭住址", "联系电话" };
        String sqlStr = "select * from tb_student where classID = '" + cid + "'";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr);
        jTable1.setModel(tablemodel);
        jTable1.setRowHeight(24);
    }

}

class StudentView_jComboBox2_itemAdapter implements ItemListener {
    private StudentView adapter;

    StudentView_jComboBox2_itemAdapter(StudentView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        adapter.jComboBox2_itemStateChanged(e);
    }
}

class StudentView_jComboBox1_itemAdapter implements ItemListener {
    private StudentView adapter;

    StudentView_jComboBox1_itemAdapter(StudentView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        adapter.jComboBox1_itemStateChanged(e);
    }
}

class StudentView_jTable1_mouseAdapter extends MouseAdapter {
    private StudentView adapter;

    StudentView_jTable1_mouseAdapter(StudentView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        adapter.jTable1_mouseClicked(e);
    }
}

class StudentView_jBdel_actionAdapter implements ActionListener {
    private StudentView adapter;

    StudentView_jBdel_actionAdapter(StudentView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBdel_actionPerformed(e);
    }
}

class StudentView_jBrefresh_actionAdapter implements ActionListener {
    private StudentView adapter;

    StudentView_jBrefresh_actionAdapter(StudentView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBrefresh_actionPerformed(e);
    }
}

class StudentView_jBexit_actionAdapter implements ActionListener {
    private StudentView adapter;

    StudentView_jBexit_actionAdapter(StudentView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBexit_actionPerformed(e);
    }
}

class StudentView_jBadd_actionAdapter implements ActionListener {
    private StudentView adapter;

    StudentView_jBadd_actionAdapter(StudentView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBadd_actionPerformed(e);
    }
}

class StudentView_jBsave_actionAdapter implements ActionListener {
    private StudentView adapter;

    StudentView_jBsave_actionAdapter(StudentView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBsave_actionPerformed(e);
    }
}