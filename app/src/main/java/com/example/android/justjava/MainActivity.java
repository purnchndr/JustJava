/*
package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}*/
package com.example.android.justjava;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity<var> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int  priceOfCoffee = 5,quantity = 0;

    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity * priceOfCoffee);
    }
    public void increment(View view){
        quantity += 1;

        display(quantity);
        displayPrice(quantity * priceOfCoffee);
    }

    public void decrement(View view){
        quantity -= 1;
        if (quantity < 0){
            quantity = 0;
        }
        display(quantity);
        displayPrice(quantity * priceOfCoffee);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
