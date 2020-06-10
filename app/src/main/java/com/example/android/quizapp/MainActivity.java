package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswers(View view) {
        boolean results[] = {false, false, false, false, false, false};

        // Question 1.
        results[0] = checkQuestion1();

        // Question 2.
        results[1] = checkQuestion2();

        // Question 3.
        results[2] = checkQuestion3();

        // Question 4.
        results[3] = checkQuestion4();

        // Question 5.
        results[4] = checkQuestion5();

        // Question 6.
        results[5] = checkQuestion6();

        // Display message.
        displayMessage(results);

    }

    /**
     * Check the first question.
     *
     * @return correct or incorrect.
     */
    private boolean checkQuestion1() {
        RadioButton radioButton43 = findViewById(R.id.radioButton43);
        boolean question1 = radioButton43.isChecked();

        if (question1) {
            counter++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check the second question.
     *
     * @return correct or incorrect.
     */
    private boolean checkQuestion2() {
        RadioButton radioButton47 = findViewById(R.id.radioButton43);
        boolean question2 = radioButton47.isChecked();

        if (question2) {
            counter++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check the third question.
     *
     * @return correct or incorrect.
     */
    private boolean checkQuestion3() {
        CheckBox checkBox3_1 = findViewById(R.id.option_3_1);
        CheckBox checkBox3_2 = findViewById(R.id.option_3_2);
        CheckBox checkBox3_3 = findViewById(R.id.option_3_3);
        CheckBox checkBox3_4 = findViewById(R.id.option_3_4);
        boolean question3_1 = checkBox3_1.isChecked();
        boolean question3_2 = checkBox3_2.isChecked();
        boolean question3_3 = checkBox3_3.isChecked();
        boolean question3_4 = checkBox3_4.isChecked();

        if (question3_1 && !question3_2 && !question3_3 && question3_4) {
            counter++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check the fourth question.
     *
     * @return correct or incorrect.
     */
    private boolean checkQuestion4() {
        CheckBox checkBox4_1 = findViewById(R.id.option_4_1);
        CheckBox checkBox4_2 = findViewById(R.id.option_4_2);
        CheckBox checkBox4_3 = findViewById(R.id.option_4_3);
        CheckBox checkBox4_4 = findViewById(R.id.option_4_4);
        boolean question4_1 = checkBox4_1.isChecked();
        boolean question4_2 = checkBox4_2.isChecked();
        boolean question4_3 = checkBox4_3.isChecked();
        boolean question4_4 = checkBox4_4.isChecked();

        if (question4_1 && question4_2 && question4_3 && !question4_4) {
            counter++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check the fifth question.
     *
     * @return correct or incorrect.
     */
    private boolean checkQuestion5() {
        EditText editText5 = findViewById(R.id.edit_text_5);
        String question5 = editText5.getText().toString();

        if (question5.equalsIgnoreCase("2007")) {
            counter++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check the sixth question.
     *
     * @return correct or incorrect.
     */
    private boolean checkQuestion6() {
        EditText editText6 = findViewById(R.id.edit_text_6);
        String question6 = editText6.getText().toString();

        if (question6.equalsIgnoreCase("LTE")) {
            counter++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Display results messages.
     *
     * @param results of the correct / incorrect answers.
     */
    private void displayMessage(boolean[] results) {
        TextView wrongAnswersTextView = findViewById(R.id.wrong_answers_text_view);

        // Display result message.
        String resultMsg = getString(R.string.result, counter);
        Toast.makeText(this, resultMsg, Toast.LENGTH_LONG).show();

        // Display wrong answers / congratulations message.
        String descriptionMsg = "";
        if (counter == 6) {
            descriptionMsg = getString(R.string.congratulations);
        } else {
            descriptionMsg = getString(R.string.wrong_answers);
            for (int i = 0; i < results.length; i++) {
                if (results[i] == false) {
                    descriptionMsg += (i+1) + " ";
                }
            }
        }
        wrongAnswersTextView.setText(descriptionMsg);

        // Reset the counter.
        counter = 0;
    }

}