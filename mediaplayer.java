1. package com.example.mediaplayer;
2. import androidx.appcompat.app.AppCompatActivity;
3. import android.media.MediaPlayer;
4. import android.os.Bundle;
5. import android.view.View;
6. import android.widget.Button;
7. import android.widget.Toast;
8. public class MainActivity extends AppCompatActivity {
9. Button play, forward, rewind, pause, stop, reset;
10. MediaPlayer mediaPlayer ;
11. int starttime = 0 ; // startime is 0s
12. int stopttime = 0; // stoptime is 0s by default
13. int forwardtime = 5000 ; // 5s for forward
14. int backwardtime = 5000 ; // 5s for backwardtime
15. @Override
16. protected void onCreate(Bundle savedInstanceState) {
17. super.onCreate(savedInstanceState);
18. setContentView(R.layout.activity_main);
19. play= findViewById(R.id.play);
20. pause= findViewById(R.id.pause);
21. stop= findViewById(R.id.stop);
22. forward= findViewById(R.id.forward);
23. rewind= findViewById(R.id.rewind);
24. reset= findViewById(R.id.restart);
25. play.setOnClickListener(new View.OnClickListener() {
26. @Override
27. public void onClick(View view) {
28. Toast.makeText(MainActivity.this, "Playing Media Now",
29. Toast.LENGTH_SHORT).show();
30. mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.charlie);
31. mediaPlayer.start();
32. }
33. });
34. pause.setOnClickListener(new View.OnClickListener() {
35. @Override
36. public void onClick(View view) {
37. mediaPlayer.pause();
38. }
39. });
40. reset.setOnClickListener(new View.OnClickListener() {
41. @Override
42. public void onClick(View view) {
43. mediaPlayer.seekTo(starttime);
44. mediaPlayer.start();
45. }
46. });
47. forward.setOnClickListener(new View.OnClickListener() {
48. @Override
49. public void onClick(View view) {
50. int currpos=mediaPlayer.getCurrentPosition();
51. if((currpos+forwardtime)<=(stopttime=mediaPlayer.getDuration())){
52. mediaPlayer.seekTo(currpos+forwardtime);
53. }
54. }
55. });
56. rewind.setOnClickListener(new View.OnClickListener() {
57. @Override
58. public void onClick(View view) {
59. int currpos=mediaPlayer.getCurrentPosition();
60. if((currpos-backwardtime)<=(starttime)){
61. mediaPlayer.seekTo(currpos-backwardtime);
62. }
63. }
64. });
65. stop.setOnClickListener(new View.OnClickListener() {
66. @Override
67. public void onClick(View view) {
68. mediaPlayer.stop();
69. }
70. });
71. }
72. }
