/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hailo
 */

public class GetFileIMG {

    public String getPath(JFileChooser jFileChooser) {
        int returnName = jFileChooser.showOpenDialog(null);
        String path = null;
        if (returnName == JFileChooser.APPROVE_OPTION) {
            File f = jFileChooser.getSelectedFile();
            if (f != null) {
                path = f.getAbsolutePath();
            }
        }
        return path;
    }

    public void displayIMG(String path, JPanel jPanel) {
        try {
            jPanel.removeAll();
            BufferedImage imgbuf = ImageIO.read(new File(path));
            Image image = imgbuf;
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(jPanel.getWidth(), jPanel.getHeight(), Image.SCALE_SMOOTH));
            JLabel jLabel = new JLabel(imageIcon);            
            jLabel.setSize(jPanel.getWidth(), jPanel.getHeight());
            jPanel.add(jLabel);
            jPanel.repaint();
        } catch (IOException ex) {
            Logger.getLogger(GetFileIMG.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
