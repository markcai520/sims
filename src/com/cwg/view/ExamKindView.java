package com.cwg.view;

import com.cwg.dao.impl.ExamKindDaoImpl;
import com.cwg.util.FontAndColor;
import com.cwg.util.RetrieveObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExamKindView extends JInternalFrame{

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

    public ExamKindView () {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        buildTable();
        this.getContentPane().setLayout(borderLayout1);
        setSize(380, 300);
        this.setClosable(true);
        setVisible(true);
        gridLayout1.setColumns(2);
        gridLayout1.setRows(2);
        jLabel1.setText("考试类别编号");
        jTextField1.setText("");
        jLabel2.setText("考试类别名称");
        jTextField2.setText("");
        jBdel.setText("删除");
        jBdel.addActionListener(new ExamKindView_jBdel_actionAdapter(this));
        jPanel2.setLayout(flowLayout1);
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jBadd.setText("添加");
        jBadd.addActionListener(new ExamKindView_jBadd_actionAdapter(this));
        jBsave.setText("修改");
        jBsave.addActionListener(new ExamKindView_jButton3_actionAdapter(this));
        jBexit.setText("退出");
        jBexit.addActionListener(new ExamKindView_jBexit_actionAdapter(this));
        jTable1.addMouseListener(new ExamKindView_jTable1_mouseAdapter(this));
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
        String[] name = { "考试类别编号", "考试类别编号名称" };
        String sqlStr = "select * from tb_examkind";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr);
        jTable1.setModel(tablemodel);
        jTable1.setRowHeight(24);
    }

    public void jBsave_actionPerformed(ActionEvent e) {
        String kindID = jTextField1.getText().trim();
        String kindName = jTextField2.getText().trim();

        if (kindID.equals("") || kindID == null || kindName == null || kindName.equals("")) {
            JLabel label = new JLabel("ID或名称不能为空");
            label.setForeground(FontAndColor.errorColor());
            label.setFont(FontAndColor.errorFont());
            JOptionPane.showMessageDialog(this,label);
            return;
        } else {
            ExamKindDaoImpl examkindDao = new ExamKindDaoImpl();
            if (!examkindDao.queryByID(kindID)) {
                JLabel label = new JLabel("ID为" + kindID + "的考试类别不存在");
                label.setForeground(FontAndColor.errorColor());
                label.setFont(FontAndColor.errorFont());
                JOptionPane.showMessageDialog(this,label);
            } else {
                boolean flag = examkindDao.update(kindID,kindName);

                if (flag) {
                    JLabel label = new JLabel("修改考试类别成功");
                    label.setForeground(FontAndColor.successColor());
                    label.setFont(FontAndColor.successFont());
                    JOptionPane.showMessageDialog(this,label);
                    buildTable();
                    jTextField1.setText("");
                    jTextField2.setText("");
                }else {
                    JLabel label = new JLabel("修改考试类别失败");
                    label.setForeground(FontAndColor.errorColor());
                    label.setFont(FontAndColor.errorFont());
                    JOptionPane.showMessageDialog(this,label);
                }
            }
        }

    }

    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        JLabel label = new JLabel("是否退出考试类别信息设置？");
        label.setForeground(FontAndColor.quitColor());
        label.setFont(FontAndColor.quitFont());
        int result = JOptionPane.showOptionDialog(null, label, "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }
    }

    public void jBadd_actionPerformed(ActionEvent e) {
        String kindID = jTextField1.getText().trim();
        String kindName = jTextField2.getText().trim();

        if (kindID == null || kindID.equals("")) {
            JLabel label = new JLabel("ID不能为空");
            label.setForeground(FontAndColor.errorColor());
            label.setFont(FontAndColor.errorFont());
            JOptionPane.showMessageDialog(this,label);
            return;
        }
        if (kindName == null || kindName.equals("")) {
            JLabel label = new JLabel("种类名不能为空");
            label.setForeground(FontAndColor.errorColor());
            label.setFont(FontAndColor.errorFont());
            JOptionPane.showMessageDialog(this,label);
            return;
        }

        if ( kindID.length() <= 4 || !kindID.substring(0,4).equals("kind")) {
            JLabel label = new JLabel("<html><body>ID格式错误<br>请修改为:kindX</body></html>");
            label.setForeground(FontAndColor.errorColor());
            label.setFont(FontAndColor.errorFont());
            JOptionPane.showMessageDialog(this,label);
            return;
        }

        boolean flag = new ExamKindDaoImpl().insert(kindID,kindName);

        if (flag) {
            JLabel label = new JLabel("添加成功");
            label.setForeground(FontAndColor.successColor());
            label.setFont(FontAndColor.successFont());
            JOptionPane.showMessageDialog(this,label);
            buildTable();
        }else {
            JLabel label = new JLabel("种类名不能为空");
            label.setForeground(FontAndColor.errorColor());
            label.setFont(FontAndColor.errorFont());
            JOptionPane.showMessageDialog(this,label);
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
        sqlStr = "select * from tb_examkind where kindID = '" + id + "'";
        java.util.Vector vdata = null;
        RetrieveObject retrive = new RetrieveObject();
        vdata = retrive.getObjectRow(sqlStr);

        jTextField1.setText(vdata.get(0).toString());
        jTextField2.setText(vdata.get(1).toString());
    }

    public void jBdel_actionPerformed(ActionEvent e) {
        JLabel label = new JLabel("是否删除考试类别信息数据?");
        label.setForeground(FontAndColor.quitColor());
        label.setFont(FontAndColor.quitFont());
        int result = JOptionPane.showOptionDialog(null,label, "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;
        String id = jTextField1.getText().trim();
        ExamKindDaoImpl examKindDao = new ExamKindDaoImpl();
        boolean flag = examKindDao.delete(id);

        if (id != null && !(id.equals(""))) {
            if (flag) {
                JLabel label1 = new JLabel("已删除编号为" + id +"的考试类别");
                label1.setForeground(FontAndColor.successColor());
                label1.setFont(FontAndColor.successFont());
                JOptionPane.showMessageDialog(this,label1);
                buildTable();
                jTextField1.setText("");
                jTextField2.setText("");
            }
        } else {
            JLabel label2 = new JLabel("ID不能为空");
            label2.setForeground(FontAndColor.errorColor());
            label2.setFont(FontAndColor.errorFont());
            JOptionPane.showMessageDialog(this,label2);
        }
    }
}

class ExamKindView_jTable1_mouseAdapter extends MouseAdapter {
    private ExamKindView adapter;

    ExamKindView_jTable1_mouseAdapter(ExamKindView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        adapter.jTable1_mouseClicked(e);
    }
}

class ExamKindView_jBdel_actionAdapter implements ActionListener {
    private ExamKindView adapter;

    ExamKindView_jBdel_actionAdapter(ExamKindView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBdel_actionPerformed(e);
    }
}

class ExamKindView_jBadd_actionAdapter implements ActionListener {
    private ExamKindView adapter;

    ExamKindView_jBadd_actionAdapter(ExamKindView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBadd_actionPerformed(e);
    }
}

class ExamKindView_jBexit_actionAdapter implements ActionListener {
    private ExamKindView adapter;

    ExamKindView_jBexit_actionAdapter(ExamKindView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBexit_actionPerformed(e);
    }
}

class ExamKindView_jButton3_actionAdapter implements ActionListener {
    private ExamKindView adapter;

    ExamKindView_jButton3_actionAdapter(ExamKindView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        adapter.jBsave_actionPerformed(e);
    }
}
