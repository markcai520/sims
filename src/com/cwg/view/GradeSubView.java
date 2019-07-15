package com.cwg.view;

import com.cwg.dao.impl.ExamKindDaoImpl;
import com.cwg.dao.impl.GradeSubDaoImpl;
import com.cwg.dao.impl.SubjectDaoImpl;
import com.cwg.model.GradeSubBean;
import com.cwg.util.FontAndColor;
import com.cwg.util.RetrieveObject;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.*;

public class GradeSubView extends JInternalFrame {
    BorderLayout borderLayout1 = new BorderLayout();
    JSplitPane jSplitPane1 = new JSplitPane();
    JScrollPane jScrollPane2 = new JScrollPane();
    JPanel jPanel2 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JTable jTable1 = new JTable();
    JLabel jLabel1 = new JLabel();
    JComboBox jComboBox1 = new JComboBox();
    JLabel jLabel2 = new JLabel();
    JComboBox jComboBox2 = new JComboBox();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
//    JButton jBexit = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable2 = new JTable();
    String classid[] = null;
    String examkindid[] = null;
    String examkindname[] = null;
    String subjectcode[] = null;
    String subjectname[] = null;
    JLabel jLabel3 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JButton jBdel = new JButton();

    public GradeSubView () {
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
        jSplitPane1.setDividerSize(10);
        jPanel2.setLayout(flowLayout1);
        jLabel1.setText("选择班级:");
        jLabel2.setText("考试种类:");
        jBadd.setText("修改");
        jBadd.addActionListener(new GradeSubView_jBadd_actionAdapter(this));
        jBsave.setText("保存");
        jBsave.addActionListener(new GradeSubView_jBsave_actionAdapter(this));
//        jBexit.setText("退出");
//        jBexit.addActionListener(new GradeSubView_jBexit_actionAdapter(this));
        this.setClosable(true);
        jComboBox1.addItemListener(new GradeSubView_jComboBox1_itemAdapter(this));
        jComboBox2.addItemListener(new GradeSubView_jComboBox2_itemAdapter(this));
        jLabel3.setText("考试日期:");
        jTextField1.setPreferredSize(new Dimension(96, 26));
        jTextField1.setText("");
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jTable1.addMouseListener(new GradeSubView_jTable1_mouseAdapter(this));
        jBdel.setText("删除");
        jBdel.addActionListener(new GradeSubView_jBdel_actionAdapter(this));

        jSplitPane1.add(jScrollPane2, JSplitPane.TOP);
        jSplitPane1.add(jScrollPane1, JSplitPane.BOTTOM);
        jScrollPane1.getViewport().add(jTable2);
        jPanel2.add(jLabel3);
        jPanel2.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jComboBox1);
        jPanel2.add(jLabel1);
        jPanel2.add(jComboBox2);
        jPanel2.add(jBadd);
        jPanel2.add(jBdel);
        jPanel2.add(jBsave);
//        jPanel2.add(jBexit);
        jScrollPane2.getViewport().add(jTable1);
        this.getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        this.getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
        setSize(700, 500);
        setVisible(true);
        jTable2.setEnabled(false);
        jSplitPane1.setDividerLocation(200);
    }

    public void initialize() {

        RetrieveObject retrieve = new RetrieveObject();
        java.util.Vector vdata = new java.util.Vector();
        String sqlStr = null;
        java.util.Collection collection = null;
        java.util.Iterator iterator = null;
        sqlStr = "SELECT * FROM tb_examkind";
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
        i = 0;
        while (iterator.hasNext()) {
            vdata = (java.util.Vector) iterator.next();
            classid[i] = String.valueOf(vdata.get(0));
            jComboBox2.addItem(vdata.get(2));
            i++;
        }
        sqlStr = "select * from tb_subject";
        collection = retrieve.getTableCollection(sqlStr);
        iterator = collection.iterator();
        subjectcode = new String[collection.size()];
        subjectname = new String[collection.size()];
        i = 0;
        while (iterator.hasNext()) {
            vdata = (java.util.Vector) iterator.next();
            subjectcode[i] = String.valueOf(vdata.get(0));
            subjectname[i] = String.valueOf(vdata.get(1));

            i++;
        }
        long nCurrentTime = System.currentTimeMillis();
        java.util.Calendar calendar = java.util.Calendar.getInstance(new Locale("CN"));
        calendar.setTimeInMillis(nCurrentTime);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String mm, dd;
        if (month < 10) {
            mm = "0" + String.valueOf(month);
        } else {
            mm = String.valueOf(month);
        }
        if (day < 10) {
            dd = "0" + String.valueOf(day);
        } else {
            dd = String.valueOf(day);
        }
        java.sql.Date date = java.sql.Date.valueOf(year + "-" + mm + "-" + dd);
        jTextField1.setText(String.valueOf(date));
    }

    public void jComboBox1_itemStateChanged(ItemEvent e) {
        if (jTable1.getSelectedRow() >= 0) {
            DefaultTableModel tablemodel = null;
            String[] name = { "学生编号", "学生姓名", "考试类别", "考试科目", "考试成绩", "考试时间" };
            tablemodel = new DefaultTableModel(name, 0);

            String sqlStr = null;
            Collection collection = null;
            Object[] object = null;
            sqlStr = "SELECT * FROM tb_grade_sub where stuID = '" + jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "' and kindID = '"
                    + examkindid[jComboBox1.getSelectedIndex()] + "'";
            RetrieveObject retrieve = new RetrieveObject();


            collection = retrieve.getTableCollection(sqlStr);

            if (collection.size() == 0) {
                String stuName = jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
                String str = "<html><body>" + stuName + "的成绩尚未录入完全,请照如下步骤操作<br>1.单击表格选中学生信息<br>2.点击上方修改按钮<br>3.正确录入学生成绩<br>4.点击上方保存按钮保存成绩信息</body></html>";

                JLabel labelTip = new JLabel(str);
                labelTip.setFont(FontAndColor.tipFont());
                labelTip.setForeground(FontAndColor.tipColor());
                JOptionPane.showMessageDialog(this,labelTip,"操作提示",1);
            }

            object = collection.toArray();

            int findindex = 0;
            for (int i = 0; i < object.length; i++) {
                Vector vrow = new Vector();
                Vector vdata = (Vector) object[i];
                String sujcode = String.valueOf(vdata.get(3));
                for (int aa = 0; aa < this.subjectcode.length; aa++) {
                    if (sujcode.equals(subjectcode[aa])) {
                        findindex = aa;
                    }
                }
                if (i == 0) {
                    vrow.addElement(vdata.get(0));
                    vrow.addElement(vdata.get(1));
                    vrow.addElement(examkindname[Integer.parseInt(String.valueOf(vdata.get(2)).substring(4)) - 1]);
                    vrow.addElement(subjectname[findindex]);
                    vrow.addElement(vdata.get(4));
                    String ksrq = String.valueOf(vdata.get(5));
                    ksrq = ksrq.substring(0, 10);
                    vrow.addElement(ksrq);
                } else {
                    vrow.addElement("");
                    vrow.addElement("");
                    vrow.addElement("");
                    vrow.addElement(subjectname[findindex]);
                    vrow.addElement(vdata.get(4));
                    String ksrq = String.valueOf(vdata.get(5));
                    ksrq = ksrq.substring(0, 10);
                    vrow.addElement(ksrq);
                }
                tablemodel.addRow(vrow);
            }
            this.jTable2.setModel(tablemodel);
            jTable2.setEnabled(false);
            this.jTable2.setRowHeight(22);
        }
    }

    public void jComboBox2_itemStateChanged(ItemEvent e) {
        String cid = classid[jComboBox2.getSelectedIndex()];
        DefaultTableModel tablemodel = null;
        String[] name = { "学生编号", "班级编号", "学生姓名", "性别", "年龄", "家庭住址", "联系电话" };
        String sqlStr = "select * from tb_student where classID = '" + cid + "'";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr);
        jTable1.setModel(tablemodel);
        jTable1.setRowHeight(24);
    }

    public void jBadd_actionPerformed(ActionEvent e) {
        int currow;
        currow = jTable1.getSelectedRow();

        if (currow < 0) {
            JOptionPane.showMessageDialog(this,"请先单击表格选择学生信息！");
            return;
        }

        jTable2.setEnabled(true);

        if (currow >= 0) {
            DefaultTableModel tablemodel = null;
            String[] name = { "学生编号", "学生姓名", "考试类别", "考试科目", "考试成绩", "考试时间" };
            tablemodel = new DefaultTableModel(name, 0);
            String sqlStr = null;
            Collection collection = null;
            Object[] object = null;
            Iterator iterator = null;
            sqlStr = "SELECT subject FROM tb_subject where kindID = '" + examkindid[jComboBox1.getSelectedIndex()] + "'"; // 定义查询参数
            RetrieveObject retrieve = new RetrieveObject();
            Vector vdata = null;
            vdata = retrieve.getObjectRow(sqlStr);
            for (int i = 0; i < vdata.size(); i++) {
                Vector vrow = new Vector();
                if (i == 0) {
                    vrow.addElement(jTable1.getValueAt(currow, 0));
                    vrow.addElement(jTable1.getValueAt(currow, 2));
                    vrow.addElement(jComboBox1.getSelectedItem());
                    vrow.addElement(vdata.get(i));
                    vrow.addElement("");
                    vrow.addElement(jTextField1.getText().trim());
                } else {
                    vrow.addElement("");
                    vrow.addElement("");
                    vrow.addElement("");
                    vrow.addElement(vdata.get(i));
                    vrow.addElement("");
                    vrow.addElement(jTextField1.getText().trim());
                }
                tablemodel.addRow(vrow);
                this.jTable2.setModel(tablemodel);
                this.jTable2.setRowHeight(23);
            }
        }
    }

    public void jBsave_actionPerformed(ActionEvent e) {

        int currow = jTable1.getSelectedRow();
        if (currow < 0) {
            JOptionPane.showMessageDialog(this,"您尚未选择学生信息");
            return;
        }

        /*int result = JOptionPane.showOptionDialog(null, "是否保存学生考试成绩数据?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;*/

        int count = jTable2.getRowCount();


        if (count <= 0) {
            JLabel label = new JLabel("<html><body>请照如下步骤操作<br>1.单击表格选择学生信息<br>2.点击修改按钮</body></html>");
            label.setForeground(FontAndColor.tipColor());
            label.setFont(FontAndColor.tipFont());
            JOptionPane.showMessageDialog(this,label);
            return;
        }

        String stuID = jTable2.getValueAt(0,0).toString();
        String stuName = jTable2.getValueAt(0,1).toString();
        String classID = jTable1.getValueAt(jTable1.getSelectedRow(),1).toString();
        String kindName = jTable2.getValueAt(0,2).toString();
        String kindID = new ExamKindDaoImpl().queryIdByName(kindName);
        String [] subjects = new String [count];
        String [] subIDs = new String [count];
        String [] gradeStr = new String[count];
        double [] grades = new double[count];

        SubjectDaoImpl subjectDao = new SubjectDaoImpl();

        for (int i = 0; i < subjects.length; i ++) {
            subjects[i] = jTable2.getValueAt(i,3).toString();
            subIDs[i] = subjectDao.queryIdByName(subjects[i]);
            gradeStr[i] = jTable2.getValueAt(i,4).toString();
        }

        int j = 0;
        try {
            for (j = 0; j < count; j ++) {
                grades[j] = Double.parseDouble(gradeStr[j]);
            }
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(this,"第" + (j+1) + "行成绩有误");
            return;
        }

        GradeSubDaoImpl gradeSubDao = new GradeSubDaoImpl();

        if (gradeSubDao.queryById(stuID,kindID)) {
            for (int i = 0; i < count; i ++) {
                boolean flag = gradeSubDao.update(stuID,kindID,subIDs[i],grades[i]);
                if (!flag) {
                    JOptionPane.showMessageDialog(this,"更新" + subjects[i] + "成绩时出错");
                    return;
                }
            }
        } else {
            for (int i = 0; i < count; i ++) {
                boolean flag = gradeSubDao.insert(stuID,stuName,kindID,subIDs[i],grades[i],classID);
                if (!flag) {
                    JOptionPane.showMessageDialog(this,"更新" + subjects[i] + "的成绩时出错");
                }
            }
        }

        JOptionPane.showMessageDialog(this,"修改成功","成功提示",1);

    }
