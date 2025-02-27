package com.firewizapp.program;

import com.firewizapp.music.*;
import java.lang.Thread;

public class MusicPlayer {

    public void playSong()
    {
        try //Hot Cross Buns
        {
            playLine1();
            Thread.sleep(100);
            playLine1();
            Thread.sleep(150);
            playLine2();
            Thread.sleep(50);
            playLine1();
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private void playLine1()
    {
        Music.playNote("E");
        Music.playNote("D");
        Music.playNote("C");
    }

    private void playLine2()
    {
        Music.playNote("C");
        Music.playNote("C");
        Music.playNote("C");
        Music.playNote("C");
        Music.playNote("D");
        Music.playNote("D");
        Music.playNote("D");
        Music.playNote("D");
    } 

    public static void main(String[] args) {

        MusicPlayer player = new MusicPlayer();
        player.playSong();

    }
}
