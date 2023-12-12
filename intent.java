EditText name ;
Button click ;
  click.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
  Intent it = new Intent(MainActivity.this, SecondActivity.class);
  Bundle b = new Bundle() ;
  b.putString("name",name.getText().toString());
  it.putExtras(b) ;
  startActivity(it);
  }
});

name = findViewById(R.id.name) ;
click = findViewById(R.id.click);

//second activity
TextView myName ;
String nameFromFirstActivity =" ";
//inside oncreate
myName = findViewById(R.id.mytext) ;
nameFromFirstActivity = getIntent().getStringExtra("name");
myName.setText(nameFromFirstActivity);
//<uses-permission android:name="android.permission.CALL_PHONE"/>
call.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Uri myUri = Uri.parse("tel:"+phoneNumberToCall.getText().toString());
Intent it = new Intent(Intent.ACTION_DIAL, myUri) ;
startActivity(it);
}
});
