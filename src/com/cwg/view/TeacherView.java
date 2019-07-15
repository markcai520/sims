package com.cwg.view;

import com.cwg.dao.impl.ClassDaoImpl;
import com.cwg.dao.impl.TeacherDaoImpl;
import com.cwg.util.FontAndColor;
import com.cwg.util.RetrieveObject;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TeacherView extends JInternalFrame {
    BorderLayout borderLayout1 = new BorderLayout();
    JSplitPane jSplitPane1 = new JSplitPane();
    JPanel jPanel1 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
    JPanel jPanel3 = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JLabel jLabel3 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JTextField jTextField3 = new JTextField();
    JLabel jLabel6 = new JLabel();
    JComboBox jComboBox3 = new JComboBox();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    JButton jBrefresh = new JButton();
    JButton jBexit = new JButton();
    JButton jBdel = new JButton();
    JComboBox jComboBox2 = new JComboBox();
    JComboBox jComboBox4 = new JComboBox();
    JComboBox jComboBox1 = new JComboBox();
    String classid[] = null;

    public TeacherView () {
        try {
            jbInit();
            build();
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
        jBadd.setText("添加");
        jBadd.addActionListener(new TeacherView_jBadd_actionAdapter(this));
        jBsave.setMnemonic('0');
        jBsave.setText("修改");
        jBsave.addActionListener(new TeacherView_jBsave_actionAdapter(this));
        jPanel3.setLayout(gridLayout1);
        gridLayout1.setColumns(4);
        gridLayout1.setRows(3);
        jLabel3.setText("教师编号");
        jTextField1.setText("");
        jLabel4.setText("班级名称");
        jLabel5.setText("教师姓名");
        jTextField3.setText("");
        jLabel6.setText("性别");
        jLabel8.setText("教师等级");
        jLabel9.setText("教师职称");
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jBrefresh.setText("刷新");
        jBrefresh.addActionListener(new TeacherView_jBrefresh_actionAdapter(this));
        jBexit.setText("退出");
        jBexit.addActionListener(new TeacherView_jBexit_actionAdapter(this));
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        this.setClosable(true);
        jBdel.setText("删除");
        jBdel.addActionListener(new TeacherView_jBdel_actionAdapter(this));
        jTable1.addMouseListener(new TeacherView_jTable1_mouseAdapter(this));
        jPanel1.add(jBrefresh);
        jPanel1.add(jBadd);
        jPanel1.add(jBdel);
        jPanel1.add(jBsave);
        jPanel1.add(jBexit);
        jSplitPane1.add(jPanel3, JSplitPane.BOTTOM);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField1);
        jPanel3.add(jLabel4);
        jPanel3.add(jComboBox1);
        jPanel3.add(jLabel5);
        jPanel3.add(jTextField3);
        jPanel3.add(jLabel6);
        jPanel3.add(jComboBox3);
        jPanel3.add(jLabel9);
        jPanel3.add(jComboBox2);
        jPanel3.add(jLabel8);
        jPanel3.add(jComboBox4);
        jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
        this.getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        setSize(640, 440);
        setVisible(true);
        jSplitPane1.setDividerLocation(256);
    }

    public void build() {

        DefaultTableModel tablemodel = null;
        String[] name = { "教师编号", "班级编号", "教师姓名", "性别", "教师职称", "教师等级" };
        String sqlStr = "select * from tb_teacher";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr);
        jTable1.setModel(tablemodel);
        jTable1.setRowHeight(24);

        jComboBox1.removeAllItems();
        RetrieveObject retrieve = new RetrieveObject();
        java.util.Vector vdata = new java.util.Vector();
        java.util.Collection collection = null;
        java.util.Iterator iterator = null;

        String sqlStr1 = null;
        sqlStr1 = "select  distinct className from tb_class";
        collection = retrieve.getTableCollection(sqlStr1);
        iterator = collection.iterator();
        classid = new String[collection.size()];
        int i = 0;
        while (iterator.hasNext()) {
            vdata = (Vector) iterator.next();
//            classid[i] = String.valueOf(vdata.get(0));
            jComboBox1.addItem(vdata.get(0));
            i++;
        }

        jTextField1.setText("");
        jTextField3.setText("");

        jComboBox2.removeAllItems();
        jComboBox2.addItem("讲师");
        jComboBox2.addItem("副教授");
        jComboBox2.addItem("教授");

        jComboBox3.removeAllItems();
        jComboBox3.addItem("男");
        jComboBox3.addItem("女");

        jComboBox4.removeAllItems();
        jComboBox4.addItem("初级");
        jComboBox4.addItem("中级");
        jComboBox4.addItem("高级");
    }

    public void jBadd_actionPerformed(ActionEvent e) {

        String teaID = jTextField1.getText().trim();

        if (teaID == null || teaID.equals("")) {
            JLabel label = new JLabel ("教师ID不能为空");
            label.setFont(FontAndColor.errorFont());
            label.setForeground(FontAndColor.errorColor());
            JOptionPane.showMessageDialog(this,label);
            return;
        }


        String className = jComboBox1.getSelectedItem().toString();


        String classID = new ClassDaoImpl().queryIdByName(className);
        String teaName = jTextField3.getText().trim();
        String sex = jComboBox3.getSelectedItem().toString();
        String knowledge = jComboBox2.getSelectedItem().toString();
        String level = jComboBox4.getSelectedItem().toString();

        if (new TeacherDaoImpl().queryById(teaID)) {
            JOptionPane.showMessageDialog(this,"编号为" + teaID + "的教师已存在");
            jTextField1.setText("");
            return;
        }

        if (teaName == null || teaName.equals("")) {
            JOptionPane.showMessageDialog(this,"教师姓名不能为空");
            return;
        }

        int result = JOptionPane.showOptionDialog(null, "是否添加教师基本数据信息?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;

        boolean flag = new TeacherDaoImpl().insert(teaID,classID,teaName,sex,knowledge,level);

        if (flag) {
            JOptionPane.showMessageDialog(this,"添加成功");
            build();
            return;
        }else {
            JOptionPane.showMessageDialog(this,"添加失败");
            return;
        }
    }

    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否退出教师基本信息管理?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }

    }

    public void jBsave_actionPerformed(ActionEvent e) {

        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this,"请单击表格选择要修改的教师信息");
            return;
        }

        int result = JOptionPane.showOptionDialog(null, "是否修改教师基本数据信息?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;
        String teaID = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
        String classID = jTable1.getValueAt(jTable1.getSelectedRow(),1).toString();
        String teaName = jTextField3.getText().trim();
        String sex = jComboBox3.getSelectedItem().toString();
        String knowlegde = jComboBox2.getSelectedItem().toString();
        String level = jComboBox4.getSelectedItem().toString();

        if (teaID == null || teaID.equals("")) {
            JOptionPane.showMessageDialog(this,"教师编号不可为空");
            return;
        }
        boolean flag = new TeacherDaoImpl().update(teaID,classID,teaName,sex,knowlegde,level);

        if (flag) {
            JOptionPane.showMessageDialog(this,"修改编号为" + teaID + "的教师信息成功");
            build();
            return;
        }else {
            JOptionPane.showMessageDialog(this,"修改编号为" + teaID + "的教师信息失败");
        }

    }

    public void jBrefresh_actionPerformed(ActionEvent e) {
        build();
    }

    public void jBdel_actionPerformed(ActionEvent e) {
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this,"请单击表格选择要删除的教师信息");
            return;
        }
        int result = JOptionPane.showOptionDialog(null, "是否删除教师的基本信息数据?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;

        String teaID = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();

        boolean flag = new TeacherDaoImpl().delete(teaID);

        if (flag) {
            JOptionPane.showMessageDialog(this,"删除编号" + teaID + "的教师信息成功");
            build();
            return;
        } else {
            JOptionPane.showMessageDialog(this,"删除编号" + teaID + "的教师信息失败");
            return;
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
        sqlStr = "select * from tb_teacher where teaID = '" + id + "'";
        java.util.Vector vdata = null;
        RetrieveObject retrive = new RetrieveObject();
        vdata = retrive.getObjectRow(sqlStr);
        String gradeid = null, classid = null;
        String gradename = null, classname = null;
        java.util.Vector vname = null;
        classid = vdata.get(1).toString();
        vname = retrive.getObjectRow("select className from tb_class where classID = '" + classid + "'");
        classname = String.valueOf(vname.get(0));

        jTextField1.setText(vdata.get(0).toString());
        jComboBox1.setSelectedItem(classname);
        jTextField3.setText(vdata.get(2).toString());
        jComboBox3.setSelectedItem(vdata.get(3).toString());
        jComboBox2.setSelectedItem(vdata.get(4).toString());
        jComboBox4.setSelectedItem(vdata.get(5).toString());
    }

}

