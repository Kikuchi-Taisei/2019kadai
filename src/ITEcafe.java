import java.util.Scanner;
import java.util.Calendar;

public class ITEcafe {

    public static void main(String[] args) {
       Item hotcoffee=new Item(1,"ホットコーヒー",280);     
       Item tea=new Item(2,"紅茶",260);
       Item shortcake=new Item(3,"ショートケーキ",300);
       Item chocolatocake=new Item(4,"チョコレートケーキ,",400);
       Item aisutea=new Item(5,"アイスコーヒー",200);
       Item curry=new Item(6,"カレー",500);
       Item neapolitan=new Item(7,"ナポリタン",500);
       Item[]items=new Item[7];
       
       items[0]=hotcoffee;
       items[1]=tea;
       items[2]=shortcake;
       items[3]=chocolatocake;
       items[4]=aisutea;
       items[5]=curry;
       items[6]=neapolitan;
       ItemKago kago = new ItemKago();
       Scanner sc=new Scanner(System.in);
       int goukeiKin=0;
       Calendar cal=Calendar.getInstance();
       int kaikeiNo=1;
          // 商品一覧を表示する
        // レジ全体のループ

        while (true) {

            // １会計のループ

            while (true) {

                // １商品のループ

                while (true) {

                    // タイトルヘッダーの表示

                    System.out.println("■■■■■■■■■■■■■■■　ITEカフェシステム　レジ画面（商品一覧） ■■■■■■■■■■■■■■■■■■■■■");



                    // 商品一覧を表示する

                    for (int i = 0; i < items.length; i++) {

                        if ((i + 1) % 4 != 0) {

                            System.out.printf("%-20s", items[i].getNo() + ":" + items[i].getName());

                        } else {

                            System.out.printf("%-20s%n", items[i].getNo() + ":" + items[i].getName());
                        }
                    }
                    
                 // タイトルフッターの表示
                    System.out.println();
                    System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");



                    System.out.print("商品番号を入力してください：");
                    int inputItemNum = Integer.parseInt(sc.next());

                    System.out.print("数量(+/-)を入力してください：");

                    int inputItemCount = Integer.parseInt(sc.next());



                    // カゴに入れる

                    kago.inputKago(items[inputItemNum - 1], inputItemCount);



                    //合計金額を加算する

                    goukeiKin += items[inputItemNum - 1].getPrice() * inputItemCount;



                    // カゴの一覧を表示

                    System.out.println("---------- 注文一覧 ----------");
                    kago.dispKago();

                    System.out.println("------------------------------");



                    System.out.print("お会計=(k)aikei / 継続入力(n)ext：");



                    String inputChar = sc.next();

                    if (inputChar.charAt(0) == 'k') {

                        break;



                    } else if (inputChar.charAt(0) == 'n') {

                        continue;

                    }



                }
                         // お会計処理

                // 合計金額の表示

                System.out.println("-------------------------------");

                System.out.println("小計     " + goukeiKin + "円");

                System.out.println("消費税    " + (int) (Math.floor(goukeiKin * 0.08)) + "円");

                goukeiKin = (int) (Math.floor(goukeiKin * 1.08));

                System.out.println("合計金額  " + goukeiKin + "円");

                System.out.println("-------------------------------");



                System.out.print("以上で宜しいですか？=(y)es / 取り消し=(c)ancel : ");

                String inputChar = sc.next();

                if (inputChar.charAt(0) == 'y') {



                    break;



                } else if (inputChar.charAt(0) == 'c') {

                    // 合計金額を0にする

                    goukeiKin = 0;

                    // カゴを空にする

                    kago.clearKago();



                    continue;

                }



            }



            // 代金預かり

            System.out.println("-------------------------------");

            System.out.print("預り金を入力してください：");

            String azukariKin = sc.next();

            int turiKin = Integer.parseInt(azukariKin) - goukeiKin;

            System.out.println("釣銭：" + turiKin + "円");



            // 会計番号計算

            System.out.println(cal.get(Calendar.YEAR) + "年"

                    + cal.get(Calendar.MONTH) + "月"

                    + cal.get(Calendar.DATE) + "日"

                    + cal.get(Calendar.HOUR_OF_DAY) + "時"

                    + cal.get(Calendar.MINUTE) + "分");



            System.out.printf("お会計番号：%06d\n", kaikeiNo);

            kaikeiNo++;



            System.out.println("-------------------------------");



            System.out.println("ありがとうございました");



           
            



        }

    }



}



                        

                    
    
 

              
          

       
                 
         
    
    
             
   
          
           



    
    
    
             
            
        
   






    
 