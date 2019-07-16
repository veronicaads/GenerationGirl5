package generationgirl.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int value_sum,value_mul;
    EditText value1,value2;
    RadioGroup oddeven;
    String value_of_sum,value_of_mul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        oddeven = findViewById(R.id.evenodd);


                Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox sum =  findViewById(R.id.checkbox_cheese);

                CheckBox mul =  findViewById(R.id.checkbox_multiply);
                value_sum = value_mul = 0;
                if (sum.isChecked()) {
                    int number1 = Integer.parseInt(value1.getText().toString());
                    int number2 = Integer.parseInt(value2.getText().toString());
                    value_sum = number1 + number2;

                }
                if (mul.isChecked()) {
                    int number1 = Integer.parseInt(value1.getText().toString());
                    int number2 = Integer.parseInt(value2.getText().toString());
                    value_mul = number1 * number2;
                }
                if (oddeven.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getApplicationContext(), "Please select the option", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int selectedId = oddeven.getCheckedRadioButtonId();
                    // find the radiobutton by returned id
                    final RadioButton selectedRadioButton = findViewById(selectedId);
                    Toast.makeText(MainActivity.this,
                            selectedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                    if (selectedRadioButton.getText().equals("Odd")){
                        if (value_sum == 0){
                            value_of_sum = "Skipped";
                        }
                        else if(value_sum > 0 && value_sum % 2 == 1){
                            value_of_sum = "True";
                        }
                        else {
                            value_of_sum = "False";
                        }
                        if (value_mul == 0){
                            value_of_mul = "Skipped";
                        }
                        else if(value_mul > 0 && value_mul % 2 == 1){
                            value_of_mul = "True";
                        }
                        else{
                            value_of_mul = "False";
                        }

                    }
                    if (selectedRadioButton.getText().equals("False")){
                        if (value_sum == 0){
                            value_of_sum = "Skipped";
                        }

                        else if(value_sum > 0 && value_sum % 2 == 0){
                            value_of_sum = "True";
                        }
                        else {
                            value_of_sum = "False";
                        }
                        if (value_mul == 0){
                            value_of_mul = "Skipped";
                        }
                        else if(value_mul > 0 && value_mul % 2 == 0){
                            value_of_mul = "True";
                        }
                        else{
                            value_of_mul = "False";
                        }

                    }

                }
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("SUM", value_of_sum);
                i.putExtra("MUL", value_of_mul);
                startActivity(i);
            }
        });
    }


}
