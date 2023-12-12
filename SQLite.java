1. package com.example.sqlite;
2.
3. import androidx.appcompat.app.AppCompatActivity;
4.
5. import android.os.Bundle;
6. import android.view.View;
7. import android.widget.Button;
8. import android.widget.EditText;
9. import android.widget.TextView;
10. import android.widget.Toast;
11.
12. public class MainActivity extends AppCompatActivity {
13. EditText user,pass;
14. Button register,delete,update,display;
15. DBHelper dbHelper;
16. TextView res;
17. private static final String dbName="studentdb";
18. private static final String tbName="student" ;
19. private static final int dbVersion = 1 ;
20. @Override
21. protected void onCreate(Bundle savedInstanceState) {
22. super.onCreate(savedInstanceState);
23. setContentView(R.layout.activity_main);
24. user=findViewById(R.id.username);
25. pass=findViewById(R.id.password);
26. register=findViewById(R.id.register);
27. delete=findViewById(R.id.delete);
28. update=findViewById(R.id.update);
29. display=findViewById(R.id.display);
30. res=findViewById(R.id.result);
31. register.setOnClickListener(new View.OnClickListener() {
32. @Override
33. public void onClick(View view) {
34. dbHelper=new DBHelper(MainActivity.this, dbName,null,dbVersion);
35. long val = dbHelper.adduser(user.getText().toString(),
pass.getText().toString()) ;
36. if(val == -1)
37. Toast.makeText(MainActivity.this, "Error in adding user",
38. Toast.LENGTH_SHORT).show();
39. else {
40. Toast.makeText(MainActivity.this, "USER REGISTERED",
41. Toast.LENGTH_SHORT).show();
42. }
43. }
44. });
45. update.setOnClickListener(new View.OnClickListener() {
46. @Override
47. public void onClick(View v) {
48. dbHelper = new DBHelper(MainActivity.this, dbName, null, dbVersion) ;
49. dbHelper.update(user.getText().toString(), pass.getText().toString());
50.
51. }
52. });
53. delete.setOnClickListener(new View.OnClickListener() {
54. @Override
55. public void onClick(View v) {
56. dbHelper = new DBHelper(MainActivity.this, dbName,null, dbVersion) ;
57. dbHelper.delete(user.getText().toString());
58. }
59. });
60. res.setOnClickListener(new View.OnClickListener() {
61. @Override
62. public void onClick(View view) {
63. dbHelper = new DBHelper(MainActivity.this, dbName, null, dbVersion);
64. String out= dbHelper.display(MainActivity.this);
65. res.setText(out);
66. }
67. });
68.
69. }
70. }
