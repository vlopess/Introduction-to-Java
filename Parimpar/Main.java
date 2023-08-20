class Main {
  public static void main(String[] args) {
    Parimpar n1 = new Parimpar(true);
    Parimpar n2 = new Parimpar(false);
    Parimpar n3 = new Parimpar(true);
    Parimpar n4 = new Parimpar(false);
    n1.iterar(10, 1);
    System.out.println("#############");
    n2.iterar(10, 2);
    System.out.println("#############");
    n3.iterar(10, 3);
    System.out.println("#############");
    n4.iterar(10, 5);
    System.out.println("#############");
    n4.iterar(10, 3);
  }
}