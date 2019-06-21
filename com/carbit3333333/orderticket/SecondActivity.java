package com.carbit3333333.orderticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.carbit3333333.orderticket.model.Order;

import static com.carbit3333333.orderticket.MainActivity.KEY_1;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Button finalOrder;

    private TextView tvFullName;
    private TextView tvWhere;
    private TextView tvWhen;

    private CheckBox checkPopCorn;
    private CheckBox checkSok;
    private String sok = "";
    private String popkorn = "";
    private Order order;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvFullName = findViewById(R.id.tvFullName);
        tvWhen = findViewById(R.id.tvWhen);
        tvWhere = findViewById(R.id.tvWhere);
        Intent intent = getIntent();
        order = (Order) intent.getSerializableExtra(KEY_1);
        tvFullName.setText(order.getSecondNAme() + " " + order.getName() + " " + order.getLastNAme());
        tvWhere.setText(order.getFromTo());
        tvWhen.setText(order.getDate());
        finalOrder = findViewById(R.id.finalOrder);
        finalOrder.setOnClickListener(this);

        checkSok = findViewById(R.id.checkSok);
        checkPopCorn = findViewById(R.id.checkPopCorn);
        checkSok.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                sok = "Сок, ";
                //Toast.makeText(getApplicationContext(), "Включено", Toast.LENGTH_SHORT).show();
            } else {
                //Toast.makeText(getApplicationContext(), "Выключено", Toast.LENGTH_SHORT).show();
            }
        });
        checkPopCorn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                popkorn = "попкорн, ";
            }

        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finalOrder:{
                order.setStatus(sok + popkorn);
                Intent intent = new Intent("com.carbit3333333.intent.lastActiviry");
                intent.putExtra(MainActivity.KEY_2, order);
                startActivity(intent);
                break;
            }
        }
    }
}