//    public void jBexit_actionPerformed(ActionEvent e) {
//        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
//        int result = JOptionPane.showOptionDialog(null, "是否退出学生考试成绩管理?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
//                "是", "否" }, "否");
//        if (result == JOptionPane.YES_OPTION) {
//            manger.closeFrame(this);
//        }
//    }

    public void jTable1_mouseClicked(MouseEvent e) {
        int currow = jTable1.getSelectedRow();
        if (currow < 0) {
            JOptionPane.showMessageDialog(this,"请先单击表格选择学生信息");
            return;
        }
        if (currow >= 0) {

            DefaultTableModel tablemodel = null;
            String[] name = { "学生编号", "学生姓名", "考试类别", "考试科目", "考试成绩", "考试时间" };
            tablemodel = new DefaultTableModel(name, 0);

            String sqlStr = null;
            Collection collection = null;
            Object[] object = null;
            sqlStr = "SELECT * FROM tb_grade_sub where stuID = '" + jTable1.getValueAt(currow, 0) + "' and kindID = '"
                    + examkindid[jComboBox1.getSelectedIndex()] + "'";
            RetrieveObject retrieve = new RetrieveObject();


            collection = retrieve.getTableCollection(sqlStr);

            if (collection.size() == 0) {
                String stuName = jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
                String str = "<html><body>" + stuName + "的成绩尚未录入完全,请照如下步骤操作<br>1.单击表格选中学生信息<br>2.点击上方修改按钮<br>3.正确录入学生成绩<br>4.点击上方保存按钮保存成绩信息</body></html>";

                JLabel labelTip = new JLabel(str);
                labelTip.setFont(FontAndColor.tipFont());
                labelTip.setForeground(FontAndColor.tipColor());
                JOptionPane.showMessageDialog(this,labelTip,"操作提示",1);
            }

            object = collection.toArray();

            int findindex = 0;
            for (int i = 0; i < object.length; i++) {
                Vector vrow = new Vector();
                Vector vdata = (Vector) object[i];
                String sujcode = String.valueOf(vdata.get(3));
                for (int aa = 0; aa < this.subjectcode.length; aa++) {
                    if (sujcode.equals(subjectcode[aa])) {
                        findindex = aa;
                    }
                }
                if (i == 0) {
                    vrow.addElement(vdata.get(0));
                    vrow.addElement(vdata.get(1));
                    vrow.addElement(examkindname[Integer.parseInt(String.valueOf(vdata.get(2)).substring(4)) - 1]);
                    vrow.addElement(subjectname[findindex]);
                    vrow.addElement(vdata.get(4));
                    String ksrq = String.valueOf(vdata.get(5));
                    ksrq = ksrq.substring(0, 10);
                    vrow.addElement(ksrq);
                } else {
                    vrow.addElement("");
                    vrow.addElement("");
                    vrow.addElement("");
                    vrow.addElement(subjectname[findindex]);
                    vrow.addElement(vdata.get(4));
                    String ksrq = String.valueOf(vdata.get(5));
                    ksrq = ksrq.substring(0, 10);
                    vrow.addElement(ksrq);
                }
                tablemodel.addRow(vrow);
            }
            this.jTable2.setModel(tablemodel);
            jTable2.setEnabled(false);
            this.jTable2.setRowHeight(22);
        }
    }

    public void jBdel_actionPerformed(ActionEvent e) {

        int currow = jTable1.getSelectedRow();

        if (currow < 0) {
            JLabel label = new JLabel("请先单击表格选择学生数据");
            label.setFont(FontAndColor.errorFont());
            label.setForeground(FontAndColor.errorColor());
            JOptionPane.showMessageDialog(this,label,"错误提示",1);
            return;
        }

        int rcount = jTable2.getRowCount();
        if (rcount > 0) {
            int result = JOptionPane.showOptionDialog(null, "是否删除学生【" + jTable2.getValueAt(0, 1) + "】的考试成绩数据?", "系统提示", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, new String[] { "是", "否" }, "否");
            if (result == JOptionPane.NO_OPTION)
                return;
        }
        String stuID = jTable2.getValueAt(0,0).toString();

        boolean flag = new GradeSubDaoImpl().delete(stuID);
        if (flag) {
            JLabel label = new JLabel("已删除" + jTable2.getValueAt(0,1).toString() + "的成绩信息");
            label.setForeground(FontAndColor.successColor());
            label.setFont(FontAndColor.successFont());
            JOptionPane.showMessageDialog(this,label,"成功提示",1);
            return;
        } else {
            JLabel label = new JLabel("删除" + jTable2.getValueAt(0,1).toString() + "的成绩失败");
            label.setForeground(FontAndColor.errorColor());
            label.setFont(FontAndColor.errorFont());
            JOptionPane.showMessageDialog(this,label,"错误提示",1);
        }
    }


}
class GradeSubView_jBdel_actionAdapter implements ActionListener {
    private GradeSubView adapter;

