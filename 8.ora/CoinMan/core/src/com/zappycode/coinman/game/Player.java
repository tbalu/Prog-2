package com.zappycode.coinman.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


public class Player {
    private int manState;
    private float velocity;
    private int manY;
    private Rectangle manRectangle;
    private Texture[] ManTexture;
    private Texture Dizzy;
    public Player( Texture[] ManTexture, Texture Dizzy){
        this.manY = manY;
        this.ManTexture = ManTexture;
        this.Dizzy = Dizzy;
        this. manState = 0;
        this.velocity = 0;
        this.manY = Gdx.graphics.getHeight();
    }
    public int getManState() {
        return manState;
    }

    public void setManState(int manState) {
        this.manState = manState;
    }

    public int getManY() {
        return manY;
    }

    public void setManY(int manY) {
        this.manY = manY;
    }

    public float getVelocity() {

        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public Texture getDizzy() {
        return Dizzy;
    }

    public void setDizzy(Texture dizzy) {
        Dizzy = dizzy;
    }

    public Texture[] getManTexture() {

        return ManTexture;
    }

    public void setManTexture(Texture[] manTexture) {
        ManTexture = manTexture;
    }

    public Rectangle getManRectangle() {
        return manRectangle;
    }

    public void setManRectangle(Rectangle manRectangle) {
        this.manRectangle = manRectangle;
    }
}
