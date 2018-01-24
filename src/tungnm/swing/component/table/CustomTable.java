/**
 * Copyright(C) 2016 NMT
 *
 * Class CustomTable.java May 6, 2016 Nguyen Manh Tung
 */
package tungnm.swing.component.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import tungnm.swing.component.button.ButtonType;
import tungnm.swing.component.button.StandardButton;
import tungnm.swing.util.Theme;

/**
 *
 * @author グエン。マイン。テウン (Nguyen Manh Tung)
 */
public class CustomTable extends JTable {

    private EvenOddRenderer headerRender;
    private EvenOddRenderer contentRender;
    private EvenOddRendererEditor contentRenderEditor;

    public enum EditorType {
        ACTION_BUTTON,
        EDIT_TEXT,
    }

    public CustomTable() {
        initTable();
    }

    public CustomTable(TableModel dataModel) {
        super(dataModel);
        initTable();
    }

    private void initTable() {
        this.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.setFont(new Font("Arial", 2, 14));
        this.setGridColor(new java.awt.Color(255, 255, 255));
        this.setRowHeight(30);
        this.setRowMargin(0);
        this.setShowGrid(false);
        this.setShowVerticalLines(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        headerRender = new EvenOddRenderer(true);
        contentRender = new EvenOddRenderer();
        contentRenderEditor = new EvenOddRendererEditor();
        this.getTableHeader().setDefaultRenderer(headerRender);
        this.setDefaultRenderer(Object.class, contentRender);
        this.setDefaultEditor(Object.class, contentRender);
    }

    public void setEditor(EditorType editorType) {
        switch (editorType) {
            case ACTION_BUTTON:
                this.setDefaultEditor(Object.class, contentRender);
                break;
            case EDIT_TEXT:
                this.setDefaultEditor(Object.class, contentRenderEditor);
                break;
        }

    }

    public Color getEvenColorBackground() {
        return contentRender.getEvenColorBackground();
    }

    public void setEvenColorBackground(Color evenColorBackground) {
        this.contentRender.setEvenColorBackground(evenColorBackground);
        this.contentRenderEditor.setEvenColorBackground(evenColorBackground);
    }

    public Color getEvenColorForeground() {
        return contentRender.getEvenColorForeground();
    }

    public void setEvenColorForeground(Color evenColorForeground) {
        this.contentRender.setEvenColorForeground(evenColorForeground);
        this.contentRenderEditor.setEvenColorForeground(evenColorForeground);
    }

    public Color getOddColorBackground() {
        return contentRender.getOddColorBackground();
    }

    public void setOddColorBackground(Color oddColorBackground) {
        this.contentRender.setOddColorBackground(oddColorBackground);
        this.contentRenderEditor.setOddColorBackground(oddColorBackground);
    }

    public Color getOddColorForeground() {
        return contentRender.getOddColorForeground();
    }

    public void setOddColorForeground(Color oddColorForeground) {
        this.contentRender.setOddColorForeground(oddColorForeground);
        this.contentRenderEditor.setOddColorForeground(oddColorForeground);
    }

    public Color getSelectedColorBackground() {
        return contentRender.getSelectedColorBackground();
    }

    public void setSelectedColorBackground(Color selectedColorBackground) {
        this.contentRender.setSelectedColorBackground(selectedColorBackground);
    }

    public Color getSelectedColorForeground() {
        return contentRender.getSelectedColorForeground();
    }

    public void setSelectedColorForeground(Color selectedColorForeground) {
        this.contentRender.setSelectedColorForeground(selectedColorForeground);
    }

    public Color getHeaderColorBackground() {
        return headerRender.getHeaderColorBackground();
    }

    public void setHeaderColorBackground(Color headerColorBackground) {
        this.headerRender.setHeaderColorBackground(headerColorBackground);
    }

    public Color getHeaderColorForeground() {
        return headerRender.getHeaderColorForeground();
    }

    public void setHeaderColorForeground(Color headerColorForeground) {
        this.headerRender.setHeaderColorForeground(headerColorForeground);
    }

    public int getHeaderHeight() {
        return headerRender.getHeaderHeight();
    }

    public void setHeaderHeight(int headerHeight) {
        this.headerRender.setHeaderHeight(headerHeight);
    }

    public int getHeaderFontHeight() {
        return headerRender.getHeaderFontHeight();
    }

    public void setHeaderFontHeight(int headerFontHeight) {
        this.headerRender.setHeaderFontHeight(headerFontHeight);
    }

    public int getContentFontHeight() {
        return this.contentRender.getContentFontHeight();
    }

    public void setContentFontHeight(int contentFontHeight) {
        this.contentRender.setContentFontHeight(contentFontHeight);
        this.contentRenderEditor.setContentFontHeight(contentFontHeight);
    }

    public Color getSpecialColorBackground() {
        return contentRender.getSpecialColorBackground();
    }

    public void setSpecialColorBackground(Color specialColorBackground) {
        this.contentRender.setSpecialColorBackground(specialColorBackground);
    }

    public Color getSpecialColorForeground() {
        return contentRender.getSpecialColorForeground();
    }

    public void setSpecialColorForeground(Color specialColorForeground) {
        this.contentRender.getSpecialColorForeground();
    }

    public ArrayList<Integer> getSpecialColumnIndex() {
        return contentRender.getSpecialColumnIndex();
    }

    public void setSpecialColumnIndex(int specialColumnIndex) {
        this.contentRender.setSpecialColumnIndex(specialColumnIndex);
    }

    public int getActionColumnIndex() {
        return contentRender.getActionColumnIndex();
    }

    public void setActionColumnIndex(int actionColumnIndex) {
        this.contentRender.setActionColumnIndex(actionColumnIndex);
    }

    public ActionColumn getActionColumnListener() {
        return contentRender.getActionColumnListener();
    }

    public void setActionColumnListener(ActionColumn actionColumnListener) {
        this.contentRender.setActionColumnListener(actionColumnListener);
    }

    public String getTextActionColumn() {
        return contentRender.getTextActionColumn();
    }

    public void setTextActionColumn(String textActionColumn) {
        this.contentRender.setTextActionColumn(textActionColumn);
    }

    public int getActionColumnWidth() {
        return contentRender.getActionColumnWidth();
    }

    public void setActionColumnWidth(int actionColumnWidth) {
        this.contentRender.setActionColumnWidth(actionColumnWidth);
    }

    public ArrayList<Color> getSpecialColumnColorForegroud() {
        return this.contentRender.getSpecialColumnColorForegroud();
    }

    public void setSpecialColumnColorForegroud(Color specialColumnColorForegroud) {
        this.contentRender.setSpecialColumnColorForegroud(specialColumnColorForegroud);
    }

    public void setSpecialColumnColorForegroud(Color specialColumnColorForegroud, int index) {
        this.contentRender.setSpecialColumnColorForegroud(specialColumnColorForegroud, index);
    }

    class EvenOddRenderer extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

        private Color evenColorBackground = new Color(102, 153, 0, 60);
        private Color evenColorForeground = Color.BLACK;
        private Color oddColorBackground = Color.WHITE;
        private Color oddColorForeground = Color.BLACK;
        private Color selectedColorBackground = new Color(102, 153, 0, 180);
        private Color selectedColorForeground = Color.BLACK;
        private Color headerColorBackground = new Color(102, 153, 0);
        private Color headerColorForeground = Color.WHITE;
        private Color specialColorBackground = new Color(102, 153, 0);
        private Color specialColorForeground = Color.RED;
        private ArrayList<Integer> specialColumnIndex = new ArrayList<>();
        private ArrayList<Color> specialColumnColorForegroud = new ArrayList<>();
        private int actionColumnIndex = -1;
        private int headerHeight = 40;
        private int headerFontHeight = 16;
        private int contentFontHeight = 14;
        private boolean header = false;
        private String textActionColumn = "ACTION";
        private int actionColumnWidth = 150;
        private ActionColumn actionColumnListener;
        public final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
        private boolean actionColumnClicked = false;

        public EvenOddRenderer() {

        }

        public EvenOddRenderer(boolean header) {
            this.header = header;
        }

        public EvenOddRenderer(boolean header, Color headerColorBackground) {
            this.header = header;
            this.headerColorForeground = headerColorBackground;
        }

        public EvenOddRenderer(Color evenColorBackground, Color oddColorBackground) {
            this();
            this.evenColorBackground = evenColorBackground;
            this.oddColorBackground = oddColorBackground;
        }

        public Color getEvenColorBackground() {
            return evenColorBackground;
        }

        public void setEvenColorBackground(Color evenColorBackground) {
            this.evenColorBackground = evenColorBackground;
        }

        public Color getEvenColorForeground() {
            return evenColorForeground;
        }

        public void setEvenColorForeground(Color evenColorForeground) {
            this.evenColorForeground = evenColorForeground;
        }

        public Color getOddColorBackground() {
            return oddColorBackground;
        }

        public void setOddColorBackground(Color oddColorBackground) {
            this.oddColorBackground = oddColorBackground;
        }

        public Color getOddColorForeground() {
            return oddColorForeground;
        }

        public void setOddColorForeground(Color oddColorForeground) {
            this.oddColorForeground = oddColorForeground;
        }

        public Color getSelectedColorBackground() {
            return selectedColorBackground;
        }

        public void setSelectedColorBackground(Color selectedColorBackground) {
            this.selectedColorBackground = selectedColorBackground;
        }

        public Color getSelectedColorForeground() {
            return selectedColorForeground;
        }

        public void setSelectedColorForeground(Color selectedColorForeground) {
            this.selectedColorForeground = selectedColorForeground;
        }

        public Color getHeaderColorBackground() {
            return headerColorBackground;
        }

        public void setHeaderColorBackground(Color headerColorBackground) {
            this.headerColorBackground = headerColorBackground;
        }

        public Color getHeaderColorForeground() {
            return headerColorForeground;
        }

        public void setHeaderColorForeground(Color headerColorForeground) {
            this.headerColorForeground = headerColorForeground;
        }

        public Color getSpecialColorBackground() {
            return specialColorBackground;
        }

        public void setSpecialColorBackground(Color specialColorBackground) {
            this.specialColorBackground = specialColorBackground;
        }

        public Color getSpecialColorForeground() {
            return specialColorForeground;
        }

        public void setSpecialColorForeground(Color specialColorForeground) {
            this.specialColorForeground = specialColorForeground;
        }

        public ArrayList<Integer> getSpecialColumnIndex() {
            return this.specialColumnIndex;
        }

        public void setSpecialColumnIndex(int specialColumnIndex) {
            if (!this.specialColumnIndex.contains(specialColumnIndex)) {
                this.specialColumnIndex.add(specialColumnIndex);
                this.setSpecialColumnColorForegroud(specialColorForeground);
            }
        }

        public ArrayList<Color> getSpecialColumnColorForegroud() {
            return specialColumnColorForegroud;
        }

        public void setSpecialColumnColorForegroud(Color specialColumnColorForegroud) {
            this.specialColumnColorForegroud.add(specialColumnColorForegroud);
        }

        public void setSpecialColumnColorForegroud(Color specialColumnColorForegroud, int index) {
            this.specialColumnColorForegroud.set(index, specialColumnColorForegroud);
        }

        public boolean isHeader() {
            return header;
        }

        public void setHeader(boolean header) {
            this.header = header;
        }

        public int getHeaderHeight() {
            return headerHeight;
        }

        public void setHeaderHeight(int headerHeight) {
            this.headerHeight = headerHeight;
        }

        public int getHeaderFontHeight() {
            return headerFontHeight;
        }

        public void setHeaderFontHeight(int headerFontHeight) {
            this.headerFontHeight = headerFontHeight;
        }

        public int getContentFontHeight() {
            return contentFontHeight;
        }

        public void setContentFontHeight(int contentFontHeight) {
            this.contentFontHeight = contentFontHeight;
        }

        public int getActionColumnIndex() {
            return actionColumnIndex;
        }

        public void setActionColumnIndex(int actionColumnIndex) {
            this.actionColumnIndex = actionColumnIndex;
        }

        public String getTextActionColumn() {
            return textActionColumn;
        }

        public void setTextActionColumn(String textActionColumn) {
            this.textActionColumn = textActionColumn;
        }

        public ActionColumn getActionColumnListener() {
            return actionColumnListener;
        }

        public void setActionColumnListener(ActionColumn actionColumnListener) {
            this.actionColumnListener = actionColumnListener;
        }

        public int getActionColumnWidth() {
            return actionColumnWidth;
        }

        public void setActionColumnWidth(int actionColumnWidth) {
            this.actionColumnWidth = actionColumnWidth;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Color foreground, background;
            if (column != actionColumnIndex) {
                JLabel renderer = (JLabel) DEFAULT_RENDERER.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                renderer.setOpaque(true);
                if (header) {
                    renderer.setFont(new Font("Arail", Font.BOLD, headerFontHeight));
                    renderer.setPreferredSize(new Dimension(renderer.getWidth(), headerHeight));
                    foreground = headerColorForeground;
                    background = headerColorBackground;
                } else {
                    renderer.setFont(new Font("Arail", Font.PLAIN, contentFontHeight));
                    if (isSelected) {
                        foreground = selectedColorForeground;
                        background = selectedColorBackground;
                    } else if (row % 2 == 0) {
                        foreground = oddColorForeground;
                        background = oddColorBackground;
                    } else {
                        foreground = evenColorForeground;
                        background = evenColorBackground;
                    }
                    for (int i = 0; i < specialColumnIndex.size(); i++) {
                        if (column == specialColumnIndex.get(i)) {
                            foreground = specialColumnColorForegroud.get(i);
                            renderer.setFont(new Font("Arail", Font.BOLD, contentFontHeight));
                        }
                    }
                }
                renderer.setForeground(foreground);
                renderer.setBackground(background);
                return renderer;
            } else {
                JPanel renderer = new JPanel();
                renderer.setLayout(null);
                actionColumnClicked = false;
                if (isSelected) {
                    background = selectedColorBackground;
                } else if (row % 2 == 0) {
                    background = oddColorBackground;
                } else {
                    background = evenColorBackground;
                }
                StandardButton btnActionColumn = new StandardButton(textActionColumn, ButtonType.BUTTON_ROUNDED_RECTANGLUR, Theme.STANDARD_LIME_THEME, Theme.STANDARD_LIGHTORANGE_THEME, Theme.STANDARD_LIGHTORANGE_THEME);
                btnActionColumn.setFont(new Font("Tahoma", Font.BOLD, 14));
                btnActionColumn.setBounds(5, 2, actionColumnWidth, 25);
                renderer.add(btnActionColumn);
                btnActionColumn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actionColumnClicked = true;
                        if (actionColumnListener != null) {
                            actionColumnListener.buttonColumnActionPerform(row);
                        }
                        repaint();
                        revalidate();
                    }
                });
                if (actionColumnClicked) {
                    background = selectedColorBackground;
                }
                renderer.setBackground(background);
                return renderer;
            }
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return table.getCellRenderer(row, column).getTableCellRendererComponent(table, value, isSelected, isSelected, row, column);
        }

        @Override
        public Object getCellEditorValue() {
            return textActionColumn;
        }
    }

    class EvenOddRendererEditor extends AbstractCellEditor implements TableCellEditor {

        private Color evenColorBackground = new Color(102, 153, 0, 60);
        private Color evenColorForeground = Color.BLACK;
        private Color oddColorBackground = Color.WHITE;
        private Color oddColorForeground = Color.BLACK;
        private int contentFontHeight = 14;
        private JTextField txtContent;
//        private String value = "";

        public EvenOddRendererEditor() {
            txtContent = new JTextField();
//            txtContent.setText(value);
            txtContent.setFont(new Font("Arail", Font.BOLD, contentFontHeight));
//            txtContent.setBackground(new java.awt.Color(51, 51, 51));
//            txtContent.setForeground(new java.awt.Color(255, 255, 255));
            txtContent.setBorder(new javax.swing.border.LineBorder(new Color(102, 153, 0), 2, false));
            txtContent.setPreferredSize(new java.awt.Dimension(6, 30));
            txtContent.setSelectedTextColor(new java.awt.Color(51, 51, 51));
            txtContent.setSelectionColor(new java.awt.Color(153, 204, 0));
        }

        public EvenOddRendererEditor(Color evenColorBackground, Color oddColorBackground) {
            this.evenColorBackground = evenColorBackground;
            this.oddColorBackground = oddColorBackground;
        }

        public Color getEvenColorBackground() {
            return evenColorBackground;
        }

        public void setEvenColorBackground(Color evenColorBackground) {
            this.evenColorBackground = evenColorBackground;
        }

        public Color getEvenColorForeground() {
            return evenColorForeground;
        }

        public void setEvenColorForeground(Color evenColorForeground) {
            this.evenColorForeground = evenColorForeground;
        }

        public Color getOddColorBackground() {
            return oddColorBackground;
        }

        public void setOddColorBackground(Color oddColorBackground) {
            this.oddColorBackground = oddColorBackground;
        }

        public Color getOddColorForeground() {
            return oddColorForeground;
        }

        public void setOddColorForeground(Color oddColorForeground) {
            this.oddColorForeground = oddColorForeground;
        }

        public int getContentFontHeight() {
            return contentFontHeight;
        }

        public void setContentFontHeight(int contentFontHeight) {
            this.contentFontHeight = contentFontHeight;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            Color foreground, background;

            if (row % 2 == 0) {
                foreground = oddColorForeground;
                background = oddColorBackground;
            } else {
                foreground = evenColorForeground;
                background = evenColorBackground;
            }
            txtContent.setForeground(foreground);
            txtContent.setBackground(background);
            txtContent.setText(value.toString());
            return txtContent;
        }

        @Override
        public Object getCellEditorValue() {
            return txtContent.getText();
        }
    }

    public interface ActionColumn {

        public void buttonColumnActionPerform(int selectedRow);
    }

    //GroupableTableHeader
    public class GroupableTableHeader extends JTableHeader {

        private static final String uiClassID = "GroupableTableHeaderUI";
        protected Vector columnGroups = null;

        public GroupableTableHeader(TableColumnModel model) {
            super(model);
            setUI(new GroupableTableHeaderUI());
            setReorderingAllowed(false);
        }

        @Override
        public void updateUI() {
            setUI(new GroupableTableHeaderUI());
        }

        @Override
        public void setReorderingAllowed(boolean b) {
            reorderingAllowed = false;
        }

        public void addColumnGroup(ColumnGroup g) {
            if (columnGroups == null) {
                columnGroups = new Vector();
            }
            columnGroups.addElement(g);
        }

        public Enumeration getColumnGroups(TableColumn col) {
            if (columnGroups == null) {
                return null;
            }
            Enumeration e = columnGroups.elements();
            while (e.hasMoreElements()) {
                ColumnGroup cGroup = (ColumnGroup) e.nextElement();
                Vector v_ret = (Vector) cGroup.getColumnGroups(col, new Vector());
                if (v_ret != null) {
                    return v_ret.elements();
                }
            }
            return null;
        }

        public void setColumnMargin() {
            if (columnGroups == null) {
                return;
            }
            int columnMargin = getColumnModel().getColumnMargin();
            Enumeration e = columnGroups.elements();
            while (e.hasMoreElements()) {
                ColumnGroup cGroup = (ColumnGroup) e.nextElement();
                cGroup.setColumnMargin(columnMargin);
            }
        }

    }

    public class GroupableTableHeaderUI extends BasicTableHeaderUI {

        public void paint(Graphics g, JComponent c) {
            Rectangle clipBounds = g.getClipBounds();
            if (header.getColumnModel() == null) {
                return;
            }
            ((GroupableTableHeader) header).setColumnMargin();
            int column = 0;
            Dimension size = header.getSize();
            Rectangle cellRect = new Rectangle(0, 0, size.width, size.height);
            Hashtable h = new Hashtable();
            int columnMargin = header.getColumnModel().getColumnMargin();

            Enumeration enumeration = header.getColumnModel().getColumns();
            while (enumeration.hasMoreElements()) {
                cellRect.height = size.height;
                cellRect.y = 0;
                TableColumn aColumn = (TableColumn) enumeration.nextElement();
                Enumeration cGroups = ((GroupableTableHeader) header).getColumnGroups(aColumn);
                if (cGroups != null) {
                    int groupHeight = 0;
                    while (cGroups.hasMoreElements()) {
                        ColumnGroup cGroup = (ColumnGroup) cGroups.nextElement();
                        Rectangle groupRect = (Rectangle) h.get(cGroup);
                        if (groupRect == null) {
                            groupRect = new Rectangle(cellRect);
                            Dimension d = cGroup.getSize(header.getTable());
                            groupRect.width = d.width;
                            groupRect.height = d.height;
                            h.put(cGroup, groupRect);
                        }
                        paintCell(g, groupRect, cGroup);
                        groupHeight += groupRect.height;
                        cellRect.height = size.height - groupHeight;
                        cellRect.y = groupHeight;
                    }
                }
                cellRect.width = aColumn.getWidth() + columnMargin;
                if (cellRect.intersects(clipBounds)) {
                    paintCell(g, cellRect, column);
                }
                cellRect.x += cellRect.width;
                column++;
            }
        }

        private void paintCell(Graphics g, Rectangle cellRect, int columnIndex) {
            TableColumn aColumn = header.getColumnModel().getColumn(columnIndex);
            TableCellRenderer renderer = header.getDefaultRenderer();
            Component c = renderer.getTableCellRendererComponent(
                    header.getTable(), aColumn.getHeaderValue(), false, false, -1, columnIndex);

            rendererPane.add(c);
            rendererPane.paintComponent(g, c, header, cellRect.x, cellRect.y,
                    cellRect.width, cellRect.height, true);
        }

        private void paintCell(Graphics g, Rectangle cellRect, ColumnGroup cGroup) {
            TableCellRenderer renderer = cGroup.getHeaderRenderer();

            Component component = renderer.getTableCellRendererComponent(
                    header.getTable(), cGroup.getHeaderValue(), false, false, -1, -1);
            rendererPane.add(component);
            rendererPane.paintComponent(g, component, header, cellRect.x, cellRect.y,
                    cellRect.width, cellRect.height, true);
        }

        private int getHeaderHeight() {
            int height = 0;
            TableColumnModel columnModel = header.getColumnModel();
            for (int column = 0; column < columnModel.getColumnCount(); column++) {
                TableColumn aColumn = columnModel.getColumn(column);
                TableCellRenderer renderer = aColumn.getHeaderRenderer();
                //revised by Java2s.com
                if (renderer == null) {
                    return 60;
                }

                Component comp = renderer.getTableCellRendererComponent(
                        header.getTable(), aColumn.getHeaderValue(), false, false, -1, column);
                int cHeight = comp.getPreferredSize().height;
                Enumeration e = ((GroupableTableHeader) header).getColumnGroups(aColumn);
                if (e != null) {
                    while (e.hasMoreElements()) {
                        ColumnGroup cGroup = (ColumnGroup) e.nextElement();
                        cHeight += cGroup.getSize(header.getTable()).height;
                    }
                }
                height = Math.max(height, cHeight);
            }
            return height;
        }

        private Dimension createHeaderSize(long width) {
            TableColumnModel columnModel = header.getColumnModel();
            width += columnModel.getColumnMargin() * columnModel.getColumnCount();
            if (width > Integer.MAX_VALUE) {
                width = Integer.MAX_VALUE;
            }
            return new Dimension((int) width, getHeaderHeight());
        }

        @Override
        public Dimension getPreferredSize(JComponent c) {
            long width = 0;
            Enumeration enumeration = header.getColumnModel().getColumns();
            while (enumeration.hasMoreElements()) {
                TableColumn aColumn = (TableColumn) enumeration.nextElement();
                width = width + aColumn.getPreferredWidth();
            }
            return createHeaderSize(width);
        }
    }

    public class ColumnGroup {

        protected TableCellRenderer renderer;
        protected Vector v;
        protected String text;
        protected int margin = 0;

        public ColumnGroup(String text) {
            this(null, text);
        }

        public ColumnGroup(TableCellRenderer renderer, String text) {
            if (renderer == null) {
                this.renderer = new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value,
                            boolean isSelected, boolean hasFocus, int row, int column) {
                        JTableHeader header = table.getTableHeader();
                        if (header != null) {
                            setForeground(headerRender.getHeaderColorForeground());
                            setBackground(headerRender.getHeaderColorBackground());
                            setFont(new Font("Arail", Font.BOLD, headerRender.getHeaderFontHeight()));
                        }
                        setText((value == null) ? "" : value.toString());
                        return this;
                    }
                };
            } else {
                this.renderer = renderer;
            }
            this.text = text;
            v = new Vector();
        }

        /**
         * @param obj TableColumn or ColumnGroup
         */
        public void add(Object obj) {
            if (obj == null) {
                return;
            }
            v.addElement(obj);
        }

        /**
         * @param c TableColumn
         * @param v ColumnGroups
         */
        public Vector getColumnGroups(TableColumn c, Vector g) {
            g.addElement(this);
            if (v.contains(c)) {
                return g;
            }
            Enumeration e = v.elements();
            while (e.hasMoreElements()) {
                Object obj = e.nextElement();
                if (obj instanceof ColumnGroup) {
                    Vector groups
                            = (Vector) ((ColumnGroup) obj).getColumnGroups(c, (Vector) g.clone());
                    if (groups != null) {
                        return groups;
                    }
                }
            }
            return null;
        }

        public TableCellRenderer getHeaderRenderer() {
            return renderer;
        }

        public void setHeaderRenderer(TableCellRenderer renderer) {
            if (renderer != null) {
                this.renderer = renderer;
            }
        }

        public Object getHeaderValue() {
            return text;
        }

        public Dimension getSize(JTable table) {
            Component comp = renderer.getTableCellRendererComponent(
                    table, getHeaderValue(), false, false, -1, -1);
            int height = comp.getPreferredSize().height;
            int width = 0;
            Enumeration e = v.elements();
            while (e.hasMoreElements()) {
                Object obj = e.nextElement();
                if (obj instanceof TableColumn) {
                    TableColumn aColumn = (TableColumn) obj;
                    width += aColumn.getWidth();
                    width += margin;
                } else {
                    width += ((ColumnGroup) obj).getSize(table).width;
                }
            }
            return new Dimension(width, height);
        }

        public void setColumnMargin(int margin) {
            this.margin = margin;
            Enumeration e = v.elements();
            while (e.hasMoreElements()) {
                Object obj = e.nextElement();
                if (obj instanceof ColumnGroup) {
                    ((ColumnGroup) obj).setColumnMargin(margin);
                }
            }
        }
    }
}
