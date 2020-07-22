package com.example.example44;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    private TextView message;
    private TextView mAddressText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        Intent intent = getIntent();
        String orderMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        Log.d("Fang", orderMessage);
        mAddressText = (TextView) findViewById(R.id.address_text);
        message = (TextView) findViewById(R.id.message_textview);

            message.setText(orderMessage);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.sameday :
                if (checked)
                    // Same day service
                    displayToast(mAddressText.getText().toString());
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }
}
