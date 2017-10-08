package com.londonappbrewery.destini;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "Destini:";

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button _topButton;
    private Button _bottowmButton;
    private TextView _storyTextView;
    private int _currentUserLevel;
    private StoryOption[] _storyOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        _topButton = (Button) findViewById(R.id.buttonTop);
        _bottowmButton = (Button) findViewById(R.id.buttonBottom);
        _storyTextView = (TextView) findViewById(R.id.storyTextView);


        _storyOptions = new StoryOption[]{
                //referring button, story text, top button, bottom button
                new StoryOption(R.string.T1_Ans1, R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
                new StoryOption(R.string.T3_Ans1, R.string.T6_End, 0, 0),
                new StoryOption(R.string.T3_Ans2, R.string.T5_End, 0, 0),
                new StoryOption(R.string.T1_Ans2, R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
                new StoryOption(R.string.T2_Ans1, R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
                new StoryOption(R.string.T2_Ans2, R.string.T4_End, 0, 0),
        };

        _topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "top button clicked, view = "+ v);
                Button clickedButton = (Button) v;
                String buttonText = (String) clickedButton.getText();
                Log.d(TAG, "text = "+buttonText);
                advance(clickedButton);
            }
        });


        _bottowmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "bottom button clicked, view = "+v);
                Button clickedButton = (Button) v;
                String buttonText = (String) clickedButton.getText();
                Log.d(TAG, "text = "+buttonText);
                advance(clickedButton);
            }
        });

    }

    private void advance(Button incomingButton) {
        //get the text id of the button
        Log.d(TAG, "the incoming button is " +incomingButton);
        //Log.d(TAG, "buttonText = " +buttonText);
        //Log.d(TAG, "advancing");

        for (StoryOption thisOption: _storyOptions) {
            int resText = thisOption.getReferringButtonText();
            String compareText = getString(resText);

            String buttontext = (String)incomingButton.getText();

            Log.d(TAG, "buttton text: " +buttontext);
            Log.d(TAG, "this option text: " +compareText);

            //String string = incomingButton.getText().toString();
            if (compareText == buttontext) {

                if (thisOption.get_storyText() != 0) {
                    setText(thisOption.get_storyText());
                }

                if (thisOption.get_topButtonText() != 0) {
                    setTopButton(thisOption.get_topButtonText());
                }
                else {
                    hideButton("top");
                }

                if (thisOption.get_bottomButtonText() != 0) {
                    setBottomButton(thisOption.get_bottomButtonText());
                }
                else {
                    hideButton("bottom");
                }

                break;
            }

        }

        Log.d(TAG, "halt");

        //use it to set the text
    }

    private void hideButton(String whichButton) {
        if (whichButton == "top") {
            _topButton.setVisibility(View.GONE);
        }
        else {
            _bottowmButton.setVisibility(View.GONE);
        }
    }

    private void setText(int textToBeSet) {
        _storyTextView.setText(textToBeSet);

    }

    private void setTopButton(int buttonText) {
        _topButton.setText(buttonText);
    }

    private void setBottomButton(int buttonText) {
        _bottowmButton.setText(buttonText);
    }

}
