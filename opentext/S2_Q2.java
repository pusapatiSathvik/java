import java.util.Scanner;

class S2_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        //row check
        if (x1 == x2) {
            System.out.println("true row");
            return;
        }
        if (y1 == y2) {
            System.out.println("true col");
            return;
        }
        //
        // up to down diagonal
        for(int i =x1,j=y1;i<8 && j<8;i++,j++){
            if (i==x2 && j==y2) {
                System.out.println("up to down");
                return;
            }
        }
        //down-to-up
        for(int i =x1,j=y1;i>=0 && j<8;i--,j++){
            if (i==x2 && j==y2) {
                System.out.println("down to up");
                return;
            }
        }
        System.out.println("NO");
    }
    public static void sol2(int x1,int y1,int x2,int y2){
        if (x1==x2 || y1==y2 || Math.abs(x1-x2) == Math.abs(y1-y2)) {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
