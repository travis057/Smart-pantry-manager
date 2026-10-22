package com.example.smartpantry;
import android.app.*;import android.content.*;import android.database.*;import android.widget.*;
public class RecipesActivity extends Activity{
 public void onCreate(android.os.Bundle b){super.onCreate(b);show();}protected void onResume(){super.onResume();show();}
 void show(){LinearLayout l=UI.page(this,"Suggested Recipes");UI.nav(this,l);DB db=new DB(this);Cursor c=db.getReadableDatabase().rawQuery("SELECT id,name FROM recipes ORDER BY name",null);int count=0;try{while(c.moveToNext()){long id=c.getLong(0);String name=c.getString(1);if(db.matches(id)){count++;UI.button(this,l,name+"  →",()->{Intent i=new Intent(this,RecipeDetailActivity.class);i.putExtra("recipe_id",id);startActivity(i);});}}}finally{c.close();db.close();}if(count==0)UI.text(this,l,"No recipes match your pantry yet — add more ingredients. Every required ingredient and quantity must be available.");else UI.text(this,l,count+" recipe(s) you can make right now.");}
}
