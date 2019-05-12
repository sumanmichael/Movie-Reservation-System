/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package movie.movie;

/**
 *
 * @author SumanMichael
 */
import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Screen {
    private static String username;
    public static void main(String[] args) {
    	new Screen("Test");	
    }
    public Screen(String username) {
        this.username = username;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    createAndShowGUI();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void createAndShowGUI() throws IOException {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        // f.getContentPane().setLayout(new java.awt.GridLayout(2, 2));
        f.setLayout(null);
        f.setContentPane(new JLabel(new ImageIcon("images//screenpat.jpg")));
        p.setLayout(new java.awt.GridLayout(2, 2));
        ImageHoverButton b1 = new ImageHoverButton(loadImage("images//mv1.jpg"), loadImage("images//mv1bg.jpg"));
        ImageHoverButton b2 = new ImageHoverButton(loadImage("images//mv2.jpg"), loadImage("images//mv2bg.jpg"));
        ImageHoverButton b3 = new ImageHoverButton(loadImage("images//mv3.jpg"), loadImage("images//mv3bg.jpg"));
        ImageHoverButton b4 = new ImageHoverButton(loadImage("images//mv4.jpg"), loadImage("images//mv4bg.jpg"));

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
		p.setBounds(0,50,1366,655);
		JButton logout = new JButton("Logout");
		JButton his = new JButton("History");
		logout.setBounds(1100,5,80,40);
		his.setBounds(1200,5,80,40);
		f.add(logout);        
		f.add(his);        
        f.add(p);


        // f.getLayeredPane().add(new JButton("BACK"));
        // f.getContentPane().add(b1);
        // f.getContentPane().add(b2);
        // f.getContentPane().add(b3);
        // f.getContentPane().add(b4);
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               f.dispose();
               new Timing(username,"screen1","Jersey");
            }
        });
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               f.dispose();
               new Timing(username,"screen2","Majili");
            }
        });
        
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               f.dispose();
               new Timing(username,"screen3","Avengers Endgame");
            }
        });
        
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               f.dispose();
               new Timing(username,"screen4","Missamma");
            }
        });

        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               f.dispose();
               new Login();
            }
        });

        his.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               f.dispose();
               new History(username);
            }
        });

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.pack();
        f.dispose();
        // f.setUndecorated(true);
        f.setVisible(true);
    }

    private static BufferedImage loadImage(String path) throws IOException {
        return convertToARGB(ImageIO.read(new File(path)));
    }

    public static BufferedImage convertToARGB(BufferedImage image) {
        BufferedImage newImage = new BufferedImage(image.getWidth(),
                image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

}

class ImageHoverButton extends JButton {
    private class MouseHoverListener extends MouseAdapter {
        @Override
        public void mouseExited(MouseEvent me) {
            opacityAnimator.changeOpacity(0.0f, 250);
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            opacityAnimator.changeOpacity(1.0f, 300);
        }

        @Override
        public void mousePressed(MouseEvent me) {
            opacityAnimator.changeOpacity(1.0f, 50);
        }
    }

    private class OpacityAnimator {
        private final int DELAY_MS = 10;
        private final Timer timer;

        private float targetOpacity;
        private float currentOpacity;
        private float opacityStep;

        OpacityAnimator() {
            timer = new Timer(DELAY_MS, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentOpacity > targetOpacity) {
                        currentOpacity += opacityStep;
                        currentOpacity = Math.max(
                                             currentOpacity, targetOpacity);
                    } else if (currentOpacity < targetOpacity) {
                        currentOpacity += opacityStep;
                        currentOpacity = Math.min(
                                             currentOpacity, targetOpacity);
                    }
                    if (currentOpacity == targetOpacity) {
                        timer.stop();
                    }
                    setOpacity(currentOpacity);
                }
            });
        }

        void changeOpacity(float targetOpacity, int durationMs) {
            timer.stop();
            this.targetOpacity = targetOpacity;

            float delta = targetOpacity - currentOpacity;
            if (durationMs > 0) {
                opacityStep = (delta / durationMs) * DELAY_MS;
            } else {
                opacityStep = delta;
            }
            timer.start();
        }
    }

    private final OpacityAnimator opacityAnimator;
    private final BufferedImage backgroundImage;
    private final BufferedImage foregroundImage;
    private float opacity = 0.0f;

    public ImageHoverButton(BufferedImage backgroundImage,
                            BufferedImage foregroundImage) {
        this.backgroundImage = backgroundImage;
        this.foregroundImage = foregroundImage;
        this.opacityAnimator = new OpacityAnimator();
        addMouseListener(new MouseHoverListener());
        setOpaque(false);
        setBorderPainted(false);
        setRolloverEnabled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public Dimension getPreferredSize() {
        if (super.isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        int w = Math
                .max(backgroundImage.getWidth(), foregroundImage.getWidth());
        int h = Math.max(backgroundImage.getHeight(),
                         foregroundImage.getHeight());
        return new Dimension(w, h);
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        g.drawImage(backgroundImage, 0, 0, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                       opacity));
        g.drawImage(foregroundImage, 0, 0, null);
    }
}
