/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.maps;

import game.player.Player;
import javafx.scene.image.Image;

/**
 *
 * @author Shahrukh
 */
public class Town extends Map {
    // you need two things:
    
    // first a background img
    private static final Image BACKGROUND_IMG =
            new Image(Town.class.getResourceAsStream("../images/backgroundSample.png"));
    
    // second, a floor
    private static final Image FLOOR_IMG = 
            new Image(Town.class.getResourceAsStream("../images/floor2.png"));
    
    
    
    public Town(Player player, int screenWidth, int screenHeight) {
        super(BACKGROUND_IMG, FLOOR_IMG, player, screenWidth, screenHeight);
        
        
    }
    
}
