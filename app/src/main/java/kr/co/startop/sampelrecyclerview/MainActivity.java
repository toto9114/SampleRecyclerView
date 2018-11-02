package kr.co.startop.sampelrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter mAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        mAdapter = new MyAdapter();
        layoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter.setOnClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(Person person, int position) {
                Toast.makeText(MainActivity.this, person.name, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, OtherActivity.class);
                i.putExtra("name", person.name);
                startActivity(i);
            }
        });
        init();
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.age = 20 + i;
            person.name = "leejihun" + i;
            mAdapter.add(person);
        }
    }
}
