package com.zappycode.coinman.game;

import com.badlogic.gdx.graphics.Texture;

import java.awt.Rectangle;

public class Coin extends GameObject {

    private static Texture CoinTexture = new Texture("coin.png");
    public Coin(int x, int y){
        super(x,y);
    }

    public static Texture getCoinTexture() {
        return CoinTexture;
    }

    public static void setCoinTexture(Texture gameObjectTexture) {
        CoinTexture = gameObjectTexture;
    }

}
