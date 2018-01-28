package bachelors.fmi.uni.game2032;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView triesTextView;
    TextView upDownTextView;
    EditText numberEditText;
    Button  guessButton;
    Button  resetButton;

    Random rand=new Random();
    int tries=0;
    int randomNumber=rand.nextInt(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        triesTextView= (TextView) findViewById(R.id.triesTextView);
        upDownTextView= (TextView) findViewById(R.id.upDownTextView);
        numberEditText= (EditText) findViewById(R.id.numberEditText);
        guessButton= (Button) findViewById(R.id.guessButton);
        resetButton= (Button) findViewById(R.id.resetButton);

        resetButton.setEnabled(false);

        guessButton.setOnClickListener(onBtnClick);
        resetButton.setOnClickListener(onBtnClick);
    }

    View.OnClickListener onBtnClick=new View.OnClickListener(){
        @Override
        public void onClick(View view) {

            String upDown="";

            switch(view.getId()) {
                case R.id.guessButton:
                    tries++;

                    int clientNumber=Integer.valueOf( numberEditText.getText().toString());

                    if (clientNumber==randomNumber){
                        upDown="You win";
                        guessButton.setEnabled(false);
                        resetButton.setEnabled(true);
                    }else if (clientNumber>randomNumber) {
                        upDown = "Down";
                    }else{
                        upDown = "Up";
                    }
                    break;
                case R.id.resetButton:
                    randomNumber=rand.nextInt(11);
                    tries=0;

                    guessButton.setEnabled(true);
                    resetButton.setEnabled(false);

                    break;
            }

                numberEditText.setText("");
                upDownTextView.setText(upDown);
                triesTextView.setText(String.format("%d",tries));




        }
    };


}
