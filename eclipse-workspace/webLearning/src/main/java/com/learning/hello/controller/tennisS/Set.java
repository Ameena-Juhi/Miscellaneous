package com.learning.hello.controller.tennisS;

import hello.controller.tennisS.Game;
import hello.controller.tennisS.Player;

public class Set {
    
    public static void playSets(Player p1 , Player p2)
    {

            Game.startGame(p1 , p2);
            if(p1.gamesWin == 6)
            {
                p1.incrementSetsWin();
            }
            else if(p2.gamesWin == 6)
            {
                p2.incrementSetsWin();
            }
     
        
    }

}
