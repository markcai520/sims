package com.cwg.view;

import com.cwg.dao.impl.AdminDaoImpl;
import com.cwg.util.RetrieveObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class AdminView extends JInternalFrame {

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
    JButton jBexit = new JButton();
    JLabel jLabel3 = new JLabel();
    JTextField jTextField3 = new JTextField();

    public AdminView () {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        buildTable();
        this.getContentPane().setLayout(borderLayout1);
        setSize(380, 320);
        this.setClosable(true);
        setVisible(true);
        gridLayout1.setColumns(2);
        gridLayout1.setRows(3);
        jLabel1.setText("管理员ID");
        jTextField1.setText("");
        jLabel2.setText("用户名");
        jTextField2.setText("");
        jBdel.setText("删除");
        jBdel.addActionListener(new AdminView_jBdel_actionAdapter(this));
        jPanel2.setLayout(flowLayout1);
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jBadd.setText("添加");
        jBadd.addActionListener(new AdminView_jBadd_actionAdapter(this));
        jBexit.setText("退出");
        jBexit.addActionListener(new AdminView_jBexit_actionAdapter(this));
        jTable1.addMouseListener(new AdminView_jTable1_mouseAdapter(this));
        jLabel3.setText("密码");
        jTextField3.setText("");
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
        jPanel1.add(jLabel3);
        jPanel1.add(jTextField3);
        this.getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
        jPanel2.add(jBdel);
        jPanel2.add(jBadd);
        jPanel2.add(jBexit);
        jSplitPane1.setDividerLocation(164);

        buildTable();

    }
    public void buildTable() {
        DefaultTableModel tablemodel = null;
        String[] name = { "管理员ID", "用户名", "密码" };
        String sqlStr = "select * from tb_admin";
        RetrieveObject bdt = new RetrieveObject();
        tablemodel = bdt.getTableModel(name, sqlStr);
        jTable1.setModel(tablemodel);
        jTable1.setRowHeight(24);
    }

    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否退出用户信息维护?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }

    }

    public void jBadd_actionPerformed(ActionEvent e) {
        String id = jTextField1.getText().trim();
        String username = jTextField2.getText().trim();
        String password = jTextField3.getText().trim();

        if (id == null || id.equals("")) {
            JOptionPane.showMessageDialog(this,"ID不能为空");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        } else {

            if (new AdminDaoImpl().queryByUsername(username)) {
                JOptionPane.showMessageDialog(this,"用户名" + username + "已存在");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
            } else {
                boolean flag = new AdminDaoImpl().insertAdmin(id,username,password);

                if (flag) {
                    JOptionPane.showMessageDialog(this,"添加管理员成功");
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    buildTable();
                } else {
                    JOptionPane.showMessageDialog(this,"添加管理员失败");
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                }
            }


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
        sqlStr = "select * from tb_admin where adminID = '" + id + "'";
        java.util.Vector vdata = null;
        RetrieveObject retrive = new RetrieveObject();
        vdata = retrive.getObjectRow(sqlStr);

        jTextField1.setText(vdata.get(0).toString());
        jTextField2.setText(vdata.get(1).toString());
        jTextField3.setText(vdata.get(2).toString());

    }

    public void jBdel_actionPerformed(ActionEvent e) {
        int result = JOptionPane.showOptionDialog(null, "是否删除用户信息数据?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;
        String id = jTextField1.getText().trim();
        boolean flag = new AdminDaoImpl().delete(id);

        if (flag) {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            buildTable();
        }

    }

}

class AdminView_jTable1_mouseAdapter extends MouseAdapter {
    private AdminView adapter;

    AdminView_jTable1_mouseAdapter(AdminView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        adapter.jTable1_mouseClicked(e);
    }
}

class AdminView_jBdel_actionAdapter implements ActionListener {
    private AdminView adapter;

    AdminView_jBdel_actionAdapter(AdminView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBdel_actionPerformed(e);
    }
}

class AdminView_jBadd_actionAdapter implements ActionListener {
    private AdminView adapter;

    AdminView_jBadd_actionAdapter(AdminView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBadd_actionPerformed(e);
    }
}

class AdminView_jBexit_actionAdapter implements ActionListener {
    private AdminView adapter;

    AdminView_jBexit_actionAdapter(AdminView adapter) {
        this.adapter = adapter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adapter.jBexit_actionPerformed(e);
    }
}