    GradeSubView_jBdel_actionAdapter(GradeSubView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBdel_actionPerformed(e);
    }
}

class GradeSubView_jTable1_mouseAdapter extends MouseAdapter {
    private GradeSubView adapter;

    GradeSubView_jTable1_mouseAdapter(GradeSubView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        adapter.jTable1_mouseClicked(e);
    }
}

//class GradeSubView_jBexit_actionAdapter implements ActionListener {
//    private GradeSubView adapter;
//
//    GradeSubView_jBexit_actionAdapter(GradeSubView adapter) {
//        this.adapter = adapter;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        adapter.jBexit_actionPerformed(e);
//    }
//}

class GradeSubView_jBsave_actionAdapter implements ActionListener {
    private GradeSubView adapter;

    GradeSubView_jBsave_actionAdapter(GradeSubView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBsave_actionPerformed(e);
    }
}

class GradeSubView_jBadd_actionAdapter implements ActionListener {
    private GradeSubView adapter;

    GradeSubView_jBadd_actionAdapter(GradeSubView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBadd_actionPerformed(e);
    }
}

class GradeSubView_jComboBox2_itemAdapter implements ItemListener {
    private GradeSubView adapter;

    GradeSubView_jComboBox2_itemAdapter(GradeSubView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        adapter.jComboBox2_itemStateChanged(e);
    }
}

class GradeSubView_jComboBox1_itemAdapter implements ItemListener {
    private GradeSubView adapter;

    GradeSubView_jComboBox1_itemAdapter(GradeSubView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        adapter.jComboBox1_itemStateChanged(e);
    }
}