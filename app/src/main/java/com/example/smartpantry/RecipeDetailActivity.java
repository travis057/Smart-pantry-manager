package com.example.smartpantry;
import android.app.*;import android.database.*;import android.widget.*;
public class RecipeDetailActivity extends Activity{
 public void onCreate(android.os.Bundle b){super.onCreate(b);long id=getIntent().getLongExtra("recipe_id",-1);DB db=new DB(this);Cursor c=db.getReadableDatabase().rawQuery("SELECT name,steps FROM recipes WHERE id=?",new String[]{""+id});if(!c.moveToFirst()){c.close();db.close();finish();return;}String name=c.getString(0),steps=c.getString(1);c.close();LinearLayout l=UI.page(this,name);UI.text(this,l,"Ingredients:");Cursor r=db.getReadableDatabase().rawQuery("SELECT name,quantity,unit FROM requirements WHERE recipe_id=?",new String[]{""+id});while(r.moveToNext())UI.text(this,l,"• "+r.getString(0)+": "+r.getDouble(1)+" "+r.getString(2));r.close();UI.text(this,l,"Preparation:");UI.text(this,l,steps);UI.button(this,l,"Back to Suggestions",()->finish());db.close();}
}
