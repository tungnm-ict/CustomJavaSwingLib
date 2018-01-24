/**
 * Copyright(C) 2016 NMT
 *
 * Class ThemeTest.java Jul 29, 2016 Nguyen Manh Tung
 */
package tungnm.swing.demo.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import tungnm.swing.component.button.ButtonType;
import tungnm.swing.component.button.GlossyButton;
import tungnm.swing.component.button.StandardButton;
import tungnm.swing.component.panel.GradientPanel;
import tungnm.swing.util.Theme;
import tungnm.swing.util.ThemesList;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class ThemeTest {
    // ORANGE THEME

    ArrayList<String> standardThemes = new ArrayList<String>();
    ArrayList<String> gradientThemes = new ArrayList<String>();
    ArrayList<String> themesList = new ArrayList<String>();

    public void StandardThemes() {
        //CUSTOMER THEME
        standardThemes.add("CUSTOMER_STANDARD_BUTTON_THEME");
        standardThemes.add("CUSTOMER_STANDARD_ROLLOVER_BUTTON_THEME");
        standardThemes.add("CUSTOMER_STANDARD_SELECTED_BUTTON_THEME");
        
        standardThemes.add("STANDARD_SILVER_THEME");
        standardThemes.add("STANDARD_DARKGREEN_THEME");
        standardThemes.add("STANDARD_BLUEGREEN_THEME");
        standardThemes.add("STANDARD_GREEN_THEME");
        standardThemes.add("STANDARD_LIGHTGREEN_THEME");
        standardThemes.add("STANDARD_LIME_THEME");
        standardThemes.add("STANDARD_OLIVEGREEN_THEME");

        // RED THEME
        standardThemes.add("STANDARD_RED_THEME");
        standardThemes.add("STANDARD_DARKRED_THEME");
        standardThemes.add("STANDARD_ORANGE_THEME");
        standardThemes.add("STANDARD_LIGHTORANGE_THEME ");

        // YELLOW THEME
        standardThemes.add("STANDARD_DARKYELLOW_THEME ");
        standardThemes.add("STANDARD_GREENYELLOW_THEME ");
        standardThemes.add("STANDARD_GOLD_THEME ");
        standardThemes.add("STANDARD_YELLOW_THEME ");

        // BROWN THEME
        standardThemes.add("STANDARD_BROWN_THEME ");
        standardThemes.add("STANDARD_LIGHTBROWN_THEME ");
        standardThemes.add("STANDARD_PALEBROWN_THEME ");

        // BLACK THEME
        standardThemes.add("STANDARD_BLACK_THEME ");
        standardThemes.add("STANDARD_GRAY_THEME ");
        standardThemes.add("STANDARD_LIGHTGRAY204_THEME");
        standardThemes.add("STANDARD_LIGHTGRAY214_THEME");
        standardThemes.add("STANDARD_LIGHTGRAY_THEME ");
        standardThemes.add("STANDARD_METALLICGRAY_THEME ");
        standardThemes.add("STANDARD_BLUEGRAY_THEME ");

        // BLUE THEME
        standardThemes.add("STANDARD_NAVYBLUE_THEME ");
        standardThemes.add("STANDARD_INDIGO_THEME ");
        standardThemes.add("STANDARD_BLUE_THEME ");
        standardThemes.add("STANDARD_SKYBLUE_THEME ");
        standardThemes.add("STANDARD_LIGHTBLUE_THEME ");

        // PURPLE THEME
        standardThemes.add("STANDARD_DARKPURPLE_THEME ");
        standardThemes.add("STANDARD_PURPLE_THEME ");
        standardThemes.add("STANDARD_LAVENDER_THEME ");

        // PINK THEME
        standardThemes.add("STANDARD_DARKPINK_THEME ");
        standardThemes.add("STANDARD_PINK_THEME ");
        standardThemes.add("STANDARD_PALEPINK_THEME ");
        standardThemes.add("STANDARD_VOILET_THEME ");
        createFrame();

    }

    public void GlossyThemes() {
        // CUSTOMER THEME
        themesList.add("CUSTOMER_GLOSSY_BUTTON_THEME");
        themesList.add("CUSTOMER_GLOSSY_ROLLOVER_BUTTON_THEME");
        themesList.add("CUSTOMER_GLOSSY_SELECTED_BUTTON_HEME");
        
        themesList.add("GLOSSY_SILVER_THEME");
        themesList.add("GLOSSY_DARKGREEN_THEME");
        themesList.add("GLOSSY_BLUEGREEN_THEME");
        themesList.add("GLOSSY_GREEN_THEME");
        themesList.add("GLOSSY_LIGHTGREEN_THEME");
        themesList.add("GLOSSY_LIME_THEME");
        themesList.add("GLOSSY_OLIVEGREEN_THEME");

        // RED THEME
        themesList.add("GLOSSY_RED_THEME");
        themesList.add("GLOSSY_DARKRED_THEME");

        // ORANGE THEME
        themesList.add("GLOSSY_ORANGE_THEME");
        themesList.add("GLOSSY_LIGHTORANGE_THEME");

        // YELLOW THEME
        themesList.add("GLOSSY_DARKYELLOW_THEME");
        themesList.add("GLOSSY_GREENYELLOW_THEME");
        themesList.add("GLOSSY_GOLD_THEME");
        themesList.add("GLOSSY_YELLOW_THEME");

        // BROWN THEME
        themesList.add("GLOSSY_BROWN_THEME");
        themesList.add("GLOSSY_LIGHTBROWN_THEME");
        themesList.add("GLOSSY_PALEBROWN_THEME");

        // BLACK THEME
        themesList.add("GLOSSY_BLACK_THEME");
        themesList.add("GLOSSY_GRAY_THEME");
        themesList.add("GLOSSY_LIGHTGRAY_THEME");
        themesList.add("GLOSSY_METALLICGRAY_THEME");
        themesList.add("GLOSSY_BLUEGRAY_THEME");

        // BLUE THEME
        themesList.add("GLOSSY_NAVYBLUE_THEME");
        themesList.add("GLOSSY_INDIGO_THEME");
        themesList.add("GLOSSY_BLUE_THEME");
        themesList.add("GLOSSY_SKYBLUE_THEME");
        themesList.add("GLOSSY_LIGHTBLUE_THEME");

        // PURPLE THEME
        themesList.add("GLOSSY_DARKPURPLE_THEME");
        themesList.add("GLOSSY_PURPLE_THEME");
        themesList.add("GLOSSY_LAVENDER_THEME");

        // PINK THEME
        themesList.add("GLOSSY_DARKPINK_THEME");
        themesList.add("GLOSSY_PINK_THEME");
        themesList.add("GLOSSY_PALEPINK_THEME");

        themesList.add("GLOSSY_METALIC_GRAY_THEME");
        themesList.add("GLOSSY_METALIC_BLUE_THEME");

        themesList.add("GLOSSY_VOILET_THEME");
        themesList.add("GLOSSY_ORANGERED_THEME");
        themesList.add("GLOSSY_BLUEBLACK_THEME");
        themesList.add("GLOSSY_GREENBLACK_THEME");
        themesList.add("GLOSSY_GOLDBLACK_THEME");
        themesList.add("GLOSSY_ORANGEBLACK_THEME");
        themesList.add("GLOSSY_MULTIBLUE_THEME");
        themesList.add("GLOSSY_MULTIBLUECOLOR_THEME");

        themesList.add("GLOSSY_MULTIDARKGREEN_THEME");
        themesList.add("GLOSSY_MULTIBLUEGREEN_THEME");
        themesList.add("GLOSSY_MULTIGREEN_THEME");
        themesList.add("GLOSSY_MULTILIGHTGREEN_THEME");
        themesList.add("GLOSSY_MULTILIME_THEME");
        themesList.add("GLOSSY_MULTIOLIVEGREEN_THEME");

        // RED THEME
        themesList.add("GLOSSY_MULTIRED_THEME");
        themesList.add("GLOSSY_MULTIDARKRED_THEME");

        // ORANGE THEME
        themesList.add("GLOSSY_MULTIORANGE_THEME");
        // themesList.add("GLOSSY_MULTILIGHTORANGE_THEME");
        // YELLOW THEME
        // themesList.add("GLOSSY_MULTIDARKYELLOW_THEME");
        // themesList.add("GLOSSY_MULTIGREENYELLOW_THEME");
        themesList.add("GLOSSY_MULTIGOLD_THEME");
        // themesList.add("GLOSSY_MULTIYELLOW_THEME");

        // BROWN THEME
        themesList.add("GLOSSY_MULTIBROWN_THEME");
        themesList.add("GLOSSY_MULTILIGHTBROWN_THEME");
        themesList.add("GLOSSY_MULTIPALEBROWN_THEME");

        // BLACK THEME
        themesList.add("GLOSSY_MULTIBLACK_THEME");
        themesList.add("GLOSSY_MULTIGRAY_THEME");
        themesList.add("GLOSSY_MULTILIGHTGRAY_THEME");
        // themesList.add("GLOSSY_MULTIMETALLICGRAY_THEME");
        themesList.add("GLOSSY_MULTIBLUEGRAY_THEME");

        // BLUE THEME
        themesList.add("GLOSSY_MULTINAVYBLUE_THEME");
        themesList.add("GLOSSY_MULTIINDIGO_THEME");
        themesList.add("GLOSSY_MULTISKYBLUE_THEME");
        themesList.add("GLOSSY_MULTILIGHTBLUE_THEME");

        // PURPLE THEME
        themesList.add("GLOSSY_MULTIDARKPURPLE_THEME");
        themesList.add("GLOSSY_MULTIPURPLE_THEME");
        themesList.add("GLOSSY_MULTILAVENDER_THEME");

        // PINK THEME
        themesList.add("GLOSSY_MULTIDARKPINK_THEME");
        themesList.add("GLOSSY_MULTIPINK_THEME");
        themesList.add("GLOSSY_MULTIPALEPINK_THEME");
        themesList.add("GLOSSY_MULTIVOILET_THEME");
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        int count = 0;
        for (int theme : ThemesList.createThemesList()) {
            System.out.println(ThemesList.createStandardThemesList().size());
            JPanel panel = new JPanel(new BorderLayout());
            //JLabel label = new JLabel(standardThemes.get(count));
            //rectBtn.add(label);
            GlossyButton rectBtn = new GlossyButton(themesList.get(count), theme, ButtonType.BUTTON_RECTANGULAR);
            ++count;
            rectBtn.setFont(new Font("Times Now", Font.PLAIN, 11));
            panel.add(rectBtn, BorderLayout.CENTER);
            //panel.add(label, BorderLayout.PAGE_END);
            panel.setPreferredSize(new Dimension(230, 30));
            frame.add(panel);
        }
        frame.getContentPane().setBackground(Color.white);
        frame.setPreferredSize(new Dimension(1000,600));
        frame.setSize(new Dimension(10000, 600));
        frame.setVisible(true);
    }

    public void createFrame() {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        int count = 0;
        for (int theme : ThemesList.createStandardThemesList()) {
            System.out.println(ThemesList.createStandardThemesList().size());
            JPanel panel = new JPanel(new BorderLayout());
            //JLabel label = new JLabel(standardThemes.get(count));
            //rectBtn.add(label);
            StandardButton rectBtn = new StandardButton(standardThemes.get(count), theme, ButtonType.BUTTON_RECTANGULAR);
            ++count;
            rectBtn.setFont(new Font("Times Now", Font.PLAIN, 11));
            panel.add(rectBtn, BorderLayout.CENTER);
            //panel.add(label, BorderLayout.PAGE_END);
            panel.setPreferredSize(new Dimension(230, 30));
            frame.add(panel);
        }
        frame.getContentPane().setBackground(Color.white);
        frame.setPreferredSize(new Dimension(1000,600));
        frame.setSize(new Dimension(10000, 600));
        frame.setVisible(true);
    }

    public void gradientThemes() {
        gradientThemes.add("GRADIENT_SILVER_THEME");
        gradientThemes.add("GRADIENT_DARKGREEN_THEME");
        gradientThemes.add("GRADIENT_BLUEGREEN_THEME");
        gradientThemes.add("GRADIENT_GREEN_THEME");
        gradientThemes.add("GRADIENT_LIGHTGREEN_THEME");
        gradientThemes.add("GRADIENT_LIME_THEME");
        gradientThemes.add("GRADIENT_OLIVEGREEN_THEME");

        // RED THEME
        gradientThemes.add("GRADIENT_RED_THEME");
        gradientThemes.add("GRADIENT_DARKRED_THEME");
        gradientThemes.add("GRADIENT_ORANGE_THEME");
        gradientThemes.add("GRADIENT_LIGHTORANGE_THEME ");

        // YELLOW THEME
        gradientThemes.add("GRADIENT_DARKYELLOW_THEME ");
        gradientThemes.add("GRADIENT_GREENYELLOW_THEME ");
        gradientThemes.add("GRADIENT_GOLD_THEME ");
        gradientThemes.add("GRADIENT_YELLOW_THEME ");

        // BROWN THEME
        gradientThemes.add("GRADIENT_BROWN_THEME ");
        gradientThemes.add("GRADIENT_LIGHTBROWN_THEME ");
        gradientThemes.add("GRADIENT_PALEBROWN_THEME ");

        // BLACK THEME
        gradientThemes.add("GRADIENT_BLACK_THEME ");
        gradientThemes.add("GRADIENT_GRAY_THEME ");
        gradientThemes.add("GRADIENT_LIGHTGRAY_THEME ");
        gradientThemes.add("GRADIENT_METALLICGRAY_THEME ");
        gradientThemes.add("GRADIENT_BLUEGRAY_THEME ");

        // BLUE THEME
        gradientThemes.add("GRADIENT_NAVYBLUE_THEME ");
        gradientThemes.add("GRADIENT_INDIGO_THEME ");
        gradientThemes.add("GRADIENT_BLUE_THEME ");
        gradientThemes.add("GRADIENT_SKYBLUE_THEME ");
        gradientThemes.add("GRADIENT_LIGHTBLUE_THEME ");

        // PURPLE THEME
        gradientThemes.add("GRADIENT_DARKPURPLE_THEME ");
        gradientThemes.add("GRADIENT_PURPLE_THEME ");
        gradientThemes.add("GRADIENT_LAVENDER_THEME ");

        // PINK THEME
        gradientThemes.add("GRADIENT_DARKPINK_THEME ");
        gradientThemes.add("GRADIENT_PINK_THEME ");
        gradientThemes.add("GRADIENT_PALEPINK_THEME ");
        gradientThemes.add("GRADIENT_VOILET_THEME ");
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        int count = 0;
        for (int theme : ThemesList.createThemesList()) {
            JPanel panel = new JPanel(new BorderLayout());
            //GradientButton rectBtn = new GradientButton(gradientThemes.get(count),theme,ButtonType.BUTTON_RECTANGULAR);
            GradientPanel rectBtn = new GradientPanel(theme);
            //rectBtn.setLayout(new BorderLayout());
            JLabel label = new JLabel(themesList.get(count));
            rectBtn.add(label);
            System.out.println(ThemesList.createGradientThemesList().size());
            ++count;
            rectBtn.setFont(new Font("Times Now", Font.PLAIN, 11));
            panel.add(rectBtn, BorderLayout.CENTER);
            //panel.add(label, BorderLayout.PAGE_END);
            panel.setPreferredSize(new Dimension(230, 28));
            frame.add(panel);
        }
        frame.getContentPane().setBackground(Color.white);
        frame.setPreferredSize(new Dimension(10000, 600));
        frame.setSize(new Dimension(10000, 600));
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ThemeTest themeTest = new ThemeTest();
        themeTest.StandardThemes();
        themeTest.GlossyThemes();
        themeTest.gradientThemes();
        
    }

    public ArrayList<String> getThemesList() {
        return themesList;
    }

    public void setThemesList(ArrayList<String> themesList) {
        this.themesList = themesList;
    }

}
