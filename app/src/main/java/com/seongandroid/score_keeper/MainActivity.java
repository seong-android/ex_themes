package com.seongandroid.score_keeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    private int mScore1;
    private int mScore2;

    private TextView mTextViewScore1;
    private TextView mTextViewScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewScore1 = (TextView) findViewById(R.id.score_1);
        mTextViewScore2 = (TextView) findViewById(R.id.score_2);

        if(savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            mTextViewScore1.setText(String.valueOf(mScore1));
            mTextViewScore2.setText(String.valueOf(mScore2));
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
// Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }

    public void increaseScore(View view) {
        int viewID = view.getId();

        switch(viewID) {
            case R.id.increaseTeam1:
                mScore1++;
                mTextViewScore1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mTextViewScore2.setText(String.valueOf(mScore2));
                break;
            default:
                break;
        }
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();

        switch(viewID) {
            case R.id.decreaseTeam1:
                if(mScore1 > 0) {
                    mScore1--;
                }
                mTextViewScore1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                if(mScore2 > 0) {
                    mScore2--;
                }
                mTextViewScore2.setText(String.valueOf(mScore2));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // save the score
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);

        super.onSaveInstanceState(outState);
    }
}
