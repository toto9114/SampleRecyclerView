package kr.co.startop.sampelrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    TextView nameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        nameView = findViewById(R.id.text_name);

        Intent i = getIntent();
        if (i != null) {
            String name = i.getStringExtra("name");
            nameView.setText(name);
        }
    }
}
