package com.cwg.view;

import com.cwg.dao.impl.SubjectDaoImpl;
import com.cwg.util.FontAndColor;
import com.cwg.util.RetrieveObject;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class SubjectView extends JInternalFrame {

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
    JLabel jLabel3 = new JLabel();
    JTextField jTextField3 = new JTextField();
    JPanel jPanel2 = new JPanel();
    JButton jBdel = new JButton();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
    JButton jBexit = new JButton();

    public SubjectView () {
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
        gridLayout1.setRows(3);
        jLabel1.setText("科目编号");
        jTextField1.setText("");
        jLabel2.setText("科目名称");
        jTextField2.setText("");
        jLabel3.setText("考试类别");
        jTextField3.setText("");
        jBdel.setText("删除");
        jBdel.addActionListener(new SubjectView_jBdel_actionAdapter(this));
        jPanel2.setLayout(flowLayout1);
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jBadd.setText("添加");
        jBadd.addActionListener(new SubjectView_jBadd_actionAdapter(this));
        jBsave.setText("修改");
        jBsave.addActionListener(new SubjectView_jButton3_actionAdapter(this));
        jBexit.setText("退出");
        jBexit.addActionListener(new SubjectView_jBexit_actionAdapter(this));
        jTable1.addMouseListener(new SubjectView_jTable1_mouseAdapter(this));
        this.getContentPane().add(jSplitPane1, BorderLayout.CENTER);
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jPanel1.setLayout(gridLayout1);
        jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
        jScrollPane1.getViewport().add(jTable1);
        jSplitPane1.add(jPanel1, JSplitPane.BOTTOM);
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel1.add(jLabel2);
        jPanel1.add(jTextField2);
        jPanel1.add(jLabel3);
        jPanel1.add(jTextField3);
        this.getContentPane().add(jPanel2, BorderLayout.SOUTH);
        jPanel2.add(jBdel);
        jPanel2.add(jBadd);
        jPanel2.add(jBsave);
        jPanel2.add(jBexit);
        jSplitPane1.setDividerLocation(140);

        buildTable();
    }

    public void buildTable() {
        DefaultTableModel tablemodel = null;
        String[] name = { "科目编号", "科目名称" ,"考试类别"};
        String sqlStr = "select * from tb_subject";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr);
        jTable1.setModel(tablemodel);
        jTable1.setRowHeight(24);
    }

    public void jBsave_actionPerformed(ActionEvent e) {
        String subID = jTextField1.getText().trim();
        String subject = jTextField2.getText().trim();
        String kindID = jTextField3.getText().trim();

        if (kindID == null || kindID.equals("")) {
            JLabel label = new JLabel("考试类型不能为空");
            label.setFont(FontAndColor.errorFont());
            label.setForeground(FontAndColor.errorColor());
            JOptionPane.showMessageDialog(this,label,"错误提示",1);
            return;
        }

        if (kindID.length() < 5 || !kindID.substring(0,4).equals("kind")) {
            String str = "<html><body>您的考试类别格式不对<br>请修改为kindX<br>注:X为任意数字</body></html>";
            JLabel label = new JLabel(str);
            label.setFont(FontAndColor.errorFont());
            label.setForeground(FontAndColor.errorColor());
            JOptionPane.showMessageDialog(this,label,"错误提示",1);
            return;
        }

        if (subID.equals("") || subID == null || subject == null || subject.equals("")) {
            JOptionPane.showMessageDialog(this,"ID或名称不能为空");
        } else {
            SubjectDaoImpl subjectDao = new SubjectDaoImpl();
            if (!subjectDao.queryByID(subID)) {
                JOptionPane.showMessageDialog(this,"ID为" + subID + "的科目不存在");
            } else {
                boolean flag = subjectDao.update(subID,subject,kindID);

                if (flag) {
                    JOptionPane.showMessageDialog(this,"修改科目成功");
                    buildTable();
                    jTextField1.setText("");
                    jTextField2.setText("");
                }else {
                    JOptionPane.showMessageDialog(this,"修改科目失败");
                }
            }
        }

    }

    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否退出考试科目信息设置?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }

    }

    public void jBadd_actionPerformed(ActionEvent e) {
        String subID = jTextField1.getText().trim();
        String subject = jTextField2.getText().trim();
        String kindID = jTextField3.getText().trim();

        if (kindID == null || kindID.equals("")) {
            JLabel label = new JLabel("考试类型不能为空");
            label.setFont(FontAndColor.errorFont());
            label.setForeground(FontAndColor.errorColor());
            JOptionPane.showMessageDialog(this,label,"错误提示",1);
            return;
        }

        if (kindID.length() < 5 || !kindID.substring(0,4).equals("kind")) {
            String str = "<html><body>您的考试类别格式不对<br>请修改为kindX<br>注:X为任意数字</body></html>";
            JLabel label = new JLabel(str);
            label.setFont(FontAndColor.errorFont());
            label.setForeground(FontAndColor.errorColor());
            JOptionPane.showMessageDialog(this,label,"错误提示",1);
            return;
        }

        if (new SubjectDaoImpl().queryByID(subID)) {
            JLabel label = new JLabel("编号为" + subID + "的科目已存在！");
            label.setFont(FontAndColor.errorFont());
            label.setForeground(FontAndColor.errorColor());
            JOptionPane.showMessageDialog(this,label);
            return;
        }

        if (subID != null && !(subID.equals("")) && subject != null && !(subject.equals(""))) {
            boolean flag = new SubjectDaoImpl().insert(subID,subject,kindID);

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
        sqlStr = "select * from tb_subject where subID = '" + id + "'";
        Vector vdata = null;
        RetrieveObject retrive = new RetrieveObject();
        vdata = retrive.getObjectRow(sqlStr);

        jTextField1.setText(vdata.get(0).toString());
        jTextField2.setText(vdata.get(1).toString());
        jTextField3.setText(vdata.get(2).toString());
    }

    public void jBdel_actionPerformed(ActionEvent e) {
        int result = JOptionPane.showOptionDialog(null, "是否删除科目信息数据?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;
        String id = jTextField1.getText().trim();
        SubjectDaoImpl subjectDao = new SubjectDaoImpl();
        boolean flag = subjectDao.delete(id);

        if (id != null && !(id.equals(""))) {
            if (flag) {
                JOptionPane.showMessageDialog(this,"已删除编号为" + id +"的科目");
                buildTable();
                jTextField1.setText("");
                jTextField2.setText("");
            } else {
                JLabel label = new JLabel("该科目已被其他表引用,无法删除");
                label.setForeground(FontAndColor.errorColor());
                label.setFont(FontAndColor.errorFont());
                JOptionPane.showMessageDialog(this,label);
            }
        } else {
            JOptionPane.showMessageDialog(this,"ID不能为空");
        }
    }
}

class SubjectView_jTable1_mouseAdapter extends MouseAdapter {
    private SubjectView adapter;

    SubjectView_jTable1_mouseAdapter(SubjectView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        adapter.jTable1_mouseClicked(e);
    }
}

class SubjectView_jBdel_actionAdapter implements ActionListener {
    private SubjectView adapter;

    SubjectView_jBdel_actionAdapter(SubjectView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBdel_actionPerformed(e);
    }
}

class SubjectView_jBadd_actionAdapter implements ActionListener {
    private SubjectView adapter;

    SubjectView_jBadd_actionAdapter(SubjectView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBadd_actionPerformed(e);
    }
}

class SubjectView_jBexit_actionAdapter implements ActionListener {
    private SubjectView adapter;

    SubjectView_jBexit_actionAdapter(SubjectView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBexit_actionPerformed(e);
    }
}

class SubjectView_jButton3_actionAdapter implements ActionListener {
    private SubjectView adapter;

    SubjectView_jButton3_actionAdapter(SubjectView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        adapter.jBsave_actionPerformed(e);
    }
}
