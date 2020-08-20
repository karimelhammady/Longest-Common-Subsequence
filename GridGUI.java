/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatics_project1;

import javax.swing.text.html.HTML;
import processing.core.*;

/**
 *
 * @author Karim
 */
public class GridGUI extends PApplet {

//    public void setup() {
//
//    }
    public void settings() {
        size(50 * (LCS.y.length() + 2), 50 * (LCS.x.length() + 2));

    }

    public void draw() {
        // Begin loop for rows
        for (int i = 0; i < LCS.x.length() + 2; i++) {
            // Begin loop for columns
            for (int j = 0; j < LCS.y.length() + 2; j++) {

                // Scaling up to draw a rectangle at (x,y)
                int y = i * 50;
                int x = j * 50;
                if (LCS.isCritical[i][j] == 1) {
                    fill(255, 0, 0);
                } else {
                    fill(255);
                }

                stroke(0);
                // For every column and row, a rectangle is drawn at an (x,y) location scaled and sized by videoScale.
                rect(x, y, 50, 50);
                fill(0);
                textSize(15);
                text(LCS.mat[i][j], x + 17, y + 25);
            }
        }
    }
}
