package com.cwg.util;

import java.awt.*;

public class FontAndColor {

    public static Font errorFont() {
        return new Font("微软雅黑",0,14);
    }

    public static Font mainFont() {
        return new Font("黑体", Font.PLAIN, 13);
    }

    public static Font quitFont () {
        return new Font("微软雅黑",0,14);
    }

    public static Font successFont () {
        return new Font("微软雅黑",0,14);
    }

    public static Font tipFont () {
        return new Font("微软雅黑",0,14);
    }

    public static Color tipColor () {
        return Color.black;
    }

    public static Color successColor () {
        return Color.cyan;
    }

    public static Color errorColor() {
        return Color.RED;
    }

    public static Color warningColor () {
        return Color.PINK;
    }

    public static Color quitColor () {
        return Color.black;
    }

}
