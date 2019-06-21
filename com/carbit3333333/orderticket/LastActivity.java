package com.carbit3333333.orderticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.carbit3333333.orderticket.MainActivity;
import com.carbit3333333.orderticket.R;
import com.carbit3333333.orderticket.model.Order;

import static com.carbit3333333.orderticket.MainActivity.KEY_1;

public class LastActivity extends AppCompatActivity {
    private TextView tvFullName;
    private TextView tvWhere;
    private TextView tvWhen;
    private TextView tvStatus;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        tvFullName = findViewById(R.id.tvFullName);
        tvWhen = findViewById(R.id.tvWhen);
        tvWhere = findViewById(R.id.tvWhere);
        tvStatus = findViewById(R.id.tvStatus);
        Intent intent = getIntent();
        order = (Order) intent.getSerializableExtra(MainActivity.KEY_2);

        tvFullName.setText(order.getSecondNAme() + " " + order.getName() + " " + order.getLastNAme());
        tvWhere.setText(order.getFromTo());
        tvWhen.setText(order.getDate());
        tvStatus.setText(order.getStatus());
    }
}
