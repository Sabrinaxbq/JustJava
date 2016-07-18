package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;
    int perPrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedcream_checkbox = (CheckBox) findViewById(R.id.whippedcream_checkbox);
        boolean addWhippedcream = whippedcream_checkbox.isChecked();
        CheckBox chocolate_checkbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean addChocolate = chocolate_checkbox.isChecked();
        EditText txtname = (EditText) findViewById(R.id.name_view);
        String name = txtname.getText().toString();
        String priceMessage = createOrderSummary(perPrice, addWhippedcream, addChocolate, name);


        Uri webpage = Uri.parse("http://www.google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
        displayMessage(priceMessage);
    }



    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }


    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }


    private String createOrderSummary(int perPrice, boolean addWhippedcream, boolean addChocolate, String name) {
        String lalala = "Name : " + name;
        lalala += "\nAdd Whipped cream? " + addWhippedcream;
        lalala += "\nAdd Chocolate? " + addChocolate;
        lalala += "\nQuantity : " + quantity;
        lalala += "\nTotal : $" + quantity * perPrice;
        lalala += "\nThank you!";
        return lalala;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

}