package com.example.owner.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddGroceryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_NOTES = "notes";
    public static final String EXTRA_QUANTITY = "quantity";
    public static final String TAG = "ADD_GROCERY_ACTIVITY";

    private EditText myEditNameView;
    private EditText myEditNotesView;
    //TODO: This needs to get changed to the view we are using for editing the number
    //  this might entail changing things in other parts of the codebase where we refernce it...
    //  Matt you will need to handle this
    private EditText myEditQuantityView;
    private Button saveButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_grocery_activity);

        myEditNameView = findViewById(R.id.edit_grocery_name);
        myEditNotesView = findViewById(R.id.edit_grocery_notes);
        myEditQuantityView = findViewById(R.id.edit_grocery_quantity);

        saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(myEditNameView.getText()) ||
                        TextUtils.isEmpty(myEditNotesView.getText()) ||
                        TextUtils.isEmpty(myEditQuantityView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String name = myEditNameView.getText().toString();
                    String notes = myEditNotesView.getText().toString();
                    String quantity = myEditQuantityView.getText().toString();

                    replyIntent.putExtra(EXTRA_NOTES, notes);
                    replyIntent.putExtra(EXTRA_NAME, name);
                    replyIntent.putExtra(EXTRA_QUANTITY, quantity);

                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
