//package fintech;
//
//public class 문제2 {
//
//    public static void main(String[] args) {
//
//        int[] arr = {0, 1,2,5,3,7};
//
//        int before = arr[0];
//        int startIndex = 0;
//        int answer = 0;
//        for (int i = 1; i < arr.length; i++) {
//
//
//            if (arr[i] > before) {
//                if (topIndex == -1) {
//
//                } else {
//                    answer += (topIndex - startIndex) * (i - topIndex);
//                    startIndex = i;
//                    topIndex = -1;
//                }
//            } else if (arr[i] == before){
//                answer += (topIndex - startIndex) * (i - topIndex);
//                startIndex = i;
//                topIndex = -1;
//            } else {
//                if (topIndex == -1) {
//                    topIndex = i - 1;
//                } else {
//                    before
//                }
//            }
//
//
//
//            if (topIndex != -1) {
//              if (arr[i] > before) {
//                answer += (topIndex - startIndex) * (i - topIndex);
//                before = arr[i];
//                startIndex = i;
//              } else {
//
//              }
//            } else {
//                if (before > arr[i]) {
//                    topIndex = i - 1;
//                } else {
//                    startIndex = i;
//                    answer += (topIndex - startIndex) * ((arr.length - 1) - topIndex);
//                }
//            }
//
//
//
////            if (topIndex != -1) {
////                if (arr[i] >= before) {
////                    answer += (topIndex - startIndex) * (i - topIndex);
////                    before = arr[i];
////                    startIndex = i;
////                }
////            } else {
////                if (before > arr[i]) {
////                    topIndex = i - 1;
////                } else if (before == arr[i]) {
////                  startIndex = i;
////                }
////                before = arr[i];
////            }
//        }
////        answer += (topIndex - startIndex) * ((arr.length - 1) - topIndex);
//        System.out.println(answer);
//    }
//}