class Main {
  public static void main(String[] args) {
    Cliente cliente1 = new Cliente("carlos", 15);
    Cliente cliente2 = new Cliente("carla", 13);
    Cliente cliente3 = new Cliente("carlito", 75);
    Cliente cliente4 = new Cliente("carlita", 18);

    System.out.println("carlos vai pagar: "+ cliente1.valueTicket(5));
    System.out.println("carla vai pagar: "+ cliente2.valueTicket(7));
    System.out.println("carlito vai pagar: "+ cliente3.valueTicket(7));
    System.out.println("carlita vai pagar: "+ cliente4.valueTicket(4));
  }
}