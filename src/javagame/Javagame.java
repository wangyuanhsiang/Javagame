/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
//import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
/**
 *
 * @author Yuan-Hsiang
 */
public class Javagame extends JFrame {
    private int x,y;
    private Image dbImage;
    private Graphics dbg;
    
    private class AL implements KeyEventDispatcher {
        
        private int KeyCode;
        
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
             if(e.getID() == e.KEY_PRESSED){
                 KeyCode = e.getKeyCode();
                 
                 if(KeyCode == e.VK_LEFT){ x--;  }
                 if(KeyCode == e.VK_RIGHT){ x++;  }
                 if(KeyCode == e.VK_UP){ y--;  }
                 if(KeyCode == e.VK_DOWN){ y++;  } 
             }
             else if (e.getID() == e.KEY_RELEASED){  }
             else if (e.getID() == e.KEY_TYPED){ }
            return false;    
        }
        
//        public void KeyPressed(KeyEvent e){
//            int KeyCode = e.getKeyCode();
//            if(KeyCode == e.VK_LEFT){ x--;  }
//            if(KeyCode == e.VK_RIGHT){ x++;  }
//            if(KeyCode == e.VK_UP){ y--;  }
//            if(KeyCode == e.VK_DOWN){ y++;  }   
//        }
        
        public void KeyReleased(KeyEvent e){
            
        }

        
        
    }
    
    public Javagame(){
    
    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    manager.addKeyEventDispatcher(new AL());
        
//    addKeyListener(new AL());
    setTitle("Java Game");
    setSize(500, 500);
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    x = 150;
    y = 150;
    
    }
    
    public void paint (Graphics g){
        dbImage = createImage (getWidth(), getHeight()); 
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    
    
    public void paintComponent(Graphics g) {
//        g.drawString("Hello World", 75, 75);
         g.fillOval(x, y, 15, 15);
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Javagame();
    }
    
}
