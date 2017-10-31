package com.example.android.miwok;

/**
 * Created by Samrudh Shetty on 21-05-2017.
 */

public class Word {
    private String defaultTranslation;
    private String miowkWord;
    private int imageResourceId = -1;
    private int soundResourceId = -1;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miowkWord, int soundResourceId){
        this.defaultTranslation = defaultTranslation;
        this.miowkWord = miowkWord;
        this.soundResourceId = soundResourceId;
    }


    //Constructor with image
    /**
     * @param soundResourceId is the resource id of the mp3 file
    *@param imageResourceId is the resource id of the image
     */
    public Word(String defaultTranslation, String miowkWord, int imageResourceId, int soundResourceId){
        this.defaultTranslation = defaultTranslation;
        this.miowkWord = miowkWord;
        this.imageResourceId = imageResourceId;
        this.soundResourceId = soundResourceId;
    }


    public String getDefaultTranslation(){
        return defaultTranslation;
    }

    public String getMiowkWord(){
        return miowkWord;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    /**Audio resource id for the word*/
    public int getSoundResourceId() {return soundResourceId;}

    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }


}
