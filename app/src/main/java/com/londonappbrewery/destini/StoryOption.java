package com.londonappbrewery.destini;

/**
 * Created by m50571 on 10/5/17.
 */

public class StoryOption {

    private int _storyText;
    private int _topButtonText;
    private int _bottomButtonText;

    private int _buttonStringText;

    public StoryOption(int referringButtonText, int storyText, int topButton, int bottomButton) {
        this._buttonStringText = referringButtonText;
        this._storyText = storyText;
        this._topButtonText = topButton;
        this._bottomButtonText = bottomButton;
    }

    public int get_storyText() {
        return _storyText;
    }

    public void set_storyText(int _storyText) {
        this._storyText = _storyText;
    }

    public int get_topButtonText() {
        return _topButtonText;
    }

    public void set_topButtonText(int _topButtonText) {
        this._topButtonText = _topButtonText;
    }

    public int get_bottomButtonText() {
        return _bottomButtonText;
    }

    public void set_bottomButtonText(int _bottomButtonText) {
        this._bottomButtonText = _bottomButtonText;
    }

    public int getReferringButtonText() {
        return this._buttonStringText;
    }

}
