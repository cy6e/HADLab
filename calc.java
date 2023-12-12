package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
 import android.widget.Button;
 7. import android.widget.EditText;
 8. import android.widget.TextView;
 9.
10. public class MainActivity extends AppCompatActivity implements View.OnClickListener {
11. EditText result;
12. TextView label;
13. String currentInput = "";
14. String operator = "";
15. double firstOperand = 0.0;
16.
17. @Override
18. protected void onCreate(Bundle savedInstanceState) {
19. super.onCreate(savedInstanceState);
20. setContentView(R.layout.activity_main);
21.
22. result = findViewById(R.id.res);
23. label = findViewById(R.id.label);
24.
25. setClickListeners();
26. }
27.
28. @Override
29. public void onClick(View view) {
30. int viewId = view.getId();
31.
32. if (viewId == R.id.one) {
33. currentInput += "1";
34. } else if (viewId == R.id.two) {
35. currentInput += "2";
36. } else if (viewId == R.id.three) {
37. currentInput += "3";
38. } else if (viewId == R.id.four) {
39. currentInput += "4";
40. } else if (viewId == R.id.five) {
41. currentInput += "5";
42. } else if (viewId == R.id.six) {
43. currentInput += "6";
44. } else if (viewId == R.id.seven) {
45. currentInput += "7";
46. } else if (viewId == R.id.eight) {
47. currentInput += "8";
48. } else if (viewId == R.id.nine) {
49. currentInput += "9";
50. } else if (viewId == R.id.zero) {
51. currentInput += "0";
52. } else if (viewId == R.id.plus) {
53. handleOperatorClick("+");
54. } else if (viewId == R.id.minus) {
55. handleOperatorClick("-");
56. } else if (viewId == R.id.multiply) {
57. handleOperatorClick("*");
58. } else if (viewId == R.id.divide) {
59. handleOperatorClick("/");
60. } else if (viewId == R.id.clear) {
61. clearInput();
62. } else if (viewId == R.id.equal) {
63. calculateResult();
64. }
65.
66. result.setText(currentInput);
67. }
68.
69. private void setClickListeners() {
70. int[] buttonIds = {
71. R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven,
R.id.eight, R.id.nine,
72. R.id.zero, R.id.plus, R.id.minus, R.id.multiply, R.id.divide, R.id.clear,
R.id.equal
73. };
74.
75. for (int id : buttonIds) {
76. Button button = findViewById(id);
77. button.setOnClickListener(this);
78. }
79. }
80.
81. private void handleOperatorClick(String op) {
82. if (!currentInput.isEmpty()) {
83. firstOperand = Double.parseDouble(currentInput);
84. operator = op;
85. currentInput = "";
86. }
87. }
88.
89. private void clearInput() {
90. currentInput = "";
91. operator = "";
92. firstOperand = 0.0;
93. result.setText("");
94. }
95.
96. private void calculateResult() {
97. if (!currentInput.isEmpty() && !operator.isEmpty()) {
98. double secondOperand = Double.parseDouble(currentInput);
99. double resultValue = 0.0;
100.
101. if (operator.equals("+")) {
102. resultValue = firstOperand + secondOperand;
103. } else if (operator.equals("-")) {
104. resultValue = firstOperand - secondOperand;
105. } else if (operator.equals("*")) {
106. resultValue = firstOperand * secondOperand;
107. } else if (operator.equals("/")) {
108. if (secondOperand != 0) {
109. resultValue = firstOperand / secondOperand;
110. } else {
111. result.setText("Cannot divide by zero");
112. return;
113. }
114. }
115.
116. result.setText(String.valueOf(resultValue));
117. currentInput = String.valueOf(resultValue);
118. operator = "";
119. }
120. }
121. }
