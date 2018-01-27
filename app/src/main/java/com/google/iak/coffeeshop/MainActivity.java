package com.google.iak.coffeeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText kolom_nama;
    CheckBox whipped_cream,chocolate;
    Button decrement_button,increment_button,order_button;
    TextView total_harga,detail_order,quantity_label;

    int price=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();

        final CoffeeClass cappucino=new CoffeeClass();
        cappucino.setQuantity(0);
        quantity_label.setText(""+cappucino.getQuantity());

        whipped_cream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cappucino.topping(whipped_cream.isChecked(),chocolate.isChecked(),1,2);
            }
        });

        decrement_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cappucino.setQuantity(cappucino.decrement(MainActivity.this));
                cappucino.setPrice(price);
                quantity_label.setText(""+cappucino.getQuantity());
                total_harga.setText("$ "+cappucino.getPrice());
            }
        });

        increment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cappucino.setQuantity(cappucino.increment());
                cappucino.setPrice(price);
                quantity_label.setText(String.valueOf(cappucino.getQuantity()));
                total_harga.setText("$ "+cappucino.getPrice());
            }
        });
        cappucino.setNama(kolom_nama.getText().toString());


    }


    private void setupView(){
        kolom_nama=findViewById(R.id.nama_pemesan);
        whipped_cream=findViewById(R.id.add_whipped_cream);
        chocolate=findViewById(R.id.add_chocholate);
        decrement_button =findViewById(R.id.decrement);
        increment_button=findViewById(R.id.increment);
        quantity_label=findViewById(R.id.quantity_text);
        total_harga=findViewById(R.id.total_price);
        detail_order=findViewById(R.id.order_detail);
        order_button=findViewById(R.id.order);

    }

}
