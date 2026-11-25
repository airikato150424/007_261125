import java .util.Scanner;
class tensa001{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        
        //N(試験の数)とL（学生の人数）を読み込む
        int n = sc.nextInt();
        int l = sc.nextInt();

        //L人×N試験分の得点を格納する二次元配列
        int[][]scores = new int[l][n];

        //全員の得点を読み込む
        for(int k =0;k<l;k++){
            for(int i =0;i<n;i++){
                scores[k][i] = sc.nextInt();
            }
        }

        //各学生の最高得点取得回数を記録する配列
        int[] winCount = new int[l];

        //1.試験(i)ごとに最高得点を調べ、該当する学生をカウント
        for(int i=0;i<n;i++){
            //まずはi番目の試験の最高得点を見つける
            int maxScore =-1;
            for(int k =0;k<l;k++){
                if(scores[k][i]>maxScore){
                    maxScore = scores[k][i];
                }
            }

            //最高得点と同じ点数を取った学生の回数を+1する（同点１位も全員カウント）
            for(int k =0;k<l;k++){
                if(scores[k][i] ==maxScore){
                    winCount[k]++;
                }
            }
        }

        // 2. 最も回数が多い学生を見つける
        int bestStudent = 0; // 学生のインデックス（0始まり）
        int maxWins = -1;

        for (int k = 0; k < l; k++) {
            // 「>」を使うことで、回数が同じ場合は番号が小さい学生が優先される
            if (winCount[k] > maxWins) {
                maxWins = winCount[k];
                bestStudent = k;
            }
        }

        // 学生番号は1から始まるため bestStudent + 1 にして出力
        System.out.println((bestStudent + 1) + " " + maxWins);

    }      
}