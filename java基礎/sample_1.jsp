<%-- 
    Document   : sample_1.jsp
    Created on : 2016/07/05, 18:44:08
    Author     : ta9muro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String talk = "Hello world!";
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= talk %>
        <%
        // this is test of comment.
        // printlnは1行として出力するもので、連続して実施した場合、自動で改行されていきます。       
        out.print("Hello GeekCamp!");
        out.println("How are you?");
        
        
        // 定数作成 → 型 変数名 = 初期値;
        String message = "Hello github-chan!";
        // 代入
        message = "See you again,github-chan!";
        out.println(message);
        
        
        // 定数作成 → final 型 定数名 = 固定値;
        final String MSG = "Good night, github-chan!";

        out.println(MSG);
        
        // 連結して表示
        out.println(MSG+message);
        
        // 文字操作
        out.println("Hello" + "Japan!!");
        out.println(message + "from Tokyo!");
        out.println("あかさなた");
        

        // 四則演算
        int tashi = 5 + 5; //足し算
        int hiki = 15 - 5; //引き算
        int kake = 2 * 5; //掛け算
        int wari = 20 / 2; //割り算
        int amari = 65 % 11; //余り
        
        int num1,num2,num3,num4 = 10;


        // 条件分岐
        int param = 1;
        
        if(param == 0){
           out.println("paramは0です。");
        
        }else if(param < 0){
            out.println("paramはマイナス値です。");
        }else{
        out.println("paramは1以上です。");
        
        }
               
        int number =2;
        int number2 = 2;
        
        if(number == 1){
           out.println("numberは1です。");
        
        }
        if(number !=1 && number2 == 1){
           out.println("numberは不一致だけどnumber2は一致しています。");
           
        }
        if(number !=1 && number2 !=1 ){
           out.println("numberもnumber2も不一致です。");
        
        }
        %>
        
        <%
        //課題:基礎編
        //課題1
        out.println("Hello world.");
        
        //課題2
        String word1 = "groove";
        String word2 = "-";
        String word3 = "gear";
        
        out.println(word1 + word2 + word3);
        
        //課題3
        final String name = "Takuya";
        String profile = "football";
        String food = "sushi";
        
        out.println("My name is " + name);
        out.println("My hobby is " + profile);
        out.println("My favorite food is " + food);
        
        //課題4と5
        int kazu = 5;
        final int kazu2 = 3;
        
        out.println(kazu + kazu2);
        out.println(kazu - kazu2);
        out.println(kazu * kazu2);
        out.println(kazu / kazu2);
        
        
        
        

        //課題6
        int atai = 3;
        
        if(atai == 1){
            out.println("1です！");
        }
        
        else if(atai == 2){
            out.println("プログラミングキャンプ！");
        }
        
        else{
        out.println("その他です！");
        
        }
        
        %>
        
        
        //応用課題1
        //http://localhost:8080/GeekCamp/sample_1.jsp?type=items&total=1000&count=3
        //http://localhost:8080/GeekCamp/sample_1.jsp?type=foods&total=3500&count=9
        //http://localhost:8080/GeekCamp/sample_1.jsp?type=others&total=5000&count=7
        
        <%
            String type = request.getParameter("type");
            String total = request.getParameter("total");
            String count = request.getParameter("count");
            //typeで文字列
            
            //itemsという文字列は数値に変換できないので、クエリストリングではtype=1 or 2 or 3
            Integer t = Integer.valueOf(type);
            Integer goukei = Integer.valueOf(total);
            Integer kosu = Integer.valueOf(count);
            //tで文字列から数字列に変換うつす
            //type → 1 total → 2 count → 3
            
            if (t==1) {
                out.print("雑貨");
            }
            else if (t==2) {
                out.print("生鮮食品");
            }
            else {
                out.print("その他");
            }
            
            //応用課題2
            out.println(goukei + "yen"); //総額
            out.println(goukei/kosu + "yen"); //1個あたりの値段
            
            //応用問題3
            if (goukei>=3500){
                  out.print(goukei*0.04 + "points");
            }
            else if (goukei>=5000){
                  out.print(goukei*0.05 + "points");
            }

          
        %>
    </body>
</html>