class TeacherView_jTable1_mouseAdapter extends MouseAdapter {
    private TeacherView adapter;

    TeacherView_jTable1_mouseAdapter(TeacherView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        adapter.jTable1_mouseClicked(e);
    }
}

class TeacherView_jBdel_actionAdapter implements ActionListener {
    private TeacherView adapter;

    TeacherView_jBdel_actionAdapter(TeacherView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBdel_actionPerformed(e);
    }
}

class TeacherView_jBrefresh_actionAdapter implements ActionListener {
    private TeacherView adapter;

    TeacherView_jBrefresh_actionAdapter(TeacherView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBrefresh_actionPerformed(e);
    }
}

class TeacherView_jBexit_actionAdapter implements ActionListener {
    private TeacherView adapter;

    TeacherView_jBexit_actionAdapter(TeacherView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBexit_actionPerformed(e);
    }
}

class TeacherView_jBadd_actionAdapter implements ActionListener {
    private TeacherView adapter;

    TeacherView_jBadd_actionAdapter(TeacherView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBadd_actionPerformed(e);
    }
}

class TeacherView_jBsave_actionAdapter implements ActionListener {
    private TeacherView adapter;

    TeacherView_jBsave_actionAdapter(TeacherView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBsave_actionPerformed(e);
    }
}
