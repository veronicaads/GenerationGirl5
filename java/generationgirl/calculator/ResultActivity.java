package generationgirl.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ResultActivity extends AppCompatActivity {

    TextView mul,sum;
    String mul_result,sum_result;
    Switch on_off_switch;
    ImageView imageView;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mul = findViewById(R.id.multiplyresult);
        sum = findViewById(R.id.addresult);

        Intent a = getIntent();
        mul_result = a.getStringExtra("MUL");
        sum_result = a.getStringExtra("SUM");
        Toast.makeText(this, mul_result,
                Toast.LENGTH_SHORT).show();
        mul.setText(mul_result);
        sum.setText(sum_result);

        imageView = findViewById(R.id.imageView);
        toggleButton = findViewById(R.id.back);
        imageView.setVisibility(View.GONE);
        on_off_switch =  findViewById(R.id.switch1);
        on_off_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    imageView.setVisibility(View.VISIBLE);
                }
                else {
                    imageView.setVisibility(View.INVISIBLE);
                }

            }

        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}
