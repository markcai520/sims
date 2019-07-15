package com.cwg.view;

import com.cwg.dao.impl.ClassDaoImpl;
import com.cwg.dao.impl.GradeDaoImpl;
import com.cwg.util.RetrieveObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;


public class ClassView extends JInternalFrame{

    BorderLayout borderLayout1 = new BorderLayout();
    JSplitPane jSplitPane1 = new JSplitPane();
    JScrollPane jScrollPane1 = new JScrollPane();
    JPanel jPanel1 = new JPanel();
    JTable jTable1 = new JTable();
    GridLayout gridLayout1 = new GridLayout();
    JLabel jLabel2 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JLabel jLabel1 = new JLabel();
    JTextField jTextField2 = new JTextField();
    JPanel jPanel2 = new JPanel();
    JButton jBdel = new JButton();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
    JButton jBexit = new JButton();
    JLabel jLabel3 = new JLabel();
    JComboBox jComboBox1 = new JComboBox();
    String gradeID[] = null;
    // 添加变量用来控制状态
    boolean insertflag = true;
    JTextField jTextField3 = new JTextField();
    JLabel jLabel4 = new JLabel();

    public ClassView () {
        // buildTable();
        this.getContentPane().setLayout(borderLayout1);
        setSize(420, 340);
        this.setClosable(true);
        setVisible(true);
        gridLayout1.setColumns(2);
        gridLayout1.setRows(3);
        jLabel1.setText("年级名称");
        jTextField1.setText("");
        jLabel2.setText("班级编号");
        jTextField2.setText("");
        jBdel.setText("删除");
        jBdel.addActionListener(new ClassView_jBdel_actionAdapter(this));
        jPanel2.setLayout(flowLayout1);
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jBadd.setText("添加");
        jBadd.addActionListener(new ClassView_jBadd_actionAdapter(this));
        jBsave.setText("修改");
        jBsave.addActionListener(new ClassView_jButton3_actionAdapter(this));
        jBexit.setText("退出");
        jBexit.addActionListener(new ClassView_jBexit_actionAdapter(this));
        jTable1.addMouseListener(new ClassView_jTable1_mouseAdapter(this));
        jLabel3.setText("班级名称");
        jComboBox1.addItemListener(new ClassView_jComboBox1_itemAdapter(this));
        jLabel4.setText("选择年级");
        this.getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jPanel1.setLayout(gridLayout1);
        jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
        jScrollPane1.setViewportView(jTable1);
        jSplitPane1.add(jPanel1, JSplitPane.BOTTOM);
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel1.add(jLabel2);
        jPanel1.add(jTextField2);
        jPanel1.add(jLabel3);
        jPanel1.add(jTextField3);
        jPanel2.add(jLabel4);
        jPanel2.add(jComboBox1);
        jPanel2.add(jBdel);
        jPanel2.add(jBadd);
        jPanel2.add(jBsave);
        jPanel2.add(jBexit);
        this.getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);
        jSplitPane1.setDividerLocation(164);

