package com.cwg.view;

import com.cwg.dao.impl.GradeDaoImpl;
import com.cwg.util.FontAndColor;
import com.cwg.util.RetrieveObject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GradeView extends JInternalFrame {

    BorderLayout borderLayout1 = new BorderLayout();
    JSplitPane jSplitPane1 = new JSplitPane();
    JScrollPane jScrollPane1 = new JScrollPane();
    JPanel jPanel1 = new JPanel();
    JTable jTable1 = new JTable();
    GridLayout gridLayout1 = new GridLayout();
    JLabel jLabel1 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JLabel jLabel2 = new JLabel();
    JTextField jTextField2 = new JTextField();
    JPanel jPanel2 = new JPanel();
    JButton jBdel = new JButton();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
    JButton jBexit = new JButton();

    public GradeView() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() {
        buildTable();
        this.getContentPane().setLayout(borderLayout1);
        setSize(380, 300);
        this.setClosable(true);
        setVisible(true);
        gridLayout1.setColumns(2);
        gridLayout1.setRows(2);
        jLabel1.setText("年级编号");
//        jTextField1.setEnabled(false);
        jTextField1.setText("");
        jLabel2.setText("年级名称");
        jTextField2.setText("");
        jBdel.setText("删除");
        jBdel.addActionListener(new GradeView_jBdel_actionAdapter(this));
        jPanel2.setLayout(flowLayout1);
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jBadd.setText("添加");
        jBadd.addActionListener(new GradeView_jBadd_actionAdapter(this));
        jBsave.setText("修改");
        jBsave.addActionListener(new GradeView_jButton3_actionAdapter(this));
        jBexit.setText("退出");
        jBexit.addActionListener(new GradeView_jBexit_actionAdapter(this));
        jTable1.addMouseListener(new GradeView_jTable1_mouseAdapter(this));
        
        this.getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jPanel1.setLayout(gridLayout1);
        jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
        jScrollPane1.getViewport().add(jTable1);
        jSplitPane1.add(jPanel1, JSplitPane.BOTTOM);
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel1.add(jLabel2);
        jPanel1.add(jTextField2);

        this.getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
        jPanel2.add(jBdel);
        jPanel2.add(jBadd);
        jPanel2.add(jBsave);
        jPanel2.add(jBexit);
        jSplitPane1.setDividerLocation(164);

        buildTable();
    }

    public void buildTable() {
        DefaultTableModel tablemodel = null;
        String[] name = { "年级编号", "年级名称" };
        String sqlStr = "select * from tb_grade";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr);
        jTable1.setModel(tablemodel);
        jTable1.setRowHeight(24);
    }

    public void jBsave_actionPerformed(ActionEvent e) {

        String gradeID = jTextField1.getText().trim();
        String gradeName = jTextField2.getText().trim();

        if (gradeID.equals("") || gradeID == null || gradeName == null || gradeName.equals("")) {
            JOptionPane.showMessageDialog(this,"ID或名称不能为空");
        } else {
            GradeDaoImpl gradeDao = new GradeDaoImpl();
            if (!gradeDao.queryByID(gradeID)) {
                JOptionPane.showMessageDialog(this,"ID为" + gradeID + "的年级不存在");
            } else {
                boolean flag = gradeDao.update(gradeID,gradeName);

                if (flag) {
                    JOptionPane.showMessageDialog(this,"修改成功");
                    buildTable();
                    jTextField1.setText("");
                    jTextField2.setText("");
                }else {
                    JOptionPane.showMessageDialog(this,"修改失败");
                }
            }
        }
    }

    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否退出年级信息设置?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }

    }

    public void jBadd_actionPerformed(ActionEvent e) {
        String gradeID = jTextField1.getText().trim();
        String gradeName = jTextField2.getText().trim();

        if (gradeID != null && !(gradeID.equals("")) && gradeName != null && !(gradeName.equals(""))) {
            boolean flag = new GradeDaoImpl().insert(gradeID,gradeName);

            if (flag) {
                JOptionPane.showMessageDialog(this,"添加成功");
                buildTable();
            }else {
                JOptionPane.showMessageDialog(this,"添加失败");
            }

        } else {
            JOptionPane.showMessageDialog(this,"ID或名称不能为空");
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
        sqlStr = "select * from tb_grade where gradeID = '" + id + "'";
        java.util.Vector vdata = null;
        RetrieveObject retrive = new RetrieveObject();
        vdata = retrive.getObjectRow(sqlStr);

        jTextField1.setText(vdata.get(0).toString());
        jTextField2.setText(vdata.get(1).toString());
    }

    public void jBdel_actionPerformed(ActionEvent e) {
        int result = JOptionPane.showOptionDialog(null, "是否删除年级信息数据?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;
        String id = jTextField1.getText().trim();
        GradeDaoImpl gradeDao = new GradeDaoImpl();
        boolean flag = gradeDao.delete(id);

        if (id != null && !(id.equals(""))) {
            if (flag) {
                JOptionPane.showMessageDialog(this,"已删除编号为" + id +"的年级");
                buildTable();
                jTextField1.setText("");
                jTextField2.setText("");
            } else {
                JLabel label = new JLabel("该年级信息已被其他表引用,无法删除");
                label.setForeground(FontAndColor.errorColor());
                label.setFont(FontAndColor.errorFont());
                JOptionPane.showMessageDialog(this,label);
            }
        } else {
            JOptionPane.showMessageDialog(this,"ID不能为空");
        }


    }
}

class GradeView_jTable1_mouseAdapter extends MouseAdapter {
    private GradeView adapter;

    GradeView_jTable1_mouseAdapter(GradeView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        adapter.jTable1_mouseClicked(e);
    }
}

class GradeView_jBdel_actionAdapter implements ActionListener {
    private GradeView adapter;

    GradeView_jBdel_actionAdapter(GradeView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBdel_actionPerformed(e);
    }
}

class GradeView_jBadd_actionAdapter implements ActionListener {
    private GradeView adapter;

    GradeView_jBadd_actionAdapter(GradeView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBadd_actionPerformed(e);
    }
}

class GradeView_jBexit_actionAdapter implements ActionListener {
    private GradeView adapter;

    GradeView_jBexit_actionAdapter(GradeView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBexit_actionPerformed(e);
    }
}

class GradeView_jButton3_actionAdapter implements ActionListener {
    private GradeView adapter;

    GradeView_jButton3_actionAdapter(GradeView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        adapter.jBsave_actionPerformed(e);
    }
}

