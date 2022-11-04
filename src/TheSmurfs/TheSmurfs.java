/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheSmurfs;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kutaybil
 */
public class TheSmurfs extends javax.swing.JFrame {

    static JLabel tiles[][] = new JLabel[12][14];
    static char[][] maze = new char[12][14];
    static int isPushed = 0, y = 0, x = 0, oyuncuSirasi = 0;
    static tembel tembelSirin = new tembel(1, "tembel", "oyuncu", 6, 5, 1);
    static gozluklu gozlukluSirin = new gozluklu(2, "gozluklu", "oyuncu", 6, 5, 2);
    static JLabel altin[] = new JLabel[5];
    static int altinx[] = new int[5];
    static int altiny[] = new int[5];
    int score = 0;
    static gargamel Gargamel = new gargamel(3, "gargamel", "dusman", 10, 0);
    static oyuncu player1 = new oyuncu(0, "tmp", "tmp", 6, 5, 0);
    static int sayac = 0, mantarx = 0, mantary = 0;
    JLabel lblMushroom = new JLabel();

    public TheSmurfs() {

        initComponents();
        setTitle("TheSmurfs");
        setSize(1400, 800);
        this.getContentPane().setBackground(Color.CYAN);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        x = tembelSirin.X;
        y = tembelSirin.Y;

        addKeyListener(
                new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e
            ) {
            }

            @Override
            public void keyReleased(KeyEvent e
            ) {
            }

            @Override
            public void keyPressed(KeyEvent e
            ) {
                if (e.getKeyCode() == 39 && maze[y][x + 1] == '1' && x < 13 && oyuncuSirasi == 0) { //saga gitme
                    jLabel3.setBounds((x + 1) * 60 + 50, y * 60 + 40, 60, 60);
                    player1.X++;
                    x++;
                    oyuncuSirasi = 1;
                    scoreTable();
                    gargamelYurutme(dijkstra.gargamel);
                }
                if (e.getKeyCode() == 37 && maze[y][x - 1] == '1' && x > 0 && oyuncuSirasi == 0) { //sola gitme
                    System.out.print("test");
                    jLabel3.setBounds((x - 1) * 60 + 50, y * 60 + 40, 60, 60);
                    player1.X--;
                    x--;
                    oyuncuSirasi = 1;
                    scoreTable();
                    gargamelYurutme(dijkstra.gargamel);

                }
                if (e.getKeyCode() == 38 && maze[y - 1][x] == '1' && y > 0 && oyuncuSirasi == 0) { //uste gitme
                    jLabel3.setBounds(x * 60 + 50, (y - 1) * 60 + 40, 60, 60);
                    player1.Y--;
                    y--;
                    oyuncuSirasi = 1;
                    scoreTable();
                    gargamelYurutme(dijkstra.gargamel);
                }
                if (e.getKeyCode() == 40 && maze[y + 1][x] == '1' && y < 12 && oyuncuSirasi == 0) {//alta gitme
                    jLabel3.setBounds(x * 60 + 50, (y + 1) * 60 + 40, 60, 60);
                    player1.Y++;
                    y++;
                    oyuncuSirasi = 1;
                    scoreTable();
                    gargamelYurutme(dijkstra.gargamel);
                }

            }
        }
        );
        lblGargamel.setIcon(new ImageIcon("C:\\Users\\kutaybil\\Desktop\\gargamelIcon.jpg"));
        lblGargamel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.getContentPane().add(lblGargamel, 4);
        deneme();
        goldSpawn();
        mushroomSpawn();

    }

    public void goldSpawn() {
        for (int i = 0; i < 5; i++) {
            altin[i] = new JLabel();
            this.getContentPane().add(altin[i], 1);
            this.getContentPane().add(jLabel3, 2);
            altin[i].setVisible(true);
            altin[i].setOpaque(true);
            altin[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            altin[i].setIcon(new javax.swing.ImageIcon("C:\\Users\\kutaybil\\Desktop\\coin.jpg"));
        }
    }

    public void mushroomSpawn() {
        this.getContentPane().add(lblMushroom, 2);
        this.getContentPane().add(jLabel3, 2);
        lblMushroom.setVisible(true);
        lblMushroom.setOpaque(true);
        lblMushroom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblMushroom.setIcon(new javax.swing.ImageIcon("C:\\Users\\kutaybil\\Desktop\\mushroom.png"));
    }

    public void deneme() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                tiles[i][j] = new JLabel();
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {

                this.getContentPane().add(tiles[i][j]);
                tiles[i][j].setVisible(true);
                tiles[i][j].setOpaque(true);
                tiles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }

        try {
            File f = new File("harita.txt");
            FileReader fr = new FileReader(f);
            int c = 0, i = 0, j = 0;

            while ((c = fr.read()) != -1) {

                if ((char) c == '1' || (char) c == '0') {
                    if (i != 11 && j != 13) {
                        if ((char) c == '1') {
                            tiles[i][j].setBounds(j * 60 + 50, i * 60 + 40, 60, 60);
                            tiles[i][j].setBackground(Color.WHITE);
                        } else {
                            tiles[i][j].setBounds(j * 60 + 50, i * 60 + 40, 60, 60);
                            tiles[i][j].setBackground(Color.RED);
                        }
                        maze[i][j] = (char) c;
                        j++;
                    } else if (j == 13) {

                        i++;
                        j = 0;
                        if ((char) c == '1') {
                            tiles[i][j].setBounds(j * 60 + 50, i * 60 + 40, 60, 60);
                            tiles[i][j].setBackground(Color.WHITE);
                        } else {
                            tiles[i][j].setBounds(j * 60 + 50, i * 60 + 40, 60, 60);
                            tiles[i][j].setBackground(Color.RED);
                        }
                        maze[i][j] = (char) c;
                        j++;

                    }
                }

            }
            fr.close();
        } catch (IOException e) {

        }

    }

    class Helper extends TimerTask {

        @Override
        public void run() {
            Random r = new Random();
            int i = 0, j = 0, sayac = 0;
            while (sayac < 5) {
                i = r.nextInt(11);
                j = r.nextInt(13);
                if (maze[i][j] == '1') {
                    altin[sayac].setBounds(50 + 60 * j, 40 + 60 * i, 60, 60);
                    altinx[sayac] = 53 + 60 * j;
                    altiny[sayac] = 50 + 60 * i;
                    sayac++;
                }
            }
            Random r1 = new Random();
            i = 0;
            j = 0;
            i = r1.nextInt(11);
            j = r1.nextInt(13);
            if (maze[i][j] == '1') {
                lblMushroom.setBounds(50 + 60 * j, 40 + 60 * i, 60, 60);
                mantarx = 53 + 60 * i;
                mantary = 50 + 60 * i;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblGargamel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setText("Tembel Şirin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(920, 530, 130, 60);

        jButton2.setText("Gözlüklü Şirin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1150, 530, 130, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\kutaybil\\Desktop\\gozluklu.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1110, 210, 200, 270);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\kutaybil\\Desktop\\tembel1.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(880, 210, 200, 270);

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(410, 340, 60, 60);

        lblGargamel.setText("jLabel4");
        getContentPane().add(lblGargamel);
        lblGargamel.setBounds(650, 40, 60, 60);
        lblGargamel.getAccessibleContext().setAccessibleName("lblGargamel");

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void scoreTable() {

        //lblmantar.getX()=mantara;
        //lblmantar.getY()=mantarb;
        for (int i = 0; i < 5; i++) {
            // altinlar[i].getX()=a[i]; 
            //altinlar[i].getY() =b[i];
            if (player1.X * 60 + 50 == altinx[i] && player1.Y * 60 + 50 == altiny[i]) {
                score += 5;

            }
            if (player1.X * 60 + 50 == mantarx && player1.Y * 60 + 40 == mantary) {
                score += 50;

            }
        }
        System.out.println(score);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel3.setIcon(new ImageIcon("C:\\Users\\kutaybil\\Desktop\\tembelIcon.png"));
        jLabel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.jButton1.setVisible(false);
        this.jButton2.setVisible(false);
        this.jLabel1.setVisible(false);
        this.jLabel2.setVisible(false);
        isPushed = 1;
        player1 = tembelSirin;
        Timer timer = new Timer();
        TimerTask task = new Helper();
        timer.scheduleAtFixedRate(task, 5000, 15000);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jLabel3.setIcon(new ImageIcon("C:\\Users\\kutaybil\\Desktop\\gozlukluIcon.png"));
        jLabel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.jButton1.setVisible(false);
        this.jButton2.setVisible(false);
        this.jLabel1.setVisible(false);
        this.jLabel2.setVisible(false);
        isPushed = 2;
        player1 = gozlukluSirin;
        Timer timer = new Timer();
        TimerTask task = new Helper();
        timer.scheduleAtFixedRate(task, 5000, 15000);
    }//GEN-LAST:event_jButton2ActionPerformed
    public static int[][] path() {
        node[][] vertex = new node[11][13];
        int[][] matrix = new int[13 * 11][13 * 11];
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                vertex[i][j] = new node(count, maze[i][j] == '0');

                count++;
            }
        }
        for (int i = 0; i < 13 * 11; i++) {
            for (int j = 0; j < 13 * 11; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                if (j < 12) {
                    if (vertex[i][j + 1].passed == false) {
                        matrix[vertex[i][j].code][vertex[i][j + 1].code] = 1;
                        matrix[vertex[i][j + 1].code][vertex[i][j].code] = 1;
                        vertex[i][j].passed = false;
                        vertex[i][j + 1].passed = false;
                    }
                }
                if (j > 0) {
                    if (vertex[i][j - 1].passed == false) {
                        matrix[vertex[i][j].code][vertex[i][j - 1].code] = 1;
                        matrix[vertex[i][j - 1].code][vertex[i][j].code] = 1;
                        vertex[i][j].passed = false;
                        vertex[i][j - 1].passed = false;
                    }
                }
                if (i < 10) {
                    if (vertex[i + 1][j].passed == false) {//aşağı bakma
                        matrix[vertex[i][j].code][vertex[i + 1][j].code] = 1;
                        matrix[vertex[i + 1][j].code][vertex[i][j].code] = 1;
                        vertex[i][j].passed = false;
                        vertex[i + 1][j].passed = false;
                    }
                }
                if (i > 0) {
                    if (vertex[i - 1][j].passed == false) {
                        matrix[vertex[i][j].code][vertex[i - 1][j].code] = 1;
                        matrix[vertex[i - 1][j].code][vertex[i][j].code] = 1;
                        vertex[i][j].passed = false;
                        vertex[i - 1][j].passed = false;
                    }
                }
            }
        }
        return matrix;
    }

    public void gargamelYurutme(char labirent[][]) {
       
        dijkstra.Dijkstra(path());
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                if (labirent[i][j] == '1') {
                    tiles[i][j].setBackground(Color.WHITE);
                } else if (labirent[i][j] == '0') {
                    tiles[i][j].setBackground(Color.RED);
                } else {
                    tiles[i][j].setBackground(Color.GREEN);
                }
            }
        }
        if (oyuncuSirasi == 1) {
            if (labirent[Gargamel.y][Gargamel.x + 1] == 'G') {//sağa gitme
                lblGargamel.setBounds((Gargamel.x + 1) * 60 + 50, Gargamel.y * 60 + 40, 60, 60);
                Gargamel.x++;
            } else if (labirent[Gargamel.y][Gargamel.x - 1] == 'G') {//sola gitme
                lblGargamel.setBounds((Gargamel.x - 1) * 60 + 50, Gargamel.y * 60 + 40, 60, 60);
                Gargamel.x--;
            } else if (labirent[Gargamel.y + 1][Gargamel.x] == 'G') {//asagı gitme
                lblGargamel.setBounds(Gargamel.x * 60 + 50, (Gargamel.y + 1) * 60 + 40, 60, 60);
                Gargamel.y++;
            } else if (labirent[Gargamel.y - 1][Gargamel.x] == 'G') {//yukarı gitme
                lblGargamel.setBounds(Gargamel.x * 60 + 50, (Gargamel.y - 1) * 60 + 40, 60, 60);
                Gargamel.y--;
            }
            oyuncuSirasi = 0;
        }

    }

    public static void main(String args[]) throws FileNotFoundException, IOException {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new TheSmurfs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblGargamel;
    // End of variables declaration//GEN-END:variables
}
