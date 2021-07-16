package com.alok.quizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final Question[] allQuest = new Question[]{
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_declaration, false),
            new Question(R.string.question_government, true)
    };
    private int currentQuestIndex = 0;
    private int score = 0;

    //    @BindView(R.id.textView)
//    TextView text;
    @BindView(R.id.questionDisp)
    TextView qdisp;

    @BindView(R.id.true_button)
    Button trueButton;

    @BindView(R.id.false_button)
    Button falseButton;

    @BindView(R.id.scoreText)
    TextView scText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        qdisp.setText(allQuest[currentQuestIndex].getAnswerResId());
        scText.setText("Best of Luck!!");
    }


    public void click1(View view) {
        if (allQuest[currentQuestIndex].isAnswerTrue() == true) {
            score += 10;
            currentQuestIndex = (currentQuestIndex + 1) % 4;
            scText.setText("Correct Answer! Your Score is " + String.valueOf(score));
            qdisp.setText(allQuest[currentQuestIndex].getAnswerResId());
        } else {
            scText.setText("Wrong Answer Try Again!");
        }
    }

    public void click2(View view) {
        if (allQuest[currentQuestIndex].isAnswerTrue() == false) {
            score += 10;
            currentQuestIndex = (currentQuestIndex + 1) % 4;
            scText.setText("Correct Answer! Your Score is " + String.valueOf(score));
            qdisp.setText(allQuest[currentQuestIndex].getAnswerResId());
        } else {
            scText.setText("Wrong Answer Try Again!");
        }
    }
}