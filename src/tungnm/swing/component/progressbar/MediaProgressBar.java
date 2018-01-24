/**
 * Copyright(C) 2016 NMT
 *
 * Class MediaProgressBar.java Aug 19, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.progressbar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class MediaProgressBar extends JProgressBar {

    private MediaProgressBarUI barUI;

    public MediaProgressBar() {
        barUI = new MediaProgressBarUI();
        setUI(barUI);
    }

    public MediaProgressBar(ProgressBarType progressBarType) {
        this();
        this.setProgressBarType(progressBarType);
    }

    public MediaProgressBar(ProgressBarType progressBarType, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setProgressBarType(progressBarType);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(ProgressBarType progressBarType, boolean gradien) {
        this();
        this.setProgressBarType(progressBarType);
        this.setGradient(gradien);
    }

    public MediaProgressBar(ProgressBarType progressBarType, boolean gradien, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setProgressBarType(progressBarType);
        this.setGradient(gradien);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth) {
        this();
        this.setiStrokWidth(iStrokWidth);
    }

    public MediaProgressBar(int iStrokWidth, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, boolean gradien) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setGradient(gradien);
    }

    public MediaProgressBar(int iStrokWidth, boolean gradien, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setGradient(gradien);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, ProgressBarType progressBarType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setProgressBarType(progressBarType);
    }

    public MediaProgressBar(int iStrokWidth, ProgressBarType progressBarType, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setProgressBarType(progressBarType);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, ProgressBarType progressBarType, boolean gradien) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setProgressBarType(progressBarType);
        this.setGradient(gradien);
    }

    public MediaProgressBar(int iStrokWidth, ProgressBarType progressBarType, boolean gradien, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setProgressBarType(progressBarType);
        this.setGradient(gradien);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, Color progressBarColor) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(progressBarColor);
        this.setProgressColor(progressBarColor);
    }

    public MediaProgressBar(int iStrokWidth, Color progressBarColor, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(progressBarColor);
        this.setProgressColor(progressBarColor);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, Color progressBarColor, boolean gradien) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(progressBarColor);
        this.setProgressColor(progressBarColor);
        this.setGradient(gradien);
    }

    public MediaProgressBar(int iStrokWidth, Color progressBarColor, boolean gradien, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(progressBarColor);
        this.setProgressColor(progressBarColor);
        this.setGradient(gradien);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, Color progressBarColor, ProgressBarType progressBarType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(progressBarColor);
        this.setProgressColor(progressBarColor);
        this.setProgressBarType(progressBarType);
    }

    public MediaProgressBar(int iStrokWidth, Color progressBarColor, ProgressBarType progressBarType, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(progressBarColor);
        this.setProgressColor(progressBarColor);
        this.setProgressBarType(progressBarType);
    }

    public MediaProgressBar(int iStrokWidth, Color progressBarColor, ProgressBarType progressBarType, boolean gradien) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(progressBarColor);
        this.setProgressColor(progressBarColor);
        this.setProgressBarType(progressBarType);
        this.setGradient(gradien);
    }

    public MediaProgressBar(int iStrokWidth, Color progressBarColor, ProgressBarType progressBarType, boolean gradien, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(progressBarColor);
        this.setProgressColor(progressBarColor);
        this.setProgressBarType(progressBarType);
        this.setGradient(gradien);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, Color backgroundColor, Color progressColor) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(backgroundColor);
        this.setProgressColor(progressColor);
    }

    public MediaProgressBar(int iStrokWidth, Color backgroundColor, Color progressColor, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(backgroundColor);
        this.setProgressColor(progressColor);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, Color backgroundColor, Color progressColor, boolean gradien) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(backgroundColor);
        this.setProgressColor(progressColor);
        this.setGradient(gradien);
    }

    public MediaProgressBar(int iStrokWidth, Color backgroundColor, Color progressColor, boolean gradien, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(backgroundColor);
        this.setProgressColor(progressColor);
        this.setGradient(gradien);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, Color backgroundColor, Color progressColor, ProgressBarType progressBarType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(backgroundColor);
        this.setProgressColor(progressColor);
        this.setProgressBarType(progressBarType);
    }

    public MediaProgressBar(int iStrokWidth, Color backgroundColor, Color progressColor, ProgressBarType progressBarType, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(backgroundColor);
        this.setProgressColor(progressColor);
        this.setProgressBarType(progressBarType);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public MediaProgressBar(int iStrokWidth, Color backgroundColor, Color progressColor, ProgressBarType progressBarType, boolean gradien) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(backgroundColor);
        this.setProgressColor(progressColor);
        this.setProgressBarType(progressBarType);
        this.setGradient(gradien);
    }

    public MediaProgressBar(int iStrokWidth, Color backgroundColor, Color progressColor, ProgressBarType progressBarType, boolean gradien, ProgressBackgroudType progressBackgroudType) {
        this();
        this.setiStrokWidth(iStrokWidth);
        this.setBackgoundColor(backgroundColor);
        this.setProgressColor(progressColor);
        this.setProgressBarType(progressBarType);
        this.setGradient(gradien);
        this.setProgressBackgroudType(progressBackgroudType);
    }

    public int getiStrokWidth() {
        return barUI.getiStrokWidth();
    }

    public void setiStrokWidth(int iStrokWidth) {
        barUI.setiStrokWidth(iStrokWidth);
    }

    public Color getBackgoundColor() {
        return barUI.getBackgoundColor();
    }

    public void setBackgoundColor(Color backgoundColor) {
        barUI.setBackgoundColor(backgoundColor);
    }

    public Color getProgressColor() {
        return barUI.getProgressColor();
    }

    public void setProgressColor(Color progressColor) {
        barUI.setProgressColor(progressColor);
    }

    public ProgressBarType getProgressBarType() {
        return barUI.getProgressBarType();
    }

    public void setProgressBarType(ProgressBarType progressBarType) {
        barUI.setProgressBarType(progressBarType);
    }

    public ProgressBackgroudType getProgressBackgroudType() {
        return barUI.getProgressBackgroudType();
    }

    public void setProgressBackgroudType(ProgressBackgroudType progressBackgroudType) {
        barUI.setProgressBackgroudType(progressBackgroudType);
    }

    public boolean isGradient() {
        return barUI.isGradient();
    }

    public void setGradient(boolean gradient) {
        barUI.setGradient(gradient);
    }

    public enum ProgressBarType {
        CIRCLE(1),
        ROUND(2),
        RECTANGLE(3);

        private int value;

        private ProgressBarType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    public enum ProgressBackgroudType {
        LINE(1),
        LINEFIT(2),
        FILL(3),
        FILLFIT(4);

        private int value;

        private ProgressBackgroudType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(128, 24);
//    }

    class MediaProgressBarUI extends BasicProgressBarUI {

        private Handler handler;
        private double renderProgress = 0;
        private double targetProgress = 0;
        private double progressDelta = 0.01;
        private final Timer repaintTimer;
        private final Timer paintTimer;
        int iStrokWidth = 3;
        private Color backgoundColor = Color.BLACK;
        private Color progressColor = Color.BLACK;
        private ProgressBarType progressBarType = ProgressBarType.CIRCLE;
        private boolean gradient = false;
        private ProgressBackgroudType progressBackgroudType = ProgressBackgroudType.LINE;

        public MediaProgressBarUI() {
            repaintTimer = new Timer(1, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    progressBar.repaint();
                }
            });
            repaintTimer.setRepeats(false);
            repaintTimer.setCoalesce(true);

            paintTimer = new Timer(1, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (progressDelta < 0) {

                        if (renderProgress + progressDelta < targetProgress) {
                            ((Timer) e.getSource()).stop();
                            renderProgress = targetProgress + progressDelta;
                        }

                    } else if (renderProgress + progressDelta > targetProgress) {
                        ((Timer) e.getSource()).stop();
                        renderProgress = targetProgress - progressDelta;
                    }
                    renderProgress += progressDelta;
                    requestRepaint();
                }
            });
        }

        public int getiStrokWidth() {
            return iStrokWidth;
        }

        public void setiStrokWidth(int iStrokWidth) {
            this.iStrokWidth = iStrokWidth;
        }

        public Color getBackgoundColor() {
            return backgoundColor;
        }

        public void setBackgoundColor(Color backgoundColor) {
            this.backgoundColor = backgoundColor;
        }

        public Color getProgressColor() {
            return progressColor;
        }

        public void setProgressColor(Color progressColor) {
            this.progressColor = progressColor;
        }

        public boolean isGradient() {
            return gradient;
        }

        public void setGradient(boolean gradient) {
            this.gradient = gradient;
        }

        public ProgressBarType getProgressBarType() {
            return progressBarType;
        }

        public void setProgressBarType(ProgressBarType progressBarType) {
            this.progressBarType = progressBarType;
        }

        public ProgressBackgroudType getProgressBackgroudType() {
            return progressBackgroudType;
        }

        public void setProgressBackgroudType(ProgressBackgroudType progressBackgroudType) {
            this.progressBackgroudType = progressBackgroudType;
        }

        protected void requestRepaint() {
            repaintTimer.restart();
        }

        @Override
        protected void installDefaults() {
            super.installDefaults();
            progressBar.setOpaque(false);
            progressBar.setBorder(null);
        }

        public void setRenderProgress(double value) {

            if (value != targetProgress) {
                paintTimer.stop();

                targetProgress = value;
                if (targetProgress < renderProgress && progressDelta > 0) {
//                    progressDelta *= -1;
                } else if (targetProgress > renderProgress && progressDelta < 0) {
//                    progressDelta *= -1;
                }
                System.out.println(progressDelta);

                paintTimer.start();
            }
        }

        public double getRenderProgress() {
            return renderProgress;
        }

        private int caculateARC(int height) {
            int arc = 0;
            switch (this.progressBarType) {
                case CIRCLE:
                    arc = height;
                    break;
                case ROUND:
                    arc = height / 2;
                    break;
                case RECTANGLE:
                    arc = 2;
                    break;
            }
            return arc;
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            int width = c.getWidth();
            int height = c.getHeight();
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(iStrokWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.setColor(backgoundColor);
            g2d.setBackground(backgoundColor);
            int arc = caculateARC(height);
            RoundRectangle2D outline = new RoundRectangle2D.Double((iStrokWidth / 2), (iStrokWidth / 2),
                    width - iStrokWidth, height - iStrokWidth, arc, arc);
            if (progressBackgroudType == ProgressBackgroudType.LINE || progressBackgroudType == ProgressBackgroudType.LINEFIT) {
                g2d.draw(outline);
            } else {
                g2d.fill(outline);
            }
            //------------------------ Progress Bar ---------------------------------
            float[] dist = {0.0f, 0.25f, 1.0f};
            int fillfitValue = 1;

            if (null != progressBackgroudType) {
                switch (progressBackgroudType) {
                    case LINE:
                        fillfitValue = 2;
                        break;
                    case FILL:
                        fillfitValue = 1;
                        break;
                    case LINEFIT:
                        fillfitValue = 1;
                        break;
                    case FILLFIT:
                        fillfitValue = 0;
                        break;
                }
            }

            int iInnerHeight = height - (iStrokWidth * fillfitValue * 2);
            int iInnerWidth = width - (iStrokWidth * fillfitValue * 2);

            iInnerWidth = (int) Math.round(iInnerWidth * renderProgress);

            int x = iStrokWidth * fillfitValue;
            int y = iStrokWidth * fillfitValue;
            Point2D start = new Point2D.Double(x, y);
            Point2D end = new Point2D.Double(x, y + iInnerHeight);

            if (gradient) {
                Color[] colors = {progressColor, progressColor.brighter(), progressColor.darker()};
                LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
                g2d.setPaint(p);
            } else {
                g2d.setColor(progressColor);
                g2d.setBackground(progressColor);
            }
            int innerArc = caculateARC(iInnerHeight);
            RoundRectangle2D fill = new RoundRectangle2D.Double(x, y, iInnerWidth, iInnerHeight, innerArc, innerArc);

            g2d.fill(fill);

            g2d.dispose();
        }

        @Override
        protected void installListeners() {
            super.installListeners();
            progressBar.addChangeListener(getChangeHandler());
        }

        protected ChangeListener getChangeHandler() {

            return getHandler();

        }

        protected Handler getHandler() {

            if (handler == null) {
                handler = new Handler();
            }

            return handler;

        }

        protected class Handler implements ChangeListener {

            @Override
            public void stateChanged(ChangeEvent e) {

                BoundedRangeModel model = progressBar.getModel();
                int newRange = model.getMaximum() - model.getMinimum();
                double dProgress = (double) (model.getValue() / (double) newRange);

                if (dProgress < 0) {
                    dProgress = 0;
                } else if (dProgress > 1) {
                    dProgress = 1;
                }

                setRenderProgress(dProgress);

            }

        }

    }

}
