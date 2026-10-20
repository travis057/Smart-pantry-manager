package com.example.smartpantry;
import android.content.*;import android.database.*;import android.database.sqlite.*;import java.util.*;
public class DB extends SQLiteOpenHelper {
 DB(Context c){super(c,"smart_pantry.db",null,1);} 
 public void onCreate(SQLiteDatabase d){d.execSQL("CREATE TABLE pantry(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL,quantity REAL NOT NULL,unit TEXT NOT NULL,expiry TEXT)");d.execSQL("CREATE TABLE recipes(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL,steps TEXT NOT NULL)");d.execSQL("CREATE TABLE requirements(recipe_id INTEGER,name TEXT,quantity REAL,unit TEXT)");seed(d);}
 public void onUpgrade(SQLiteDatabase d,int o,int n){}
 void seed(SQLiteDatabase d){
 recipe(d,"Scrambled Eggs","Beat eggs. Heat butter in a pan. Stir eggs until set.","egg:2:piece","butter:10:g");
 recipe(d,"Boiled Eggs","Boil eggs for 9 minutes and cool.","egg:2:piece","water:500:ml");
 recipe(d,"Cheese Omelette","Whisk eggs. Melt butter, cook eggs and add cheese.","egg:2:piece","cheese:30:g","butter:10:g");
 recipe(d,"Tomato Sandwich","Slice tomato and assemble on bread.","bread:2:slice","tomato:1:piece");
 recipe(d,"Cheese Sandwich","Place cheese between slices of bread.","bread:2:slice","cheese:40:g");
 recipe(d,"Toast with Butter","Toast bread and spread butter.","bread:2:slice","butter:15:g");
 recipe(d,"Peanut Butter Toast","Toast bread and spread peanut butter.","bread:2:slice","peanut butter:25:g");
 recipe(d,"Banana Oats","Cook oats with milk and top with banana.","oats:50:g","milk:200:ml","banana:1:piece");
 recipe(d,"Porridge","Cook oats in milk until thick.","oats:50:g","milk:200:ml");
 recipe(d,"Fruit Yogurt","Slice banana into yogurt.","banana:1:piece","yogurt:150:g");
 recipe(d,"Rice Bowl","Cook rice in water and season with salt.","rice:100:g","water:250:ml","salt:2:g");
 recipe(d,"Tomato Rice","Cook rice, chop tomato and combine.","rice:100:g","water:250:ml","tomato:1:piece");
 recipe(d,"Garlic Pasta","Boil pasta, toss with oil and garlic.","pasta:100:g","water:1000:ml","garlic:2:clove","oil:15:ml");
 recipe(d,"Butter Pasta","Boil pasta and mix with butter.","pasta:100:g","water:1000:ml","butter:20:g");
 recipe(d,"Tomato Pasta","Boil pasta and stir in chopped tomato.","pasta:100:g","water:1000:ml","tomato:2:piece");
 recipe(d,"Potato Mash","Boil potatoes, drain and mash with milk.","potato:2:piece","water:1000:ml","milk:50:ml");
 recipe(d,"Roast Potatoes","Chop potatoes, coat with oil and bake.","potato:2:piece","oil:20:ml");
 recipe(d,"Carrot Salad","Grate carrots and season with lemon juice.","carrot:2:piece","lemon juice:15:ml");
 recipe(d,"Egg Fried Rice","Cook rice, scramble eggs, combine with oil.","rice:100:g","water:250:ml","egg:2:piece","oil:15:ml");
 recipe(d,"Banana Milkshake","Blend banana and milk.","banana:1:piece","milk:250:ml");
 }
 void recipe(SQLiteDatabase d,String name,String steps,String... req){ContentValues v=new ContentValues();v.put("name",name);v.put("steps",steps);long id=d.insert("recipes",null,v);for(String r:req){String[] p=r.split(":");ContentValues w=new ContentValues();w.put("recipe_id",id);w.put("name",p[0]);w.put("quantity",Double.parseDouble(p[1]));w.put("unit",p[2]);d.insert("requirements",null,w);}}
 static String norm(String s){s=s.trim().toLowerCase(Locale.ROOT);if(s.equals("tomatoes"))return "tomato";if(s.equals("potatoes"))return "potato";if(s.equals("eggs"))return "egg";if(s.equals("cloves"))return "clove";if(s.endsWith("s")&&!s.endsWith("ss"))return s.substring(0,s.length()-1);return s;}
 static double base(double n,String unit){switch(unit.toLowerCase(Locale.ROOT)){case "kg":case "l":return n*1000;case "tbsp":return n*15;case "tsp":return n*5;default:return n;}}
 static String dimension(String unit){switch(unit.toLowerCase(Locale.ROOT)){case "kg":case "g":return "mass";case "l":case "ml":case "tbsp":case "tsp":return "volume";case "piece":case "slice":case "clove":return unit.toLowerCase(Locale.ROOT);default:return "unknown:"+unit;}}
 boolean matches(long recipe){SQLiteDatabase d=getReadableDatabase();Cursor req=d.rawQuery("SELECT name,quantity,unit FROM requirements WHERE recipe_id=?",new String[]{String.valueOf(recipe)});try{while(req.moveToNext()){String wanted=norm(req.getString(0)),unit=req.getString(2);double needed=base(req.getDouble(1),unit),have=0;Cursor pantry=d.rawQuery("SELECT name,quantity,unit FROM pantry",null);try{while(pantry.moveToNext()){String u=pantry.getString(2);if(norm(pantry.getString(0)).equals(wanted)&&dimension(u).equals(dimension(unit)))have+=base(pantry.getDouble(1),u);}}finally{pantry.close();}if(have+0.000001<needed)return false;}return true;}finally{req.close();}}
}
