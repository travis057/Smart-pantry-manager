package com.example.smartpantry;

import android.app.*;
import android.content.*;
import android.database.*;
import android.widget.*;

public class PantryActivity extends Activity {
    public void onCreate(android.os.Bundle b) {
        super.onCreate(b);
        show();
    }

    protected void onResume() {
        super.onResume();
        show();
    }

    void show() {
        LinearLayout l = UI.page(this, "My Pantry");
        UI.button(this, l, "+ Add Ingredient", () -> startActivity(new Intent(this, EditIngredientActivity.class)));
        UI.nav(this, l);
        DB db = new DB(this);
        Cursor c = db.getReadableDatabase().rawQuery("SELECT id,name,quantity,unit,expiry FROM pantry ORDER BY name", null);
        int n = 0;
        try {
            while (c.moveToNext()) {
                n++;
                int id = c.getInt(0);
                String label = c.getString(1) + " — " + c.getDouble(2) + " " + c.getString(3) + (c.isNull(4) || c.getString(4).isEmpty() ? "" : " (expires " + c.getString(4) + ")");
                UI.button(this, l, label + "  ✎", () -> {
                    Intent i = new Intent(this, EditIngredientActivity.class);
                    i.putExtra("id", id);
                    startActivity(i);
                });
            }
        } finally {
            c.close();
            db.close();
        }
        if (n == 0) UI.text(this, l, "Your pantry is empty. Add ingredients to begin.");
    }
}
