package com.carbit3333333.orderticket;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.carbit3333333.orderticket.model.Order;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Calendar dateAndTime = Calendar.getInstance();
    public static final String KEY_1 = "com.carbit3333333.SECOND_ACTIVITY";
    public static final String KEY_2 = "com.carbit3333333.LAST_ACTIVITY";
    public static final String SAVE_OUT_STATE = "com.carbit3333333.SAVE_OUT_STATE";
    private EditText etFirstName;
    private EditText etSecondName;
    private EditText etLastName;
    private TextView tvODate;
    private String from;
    private String to;

    private Button btnOrder;
    private Button btnDate;
    private Button btnTime;

    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private String[] aarayFrom = {"Винница", "Днепр", "Донецк", "Житомир", "Запорожье",
            "Ивано-Франковск", "Киев", "Кропивницкий", "Луганск", "Луцк", "Львов",
            "Николаев", "Одесса", "Полтава", "Ровно", "Сумы", "Тернополь", "Ужгород",
            "Харьков", "Херсон", "Хмельницкий", "Черкассы", "Чернигов", "Черновцы"};

    private String[] aarayTo = {"Винница", "Днепр", "Донецк", "Житомир", "Запорожье",
            "Ивано-Франковск", "Киев", "Кропивницкий", "Луганск", "Луцк", "Львов",
            "Николаев", "Одесса", "Полтава", "Ровно", "Сумы", "Тернополь", "Ужгород",
            "Харьков", "Херсон", "Хмельницкий", "Черкассы", "Чернигов", "Черновцы"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapterFrom = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, aarayFrom);
        ArrayAdapter<String> adapterTo = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, aarayTo);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerFrom.setAdapter(adapterFrom);
        spinnerFrom.setPrompt("Выберите откуда");
        spinnerTo = findViewById(R.id.spinnerTo);
        spinnerTo.setAdapter(adapterTo);
        spinnerTo.setPrompt("Выберите куда");

        btnOrder = findViewById(R.id.btnOrder);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        btnTime.setOnClickListener(this);
        btnOrder.setOnClickListener(this);
        btnDate.setOnClickListener(this);


        tvODate = findViewById(R.id.tvDate);
        etFirstName = findViewById(R.id.etFirstName);
        etSecondName = findViewById(R.id.etSecondName);
        etLastName = findViewById(R.id.etLastName);

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = adapterFrom.getItem(position) + " ";

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = adapterTo.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String name = etFirstName.getText().toString();
        String secondNAme = etSecondName.getText().toString();
        String lastNAme = etLastName.getText().toString();
        String dateTime = tvODate.getText().toString();
        Order order = new Order(name, secondNAme, lastNAme, dateTime, from + to);
        outState.putSerializable(SAVE_OUT_STATE, order);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Order order = (Order) savedInstanceState.getSerializable(SAVE_OUT_STATE);
        etFirstName.setText(order.getName());
        etSecondName.setText(order.getSecondNAme());
        etLastName.setText(order.getLastNAme());
        tvODate.setText(order.getDate());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOrder:
                if (TextUtils.isEmpty(etFirstName.getText().toString()) ||
                        TextUtils.isEmpty(etLastName.getText().toString()) ||
                        TextUtils.isEmpty(etSecondName.getText().toString()) ||
                        TextUtils.isEmpty(tvODate.getText().toString())) {
                    return;
                }
                Intent intent = new Intent("com.carbit3333333.intent.secondActiviry");
                String name = etFirstName.getText().toString();
                String secondNAme = etSecondName.getText().toString();
                String lastNAme = etLastName.getText().toString();
                String dateTime = tvODate.getText().toString();
                Order order = new Order(name, secondNAme, lastNAme, dateTime, from + to);
                intent.putExtra(KEY_1, order);
                startActivity(intent);
                break;
            case R.id.btnDate:
                setDate();
                break;
            case R.id.btnTime:
                setTime();
                break;


        }
    }

    private void setDate() {
        new DatePickerDialog(this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();

    }

    private void setTime() {
        new TimePickerDialog(this, timeMill,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true).show();
    }

    DatePickerDialog.OnDateSetListener d = (view, year, month, dayOfMonth) -> {
        dateAndTime.set(Calendar.YEAR, year);
        dateAndTime.set(Calendar.MONTH, month);
        dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        initTime();
    };
    TimePickerDialog.OnTimeSetListener timeMill = (view, hourOfDay, minute) -> {
        dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        dateAndTime.set(Calendar.MINUTE, minute);
        initTime();
    };

    void initTime() {
        tvODate.setText(DateUtils.formatDateTime(this, dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_SHOW_TIME));
    }

}
