package TheSmurfs;

public class dijkstra {
static char [][] gargamel=new char[11][13];
  public static void Dijkstra(int matrix[][]){
    
    int x1=0,y1=0,x2=0,y2=0;
    int count=0;
    int a=0;
    for(int i=0;i<11;i++){
        for(int j=0;j<13;j++){
            gargamel[i][j]=TheSmurfs.maze[i][j];
        }
    }
    for(int i=0;i<13*11;i++){
           for(int j=0;j<13*11;j++){
                if(matrix[i][j]==1){
                   count++;
                }
           }
           
       }
      Graph labirinto = new Graph(count); 
    for(int i=0;i<13*11;i++){
           for(int j=0;j<13*11;j++){
               if(matrix[i][j]==1){
               x1=i%13;
               x2=j%13;
               y1=i/13;
               y2=j/13;
               if(TheSmurfs.maze[y1][x1]=='0'||TheSmurfs.maze[y2][x2]=='0'){
               labirinto.makeEdge(i, j, 100000000);
               labirinto.makeEdge(j, i, 100000000);
               
               }
               else{
               labirinto.makeEdge(i, j, 1);
               labirinto.makeEdge(j, i, 1);
               }
               }
                   
           }
       }
   

    System.out.println("Best path:");
    for (Integer vertice : labirinto.path((TheSmurfs.Gargamel.y*13)+TheSmurfs.Gargamel.x, (TheSmurfs.player1.Y*13)+TheSmurfs.player1.X)) {
        if(((TheSmurfs.Gargamel.y*13)+TheSmurfs.Gargamel.x)!=vertice){
        gargamel[vertice/13][vertice%13]='G';
        }
       
      System.out.print((vertice) + " -> ");
    }
    System.out.println("Freedom!!!");
  }
}
