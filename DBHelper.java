1. package com.example.sqlite;
2.
3. import android.content.ContentValues;
4. import android.content.Context;
5. import android.database.Cursor;
6. import android.database.sqlite.SQLiteDatabase;
7. import android.database.sqlite.SQLiteOpenHelper;
8.
9. import androidx.annotation.Nullable;
10.
11. public class DBHelper extends SQLiteOpenHelper {
12. private static final String dbName="studentdb"; // Database Name
13. private static final String tbName="student" ; // Table Name
14. private static final int dbVersion = 1 ;
15. public DBHelper(@Nullable Context context, @Nullable String name, @Nullable
SQLiteDatabase.CursorFactory factory, int version) {
16. super(context, dbName, factory, dbVersion);
17. }
18.
19. @Override
20. public void onCreate(SQLiteDatabase db) {
21. db.execSQL("CREATE TABLE "+tbName+"(uname VARCHAR(10) ,passw VARCHAR(10))"+";");
22. }
23.
24. @Override
25. public void onUpgrade(SQLiteDatabase db, int i, int i1) {
26. db.execSQL("DROP TABLE IF EXISTS "+tbName);
27. onCreate(db);
28. }
29. public long adduser(String name,String pass){
30. SQLiteDatabase db=this.getWritableDatabase();
31. ContentValues cv=new ContentValues();
32. cv.put("uname",name);
33. cv.put("passw ",pass);
34. long result = db.insert(tbName, null,cv);
35. db.close();
36. return result ;
37. }
38. public void update(String name, String pass){
39. SQLiteDatabase db = this.getWritableDatabase();
40. db.execSQL("UPDATE "+tbName+" SET passw='"+pass+"'"+" WHERE
uname='"+name+"';");//6(b)
41. // UPDATE tbName SET passw='pass' WHERE uname='name' ; SQL statement
42. db.close();
43. }
44. public void delete(String name){
45. SQLiteDatabase db=this.getWritableDatabase();
46. db.execSQL("DELETE FROM "+tbName+" WHERE uname='" +name+"';");
47. db.close();
48. }
49. public String display(Context ctx){
50. SQLiteDatabase db = this.getReadableDatabase();
51. Cursor cursor = db.rawQuery("SELECT * FROM "+tbName, null);
52. String finalres = " " ;
53. while(cursor.moveToNext()){
54. finalres += cursor.getString(0)+":"+cursor.getString(1);
55. }
56. return finalres;
57. }
58. }
