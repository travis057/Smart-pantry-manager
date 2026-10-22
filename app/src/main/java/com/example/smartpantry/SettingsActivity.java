package com.example.smartpantry;
import android.app.*;import android.content.*;import android.widget.*;
public class SettingsActivity extends Activity{
 public void onCreate(android.os.Bundle b){super.onCreate(b);LinearLayout l=UI.page(this,"Settings");Switch s=new Switch(this);s.setText("Highlight ingredients expiring soon (preference)");s.setChecked(getPreferences(MODE_PRIVATE).getBoolean("alerts",false));s.setOnCheckedChangeListener((v,checked)->getPreferences(MODE_PRIVATE).edit().putBoolean("alerts",checked).apply());l.addView(s);UI.text(this,l,"This preference is saved locally. Automatic expiry notifications are not implemented.");UI.nav(this,l);}
}
