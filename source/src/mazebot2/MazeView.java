package mazebot2;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MazeView extends JFrame{
    private int size;
    private JLayeredPane mainLayer;
    private JPanel tilePanel;
    private JLabel[][] mazeTiles;

    private JPanel summaryPanel;
    private JTextField summaryText;
    private JTextField summaryResult;
    private JTextField summaryStats;
    private JTextField summaryStats2;


    public MazeView(int size){
        this.size = size;
        initComponents();
        //initTileLabel();

        setLocationRelativeTo(null);
        setVisible(true);


    }

    private void initComponents(){
        mainLayer = new JLayeredPane();
        tilePanel = new JPanel();
        mazeTiles = new JLabel[size][size];
        summaryPanel = new JPanel();
        summaryText = new JTextField();
        summaryResult = new JTextField();
        summaryStats = new JTextField();
        summaryStats2 = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 700));
        setSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(null);

        summaryPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        summaryText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        summaryText.setText("Summary");
        summaryText.setEditable(false);
        summaryText.setBorder(null);
        summaryText.setFont(new java.awt.Font("Segoe UI", 0, 16));

        summaryResult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        summaryResult.setText("\"The maze was successfully traversed!\"");
        summaryResult.setEditable(false);
        summaryResult.setBorder(null);
        summaryResult.setFont(new java.awt.Font("Segoe UI", 0, 16));

        summaryStats.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        summaryStats.setEditable(false);
        summaryStats.setBorder(null);
        summaryStats.setFont(new java.awt.Font("Segoe UI", 0, 16));

        summaryStats2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        summaryStats2.setEditable(false);
        summaryStats2.setBorder(null);
        summaryStats2.setFont(new java.awt.Font("Segoe UI", 0, 16));


        javax.swing.GroupLayout gameOverPanelLayout = new javax.swing.GroupLayout(summaryPanel);
        summaryPanel.setLayout(gameOverPanelLayout);
        gameOverPanelLayout.setHorizontalGroup(
                gameOverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(gameOverPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gameOverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(summaryText)
                                        .addComponent(summaryResult)
                                        .addComponent(summaryStats)
                                        .addComponent(summaryStats2))

                                .addContainerGap())
        );
        gameOverPanelLayout.setVerticalGroup(
                gameOverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(gameOverPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(summaryText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(summaryResult)
                                .addGap(15, 15, 15)
                                .addComponent(summaryStats)
                                .addGap(15, 15, 15)
                                .addComponent(summaryStats2)

                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().add(summaryPanel);
        summaryPanel.setBounds((this.getWidth()/2-150), (this.getHeight()/2-120), 300, 200);
        summaryPanel.setVisible(false);

        tilePanel.setLayout(new GridLayout(size, size));

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                mazeTiles[i][j] = new JLabel();
                mazeTiles[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
                mazeTiles[i][j].setOpaque(true);
                tilePanel.add(mazeTiles[i][j]);
            }

        }

        GroupLayout mainLayerLayout = new GroupLayout(mainLayer);
        mainLayer.setLayout(mainLayerLayout);
        mainLayerLayout.setHorizontalGroup(
                mainLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(mainLayerLayout.createSequentialGroup()
                                .addGroup(mainLayerLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(tilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))

        );
        mainLayerLayout.setVerticalGroup(
                mainLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainLayerLayout.createSequentialGroup()
                                        .addGap(5)
                                        .addComponent(tilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(5, Short.MAX_VALUE)))
        );

        getContentPane().add(mainLayer);
        mainLayer.setBounds(30, 5, 700, 700);

        pack();
    }

    public JPanel getTilePanel(){
        return tilePanel;
    }

    public JLabel getMazeTiles(int x, int y){
        return mazeTiles[x][y];
    }

    public void setTilePanelLayout(LayoutManager mgr){
        tilePanel.setLayout(mgr);
    }

    public void setMazeTile(int x, int y, JLabel jLabel){
        mazeTiles[x][y] = jLabel;
    }

    public void setMazeTileBorder(int x, int y, Border border){
        mazeTiles[x][y].setBorder(border);
    }

    public void setMazeTileBackground(int x, int y, Color color){
        mazeTiles[x][y].setBackground(color);
    }

    public void addTilePanel(Component comp){
        tilePanel.add(comp);
    }
    public void removeMazeTileIcon(int x, int y){
        mazeTiles[x][y].setIcon(null);
    }
    public void setMazeBot(int x, int y){
        mazeTiles[x][y].setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/mazebot2/bot.png")).getImage().getScaledInstance(mazeTiles[x][y].getHeight(), mazeTiles[x][y].getHeight(), Image.SCALE_SMOOTH)));
    }
    public void setSummaryResult(String text){
        summaryResult.setText(text);
    }
    public void setSummaryStats(String text){
        summaryStats.setText(text);
    }
    public void setSummaryStats2(String text){
        summaryStats2.setText(text);
    }
    public void setSummaryVisibility(boolean value){
        summaryPanel.setVisible(value);
    }

}