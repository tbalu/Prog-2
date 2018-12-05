package com.zappycode.coinman.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Random;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObjectArray {
    protected ArrayList<GameObject> GameObjectArrayList;
    protected int gameObjectCount;
    protected Random RandomGenerator;
    ArrayList<Rectangle> GameObjectRectangleArrayList;
    public GameObjectArray(){
        this.gameObjectCount = 0;
        this.GameObjectArrayList = new ArrayList<GameObject>(50);
        this.GameObjectRectangleArrayList = new ArrayList<Rectangle>(50);
        this.RandomGenerator = new Random();
    }
    public abstract void makeObject();

    public abstract void createGameObjectRectangles();

    public ArrayList<GameObject> getGameObjectArrayList() {
        return GameObjectArrayList;
    }

    public void setGameObjectArrayList(ArrayList<GameObject> gameObjectArrayList) {
        GameObjectArrayList = gameObjectArrayList;
    }

    public int getGameObjectCount() {
        return gameObjectCount;
    }

    public void setGameObjectCount(int gameObjectCount) {
        this.gameObjectCount = gameObjectCount;
    }

    public Random getRandomGenerator() {
        return RandomGenerator;
    }

    public void setRandomGenerator(Random randomGenerator) {
        RandomGenerator = randomGenerator;
    }

    public ArrayList<Rectangle> getGameObjectRectangleArrayList() {
        return GameObjectRectangleArrayList;
    }

    public void setGameObjectRectangleArrayList(ArrayList<Rectangle> gameObjectRectangleArrayList) {
        GameObjectRectangleArrayList = gameObjectRectangleArrayList;
    }

}
