package com.example.teacherstudentapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CPP_Quiz extends AppCompatActivity {

    private CPP_Quiz_Library question_library = new CPP_Quiz_Library();
    private TextView mScoreView, mQuestionView,score;
    private Button nextQ,btnChoice1,btnChoice2,btnChoice3,btnChoice4;
    private Handler mHandler;

    private String mAnswer;
    int counter = 0;
    private int mScore = 0;
    private int questionNumber = 0;
    private int qN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp__quiz);

        mScoreView = findViewById(R.id.score_text);
        mQuestionView = findViewById(R.id.question);
        btnChoice1 = findViewById(R.id.choice1);
        btnChoice2 = findViewById(R.id.choice2);
        btnChoice3 = findViewById(R.id.choice3);
        btnChoice4 = findViewById(R.id.choice4);
        score = findViewById(R.id.score);
        nextQ = findViewById(R.id.nextQuestion);

        nextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
            }
        });

        btnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChoice1.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(CPP_Quiz.this,"Correct",Toast.LENGTH_SHORT).show();
                }else if(btnChoice1.getText() != mAnswer){
                    mScore -= 1;
                    updateScore(mScore);
                    Toast.makeText(CPP_Quiz.this,"Wrong! \nCorrect Answer Was : "+mAnswer,Toast.LENGTH_LONG).show();
                    updateQuestion();
                }
            }
        });

        btnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChoice2.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(CPP_Quiz.this,"Correct",Toast.LENGTH_SHORT).show();
                }else if(btnChoice2.getText() != mAnswer){
                    mScore -= 1;
                    updateScore(mScore);
                    Toast.makeText(CPP_Quiz.this,"Wrong! \nCorrect Answer Was : "+mAnswer,Toast.LENGTH_LONG).show();                    updateQuestion();
                }
            }
        });

        btnChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChoice3.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(CPP_Quiz.this,"Correct",Toast.LENGTH_SHORT).show();
                }else if(btnChoice3.getText() != mAnswer){
                    mScore -= 1;
                    updateScore(mScore);
                    Toast.makeText(CPP_Quiz.this,"Wrong! \nCorrect Answer Was : "+mAnswer,Toast.LENGTH_LONG).show();                    updateQuestion();
                }
            }
        });

        btnChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChoice4.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(CPP_Quiz.this,"Correct",Toast.LENGTH_SHORT).show();
                }else if(btnChoice4.getText() != mAnswer){
                    mScore -= 1;
                    updateScore(mScore);
                    Toast.makeText(CPP_Quiz.this,"Wrong! \nCorrect Answer Was : "+mAnswer,Toast.LENGTH_LONG).show();                    updateQuestion();
                }
            }
        });


    }

    private void updateQuestion(){
        if (qN < 11) {
            mQuestionView.setText("Q." + qN + ") " + CPP_Quiz_Library.getQuestion(questionNumber));
            btnChoice1.setText(CPP_Quiz_Library.getChoice1(questionNumber));
            btnChoice2.setText(CPP_Quiz_Library.getChoice2(questionNumber));
            btnChoice3.setText(CPP_Quiz_Library.getChoice3(questionNumber));
            btnChoice4.setText(CPP_Quiz_Library.getChoice4(questionNumber));

            mAnswer = question_library.getCorrectAnswer(questionNumber);
            qN += 1;
            questionNumber += 1;
            counter++;
        }else {
            Intent i =new Intent(this,StudentPage.class);
            startActivity(i);
        }
    }

    private void updateScore(int point){
        score.setText(""+mScore);
    }
}
