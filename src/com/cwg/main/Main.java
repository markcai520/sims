package com.cwg.main;

import com.cwg.util.FontAndColor;
import com.cwg.view.LoginView;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args){

        try {
            FontUIResource fontRes = new FontUIResource(FontAndColor.mainFont());
            for(Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
                Object key = keys.nextElement();
                Object value = UIManager.get(key);
                if (value instanceof FontUIResource)
                    UIManager.put(key, fontRes);
            }
            UIManager.put("RootPane.setupButtonVisible", false); //设置按钮消失
            BeautyEyeLNFHelper.translucencyAtFrameInactive = false; //关闭窗口在不活动时的半透明效果
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }

        new LoginView();
    }
}
