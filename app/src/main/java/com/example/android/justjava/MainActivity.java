package com.example.android.justjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int priceOfCoffee = 5, quantity = 0, order = 0, price,maxQuantity=20;

    /**
     * This method is called when the order button is clicked.
     */


    public void submitOrder(View view) {
        price = calculatePrice();
        display(quantity);
        displayPrice(price);
        order += 1;
        if(quantity > 0 && quantity <= maxQuantity ){
            Snackbar.make(findViewById(R.id.order_summary_text_view),
                    "Hurre! You have ordered "+quantity+" Coffee which costs $"+price,Snackbar.LENGTH_SHORT).show();
        }

        displayOrder(createOrderSummary(calculatePrice()));
    }

    /*
     * Display the total price of the coffee*/
    private int calculatePrice() {
        return quantity * priceOfCoffee;
    }


    /*
     * Create order Summury methode to display order details
     * @param price add to current price
     * @return return the current order summary String*/

    private String createOrderSummary(int price) {
        String summary = "Name: Purnachandra Pratap Nishad ";
        summary += "\nQuantity: " + quantity;
        summary += "\nTotal: $" + price;
        summary += "\nThank You!";
        return summary;
    }

    /*
     * Increment button method*/
    public void increment(View view) {
        quantity += 1;
        if (quantity > maxQuantity) {
            Snackbar.make(findViewById(R.id.order_summary_text_view), "You can order only maximum "+maxQuantity+" cups!",
                    Snackbar.LENGTH_SHORT).show();
            quantity = maxQuantity;
        }
        display(quantity);
    }
    /*Decrement button method*/

    public void decrement(View view) {
        quantity -= 1;
        if (quantity < 1) {
            Snackbar.make(findViewById(R.id.order_summary_text_view),
                    "Number of coffe can not less than 1",Snackbar.LENGTH_SHORT).show();
            quantity = 1;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(number);
    }

    /**
     * This method displays the given price on the screen.
     */

    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText("Total Price: $" + number );
        priceTextView.setTextSize(55);
    }

    /*This Method display the order summary on the screen*/
    private void displayOrder(String number) {
        TextView orderSummary = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummary.setText(number);
    }

}
