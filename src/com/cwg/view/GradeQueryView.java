package com.cwg.view;

import com.cwg.util.RetrieveObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class GradeQueryView extends JInternalFrame {

    BorderLayout borderLayout1 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    JPanel jPanel1 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JLabel jLabel2 = new JLabel();
    JComboBox jComboBox1 = new JComboBox();
    JLabel jLabel3 = new JLabel();
    JComboBox jComboBox2 = new JComboBox();
    JButton jByes = new JButton();
    JButton jBexit = new JButton();

    String classid[] = null;
    String classname[] = null;
    String examkindid[] = null;
    String examkindname[] = null;
    JLabel jLabel1 = new JLabel();

    public GradeQueryView () {
        try {
            jbInit();
            this.initialize();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    private void jbInit() throws Exception {
        getContentPane().setLayout(borderLayout1);
        this.setClosable(true);
        jByes.addActionListener(new GradeQueryView_jByes_actionAdapter(this));
        jBexit.addActionListener(new GradeQueryView_jBexit_actionAdapter(this));
        jComboBox1.addItemListener(new GradeQueryView_jComboBox1_itemAdapter(this));
        jComboBox2.addItemListener(new GradeQueryView_jComboBox2_itemAdapter(this));

        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jLabel1.setForeground(Color.red);
        this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);

        jPanel1.setLayout(flowLayout1);
        jLabel2.setToolTipText("");
        jLabel2.setText("考试类别");
        jLabel3.setText("所属班级");
        jByes.setText("确定");
        jBexit.setText("退出");
        jPanel1.add(jLabel2);
        jPanel1.add(jComboBox1);
        jPanel1.add(jLabel3);
        jPanel1.add(jComboBox2);
        jPanel1.add(jByes);
        jPanel1.add(jBexit);

        this.getContentPane().add(jLabel1, java.awt.BorderLayout.SOUTH);

        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        this.setSize(680, 460);
        this.setVisible(true);
    }

    public void initialize() {
        RetrieveObject retrieve = new RetrieveObject();
        Vector vdata = new Vector();
        String sqlStr = null;
        Collection collection = null;
        Iterator iterator = null;
        sqlStr = "select * from tb_examkind";
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        examkindid = new String[collection.size()];
        examkindname = new String[collection.size()];
        int i = 0;
        while (iterator.hasNext()) {
            vdata = (java.util.Vector) iterator.next();
            examkindid[i] = String.valueOf(vdata.get(0));
            examkindname[i] = String.valueOf(vdata.get(1));
            jComboBox1.addItem(vdata.get(1));
            i++;
        }
        sqlStr = "select * from tb_class";
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        classid = new String[collection.size()];
        classname = new String[collection.size()];
        i = 0;
        while (iterator.hasNext()) {
            vdata = (java.util.Vector) iterator.next();
            classid[i] = String.valueOf(vdata.get(0));
            classname[i] = String.valueOf(vdata.get(2));
            jComboBox2.addItem(vdata.get(2));
            i++;
        }

    }

    private void updateModel () {
        String sqlSubject = null;
        java.util.Collection collection = null;
        Object[] object = null;
        java.util.Iterator iterator = null;
        sqlSubject = "select * from tb_subject where kindID = '" + examkindid[jComboBox1.getSelectedIndex()] + "'";

        RetrieveObject retrieve = new RetrieveObject();
        collection = retrieve.getTableCollection(sqlSubject);
        object = collection.toArray();
        String strCode[] = new String[object.length];
        String strSubject[] = new String[object.length];
        String[] tbname = new String[object.length + 2];
        tbname[0] = "学生编号";
        tbname[1] = "学生姓名";
        String sqlStr = "SELECT stuID, stuName, ";
        for (int i = 0; i < object.length; i++) {
            String code = null, subject = null;
            java.util.Vector vdata = null;
            vdata = (java.util.Vector) object[i];
            code = String.valueOf(vdata.get(0));
            subject = String.valueOf(vdata.get(1));
            tbname[i + 2] = subject;
            if ((i + 1) == object.length) {
                sqlStr = sqlStr + " SUM(CASE subID WHEN '" + code + "' THEN grade ELSE 0 END) AS '"
                        + subject + "'";
            } else {
                sqlStr = sqlStr + " SUM(CASE subID WHEN '" + code + "' THEN grade ELSE 0 END) AS '"
                        + subject + "',";
            }
        }
        String whereStr = " where kind";
        // 为变量whereStr进行赋值操作生成查询的SQL语句
        whereStr = " where kindID = '" + this.examkindid[jComboBox1.getSelectedIndex()] + "' and classID = '"
                + this.classid[jComboBox2.getSelectedIndex()] + "' ";

        // 为变量sqlStr进行赋值操作生成查询的SQL语句
        sqlStr = sqlStr + " from tb_grade_sub " + whereStr + " group by stuID,stuName";
        DefaultTableModel tablemodel = null;
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(tbname, sqlStr); // 通过对象bdt的getTableModel方法为表格赋值
        jTable1.setModel(tablemodel);
        if (jTable1.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "没有找到满足条件的数据!!!", "系统提示",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        jTable1.setRowHeight(24);
        jLabel1.setText("共有数据【" + String.valueOf(jTable1.getRowCount()) + "】条");
    }

    public void jByes_actionPerformed(ActionEvent e) {
        updateModel();
    }


    public void jComboBox1_itemStateChanged (ItemEvent e) {
        if (jTable1.getRowCount() > 0) {
            updateModel();
        }
    }

    public void jComboBox2_itemStateChanged (ItemEvent e) {
        if (jTable1.getRowCount() > 0) {
            updateModel();
        }
    }

    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否退出学生成绩明细信息查询?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }

    }
}

class GradeQueryView_jBexit_actionAdapter implements ActionListener {
    private GradeQueryView adapter;

    GradeQueryView_jBexit_actionAdapter(GradeQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBexit_actionPerformed(e);
    }
}

class GradeQueryView_jByes_actionAdapter implements ActionListener {
    private GradeQueryView adapter;

    GradeQueryView_jByes_actionAdapter(GradeQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jByes_actionPerformed(e);
    }
}

class GradeQueryView_jComboBox1_itemAdapter implements ItemListener  {

    private GradeQueryView adapter;

    GradeQueryView_jComboBox1_itemAdapter(GradeQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        adapter.jComboBox1_itemStateChanged(e);
    }
}

class GradeQueryView_jComboBox2_itemAdapter implements ItemListener  {

    private GradeQueryView adapter;

    GradeQueryView_jComboBox2_itemAdapter(GradeQueryView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        adapter.jComboBox2_itemStateChanged(e);
    }
}