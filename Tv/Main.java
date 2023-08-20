class Main {
  public static void main(String[] args) {
    Tv tv1 = new Tv("LG");
    System.out.println(tv1.toString());
    tv1.ligar();
    System.out.println(tv1.toString());
    if(!(tv1.ligar(23, "123"))){
      System.out.println("ERRO");  
    }
    tv1.ligar(23);
    System.out.println(tv1.toString());
    System.out.println("####################");
    Tv tv2 = new Tv("Sony");
    System.out.println(tv2.toString());
    tv2.ligar();
    System.out.println(tv2.toString());
    if(!(tv2.ligar(123, "123"))){
      System.out.println("ERRO");  
    }
    tv2.ligar(212);
    System.out.println(tv2.toString());
    System.out.println("####################");
    Tv tv3 = new Tv("Samsung", "123");
    System.out.println(tv3.toString());
    tv3.ligar(10);
    System.out.println(tv3.toString());
    if(!(tv3.ligar(123, "123"))){
      System.out.println("ERRO");  
    }
    System.out.println(tv3.toString());
    tv3.ligar(212);
    System.out.println(tv3.toString());
    if(!(tv3.ligar(123, "1234"))){
      System.out.println("ERRO");  
    }
    System.out.println("####################");
    Tv tv4 = new Tv("AOC", "000");
    if(!(tv4.ligar(13, "000"))){
      System.out.println("ERRO");  
    }
    System.out.println(tv4.toString());
    tv4.ligar(10);
    System.out.println(tv4.toString());
    if(!(tv4.ligar(12, "123"))){
      System.out.println("ERRO");  
    }
    System.out.println(tv4.toString());
    tv4.ligar(212);
    System.out.println(tv4.toString());
    if(!(tv4.ligar(13, "000"))){
      System.out.println("ERRO");  
    }
    System.out.println("####################");
  }
}