package com.zappycode.coinman.game;


import com.badlogic.gdx.graphics.Texture;

public class Bomb extends GameObject {
    private static Texture BombTexture = new Texture("bomb.png");
    Bomb(int x, int y){
        super(x,y);
    }

    public static Texture getBombTexture() {
        return BombTexture;
    }

    public static void setBombTexture(Texture bombTexture) {
        BombTexture = bombTexture;
    }
}