        buildTable();
        initJcombox();
    }

    private void buildTable() {
        DefaultTableModel tablemodel = null; // 设置表格模型变量
        String[] name = { "班级编号", "年级编号", "班级名称" }; // 设置表头数组
        String sqlStr = "select * from tb_class";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr); // 调用getTableModel方法获取一个表格模型实例
        jTable1.setModel(tablemodel); // 将表格模型放置在表格中
        jTable1.setRowHeight(24); // 设置表格的行高为24
    }

    private void buildTable(String gradeID) {
        DefaultTableModel tablemodel = null; // 设置表格模型变量
        String[] name = { "班级编号", "年级编号", "班级名称" }; // 设置表头数组
        String sqlStr = "select * from tb_class where gradeID = '" + gradeID + "'";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr); // 调用getTableModel方法获取一个表格模型实例
        jTable1.setModel(tablemodel); // 将表格模型放置在表格中
        jTable1.setRowHeight(24); // 设置表格的行高为24
    }

    private void initJcombox() {
        String sqlStr = null;
        sqlStr = "select gradeID,gradeName from tb_grade";

        RetrieveObject retrieve = new RetrieveObject();
        java.util.Collection collection = null;
        java.util.Iterator iterator = null;
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        gradeID = new String[collection.size()];
        int i = 0;
        jComboBox1.removeAllItems();
        while (iterator.hasNext()) {
            java.util.Vector vdata = (java.util.Vector) iterator.next();
            gradeID[i] = String.valueOf(vdata.get(0));
            jComboBox1.addItem(vdata.get(1));
            i++;
        }
    }

    public void jBsave_actionPerformed(ActionEvent e) {

        String gradeName = jTextField1.getText().trim();
        String classID = jTextField2.getText().trim();
        String className = jTextField3.getText().trim();

        GradeDaoImpl gradeDao = new GradeDaoImpl();

        String gradeID = gradeDao.queryIdByName(gradeName);

        if (gradeID == null) {
            JOptionPane.showMessageDialog(this,"年级表中没有名为" + gradeName + "的年级！");
            jTextField1.setText("");
        } else {
            ClassDaoImpl classDao = new ClassDaoImpl();
            boolean flag = classDao.queryById(classID,gradeID);

            if (!flag) {
                JOptionPane.showMessageDialog(this,"不存在编号为" + classID + "的班级");
                jTextField2.setText("");
            } else {
                boolean flag1 = classDao.update(gradeID,classID,className);
                if (flag1) {
                    JOptionPane.showMessageDialog(this,"修改成功");
                    buildTable();
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                }
            }
        }

    }

    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否退出班级信息设置?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }

    }

    public void jBadd_actionPerformed(ActionEvent e) {

        String gradeName = jTextField1.getText().trim();
        String classID = jTextField2.getText().trim();
        String className = jTextField3.getText().trim();

        GradeDaoImpl gradeDao = new GradeDaoImpl();

        String gradeID = gradeDao.queryIdByName(gradeName);

        if (gradeID == null) {
            JOptionPane.showMessageDialog(this,"年级表中没有名为" + gradeName + "的年级！");
            jTextField1.setText("");
        } else {
            ClassDaoImpl classDao = new ClassDaoImpl();
            boolean flag = classDao.queryById(classID,gradeID);

            if (flag) {
                JOptionPane.showMessageDialog(this,"已存在编号为" + classID + "的班级");
                jTextField2.setText("");
            } else {
                boolean flag1 = classDao.insert(gradeID,classID,className);
                if (flag1) {
                    JOptionPane.showMessageDialog(this,"添加成功");
                    buildTable();
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                }
            }
        }
    }

    public void jTable1_mouseClicked(MouseEvent e) {
        insertflag = false;
        String id = null;
        String sqlStr = null;
        int selectrow = 0;
        selectrow = jTable1.getSelectedRow(); // 获取表格选定的行数
        if (selectrow < 0)
            return; // 如果该行数小于0，则返回
        id = jTable1.getValueAt(selectrow, 0).toString(); // 返回第selectrow行，第一列的单元格值
        // 根据班级ID内连接查询班级信息表与年级信息表中的基本信息
        sqlStr = "SELECT d.gradeName, c.classID, c.className FROM tb_class c INNER JOIN tb_grade d ON c.gradeID = d.gradeID"
                + " where c.classID = '" + id + "'";
        Vector vdata = null;
        RetrieveObject retrive = new RetrieveObject();
        vdata = retrive.getObjectRow(sqlStr); // 执行SQL语句返回一个集合
        // jComboBox1.removeAllItems();
        jTextField1.setText(vdata.get(0).toString());
        // jComboBox1.addItem(vdata.get(1));
        jTextField2.setText(vdata.get(1).toString());
        jTextField3.setText(vdata.get(2).toString());
    }

    public void jBdel_actionPerformed(ActionEvent e) {

        int result = JOptionPane.showOptionDialog(null, "是否删除班级信息数据?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;

        String gradeName = jTextField1.getText().trim();
        String classID = jTextField2.getText().trim();
        String gradeID = new GradeDaoImpl().queryIdByName(gradeName);

        if (gradeID != null) {
            ClassDaoImpl classDao = new ClassDaoImpl();
            boolean flag = classDao.delete(gradeID,classID);

            if (flag) {
                JOptionPane.showMessageDialog(this,"删除班级信息成功");
                buildTable();
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
            } else {
                JOptionPane.showMessageDialog(this,"删除信息失败");
            }
        } else {
            JOptionPane.showMessageDialog(this,"年级信息有误！");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        }

    }

    public void jComboBox1_itemStateChanged(ItemEvent e) {

        String gradeName = (String)jComboBox1.getSelectedItem();
        String gradeID = new GradeDaoImpl().queryIdByName(gradeName);
        buildTable(gradeID);
    }
    
}

class ClassView_jComboBox1_itemAdapter implements ItemListener {
    private ClassView adapter;

    ClassView_jComboBox1_itemAdapter(ClassView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        adapter.jComboBox1_itemStateChanged(e);
    }
}

class ClassView_jTable1_mouseAdapter extends MouseAdapter {
    private ClassView adapter;

    ClassView_jTable1_mouseAdapter(ClassView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        adapter.jTable1_mouseClicked(e);
    }
}

class ClassView_jBdel_actionAdapter implements ActionListener {
    private ClassView adapter;

    ClassView_jBdel_actionAdapter(ClassView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBdel_actionPerformed(e);
    }
}

class ClassView_jBadd_actionAdapter implements ActionListener {
    private ClassView adapter;

    ClassView_jBadd_actionAdapter(ClassView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBadd_actionPerformed(e);
    }
}

class ClassView_jBexit_actionAdapter implements ActionListener {
    private ClassView adapter;

    ClassView_jBexit_actionAdapter(ClassView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBexit_actionPerformed(e);
    }
}

class ClassView_jButton3_actionAdapter implements ActionListener {
    private ClassView adapter;

    ClassView_jButton3_actionAdapter(ClassView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        adapter.jBsave_actionPerformed(e);
    }
}

