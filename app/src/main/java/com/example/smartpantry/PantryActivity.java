package com.example.smartpantry;

import android.app.*;
import android.content.*;
import android.database.*;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.*;
import android.widget.*;

public class PantryActivity extends Activity {

 public void onCreate(android.os.Bundle b) {
  super.onCreate(b);
  show();
 }

 @Override
 protected void onResume() {
  super.onResume();
  show();
 }

 void show() {
  LinearLayout l = UI.page(this, "My Pantry");

  TextView intro = UI.text(
          this, l, "Keep track of what is in your kitchen."
  );
  intro.setTextColor(Color.rgb(100, 110, 100));
  intro.setTextSize(15);

  UI.button(this, l, "+ Add Ingredient", () ->
          startActivity(new Intent(this, EditIngredientActivity.class))
  );

  DB db = new DB(this);
  Cursor c = db.getReadableDatabase().rawQuery(
          "SELECT id,name,quantity,unit,expiry FROM pantry ORDER BY name",
          null
  );

  int n = 0;

  try {
   while (c.moveToNext()) {
    n++;

    int id = c.getInt(0);
    String name = c.getString(1);
    double quantity = c.getDouble(2);
    String unit = c.getString(3);
    String expiry = c.isNull(4) ? "" : c.getString(4);

    LinearLayout card = new LinearLayout(this);
    card.setOrientation(LinearLayout.VERTICAL);
    card.setPadding(16, 14, 16, 12);
    card.setBackground(UI.shape(Color.WHITE, 18));
    card.setElevation(3);

    LinearLayout.LayoutParams cardParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    cardParams.setMargins(0, 5, 0, 12);
    card.setLayoutParams(cardParams);
    l.addView(card);

    TextView ingredientName = new TextView(this);
    ingredientName.setText(name);
    ingredientName.setTextSize(19);
    ingredientName.setTypeface(
            Typeface.DEFAULT, Typeface.BOLD
    );
    ingredientName.setTextColor(
            Color.rgb(39, 73, 49)
    );
    card.addView(ingredientName);

    TextView details = new TextView(this);
    details.setText(
            "Quantity: " + formatQuantity(quantity)
                    + " " + unit
    );
    details.setTextSize(15);
    details.setTextColor(Color.rgb(85, 95, 85));
    details.setPadding(0, 6, 0, 2);
    card.addView(details);

    if (!expiry.trim().isEmpty()) {
     TextView expiryText = new TextView(this);
     expiryText.setText("Expires: " + expiry);
     expiryText.setTextSize(14);
     expiryText.setTextColor(
             Color.rgb(125, 105, 65)
     );
     expiryText.setPadding(0, 3, 0, 4);
     card.addView(expiryText);
    }

    UI.button(this, card, "Edit Ingredient  ✎", () -> {
     Intent i = new Intent(
             this, EditIngredientActivity.class
     );
     i.putExtra("id", id);
     startActivity(i);
    });
   }
  } finally {
   c.close();
   db.close();
  }

  if (n == 0) {
   TextView empty = UI.text(
           this, l,
           "Your pantry is empty.\nAdd your first ingredient to get started!"
   );
   empty.setTextSize(16);
   empty.setTextColor(Color.rgb(100, 110, 100));
  } else {
   TextView count = UI.text(
           this, l,
           n + (n == 1 ? " ingredient in your pantry"
                   : " ingredients in your pantry")
   );
   count.setTextSize(14);
   count.setTextColor(Color.rgb(100, 110, 100));
  }

  UI.nav(this, l);
 }

 String formatQuantity(double quantity) {
  if (quantity == Math.floor(quantity)) {
   return String.valueOf((long) quantity);
  }

  return String.valueOf(quantity);
 }
}
