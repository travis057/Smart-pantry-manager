package com.example.smartpantry;

import android.app.*;
import android.content.*;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.*;
import android.widget.*;

public class UI {

    static final int GREEN = Color.rgb(67, 105, 78);
    static final int DARK_GREEN = Color.rgb(39, 73, 49);
    static final int CREAM = Color.rgb(249, 248, 241);
    static final int WHITE = Color.WHITE;
    static final int TEXT = Color.rgb(49, 57, 49);
    static final int MUTED = Color.rgb(117, 124, 115);

    static GradientDrawable shape(int color, int radius) {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(color);
        bg.setCornerRadius(radius);
        return bg;
    }

    static LinearLayout page(Activity a, String title) {
        LinearLayout l = new LinearLayout(a);
        l.setOrientation(LinearLayout.VERTICAL);
        l.setPadding(22, 24, 22, 20);
        l.setBackgroundColor(CREAM);

        ScrollView s = new ScrollView(a);
        s.setFillViewport(true);
        s.setClipToPadding(false);
        s.setPadding(0, 0, 0, 8);
        s.addView(l);

        a.setContentView(s);

        TextView h = new TextView(a);
        h.setText(title);
        h.setTextSize(28);
        h.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        h.setTextColor(DARK_GREEN);
        h.setPadding(0, 4, 0, 6);
        l.addView(h);

        TextView subtitle = new TextView(a);
        subtitle.setText("Your kitchen, organised.");
        subtitle.setTextSize(14);
        subtitle.setTextColor(MUTED);
        subtitle.setPadding(0, 0, 0, 22);
        l.addView(subtitle);

        return l;
    }

    static Button button(Activity a, LinearLayout l,
                         String text, Runnable r) {
        Button b = new Button(a);
        b.setText(text);
        b.setTextSize(15);
        b.setAllCaps(false);
        b.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        b.setTextColor(WHITE);
        b.setPadding(12, 10, 12, 10);
        b.setBackground(shape(GREEN, 18));

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        p.setMargins(0, 5, 0, 9);
        b.setLayoutParams(p);

        l.addView(b);
        b.setOnClickListener(v -> r.run());

        return b;
    }

    static TextView text(Activity a, LinearLayout l, String str) {
        TextView t = new TextView(a);
        t.setText(str);
        t.setTextSize(16);
        t.setTextColor(TEXT);
        t.setPadding(4, 10, 4, 10);
        l.addView(t);
        return t;
    }

    static EditText input(Activity a, LinearLayout l, String hint) {
        EditText e = new EditText(a);
        e.setHint(hint);
        e.setSingleLine(true);
        e.setTextSize(16);
        e.setPadding(14, 10, 14, 10);
        e.setBackground(shape(WHITE, 14));

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        p.setMargins(0, 5, 0, 10);
        e.setLayoutParams(p);

        l.addView(e);
        return e;
    }

    static void nav(Activity a, LinearLayout l) {
        TextView label = new TextView(a);
        label.setText("EXPLORE");
        label.setTextSize(12);
        label.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        label.setTextColor(MUTED);
        label.setPadding(2, 20, 0, 6);
        l.addView(label);

        button(a, l, "My Pantry", () ->
                a.startActivity(new Intent(a, PantryActivity.class)));

        button(a, l, "Suggested Recipes", () ->
                a.startActivity(new Intent(a, RecipesActivity.class)));

        button(a, l, "Settings", () ->
                a.startActivity(new Intent(a, SettingsActivity.class)));
    }
}
