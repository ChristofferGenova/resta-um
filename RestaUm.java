public class RestaUm{

	//imprimir o tabuleiro	
	public static void imprimirTab(char tabuleiro[][], int pecas){
		
		for(int i=0;i<tabuleiro.length;i++){
			for(int j=0;j<tabuleiro.length;j++){
				System.out.print("["+tabuleiro[i][j]+"]");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	
	public static void jogada(char tabuleiro[][], int pecas, int fim){
		
			for(int i=0;i<11;i++){
				for(int j=0;j<11;j++){
					
					//Achando a parte vazia para comer as peças
            				
				    if(tabuleiro[i][j]==' '){
						if(tabuleiro[i-1][j]=='O' && tabuleiro[i-2][j]=='O'){
							tabuleiro[i][j] = 'O'; tabuleiro[i-1][j] = ' '; tabuleiro[i-2][j] = ' ';
							pecas--;
							imprimirTab(tabuleiro,pecas);
							//Primeira jogada
							if(pecas == fim){
								break;
							}
						}else if(tabuleiro[i][j+1]=='O' && tabuleiro[i][j+2]=='O'){
							tabuleiro[i][j] = 'O'; tabuleiro[i][j+1] = ' '; tabuleiro[i][j+2] = ' ';
							pecas--;
							imprimirTab(tabuleiro,pecas);
							//Segunda jogada
							if(pecas == fim){
								break;
							}
						}else if(tabuleiro[i+1][j]=='O' && tabuleiro[i+2][j]=='O'){
							tabuleiro[i][j] = 'O'; tabuleiro[i+1][j] = ' '; tabuleiro[i+2][j] = ' ';
							pecas--;
							imprimirTab(tabuleiro,pecas);
							//Terceira jogada
							if(pecas == fim){
								break;
							}
						}else if(tabuleiro[i][j-1]=='O' && tabuleiro[i][j-2]=='O'){
							tabuleiro[i][j] = 'O'; tabuleiro[i][j-1] = ' '; tabuleiro[i][j-2] = ' ';
							pecas--;
							imprimirTab(tabuleiro,pecas);
							//Quarta jogada
							if(pecas == fim){
								break;
							}
						}
					}
				}	
			}
		   
		if(pecas > fim){
			jogada(tabuleiro, pecas,fim);
			//Se a quantidade de peças for maior q o numero pedido ele continua.
		}
	    else if(pecas == fim){
				System.out.println("");
				//Se não ele para
		}	
	}
	
	public static void main(String[]args){
		char tabuleiro[][] = new char [11][11]; 
		int op=0, pecas=32;
		
		//Preenchendo o tabuleiro
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				if(j ==0 || j ==1 || j ==9 || j==10 || i==0 || i==1 || i==9 || i==10 ){
					tabuleiro[i][j] = '-';
					//Bordas do tabuleiro
				}else if(i==4 || i==5 || i==6 || j==4 || j==5 || j==6){
					tabuleiro[i][j] = 'O';
					//peças do tabuleiro
				}else{
					tabuleiro[i][j] = '-';
					//Bordas que faltaram
				}
			}
		}
		tabuleiro[5][5] = ' '; //meio do tabuleiro com espaço vazio
		
		
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				System.out.print("["+tabuleiro[i][j]+"]");
				//Imprime o tabuleiro completo
			}
			System.out.println(" ");
		}
		
		//System.out.println("Digite a opcao para a peca centralizada ou nao");
		//op = Input.readInt("1-Centralizada / 2-Nao centralizada: ");
		
		int fim = Input.readInt("Informe com quantas pedras o jogo deve acabar: ");
		
		jogada(tabuleiro, pecas, fim); //Chama a jogada
	}
}