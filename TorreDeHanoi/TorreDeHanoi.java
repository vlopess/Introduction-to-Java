class TorreDeHanoi{
  public static void main(String[] args){
    torresDeHanoi(64, "primeiro pino", "pino final", "pino temporário");
  }
  private static void torresDeHanoi(int numeroDeAneis, String origem, String destino, String auxiliar){
    if(numeroDeAneis > 0){
      torresDeHanoi(numeroDeAneis-1, origem, auxiliar, destino);
      System.out.println("Mover pino "+numeroDeAneis+" de "+ origem+ " para "+ destino);
      torresDeHanoi(numeroDeAneis-1, auxiliar, destino, origem);      
    }
  }
}