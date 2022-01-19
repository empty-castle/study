### 결합력이 높은 컴포넌트

checkbox

props를 v-model로 연결하면 발생하는 문제를 해결하는 방법

input에서 한글 데이터를 처리하는 경우 v-model 보단 
:value와 @input을 동시에 사용하는 방식으로 처리

v-model을 props로 넘겨서
3.x의 경우에는 modelValue와 update:modelValue로 변경