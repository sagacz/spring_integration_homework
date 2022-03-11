class ForEach {
    public static void main(String[] args) {
        int tab[][] = new int[10][5];

        for(int ix = 0; ix < 10; ix++)
            for(int iy = 0; iy < 5; iy++)
                tab[ix][iy] = ix + iy;

        for(int[] rows: tab){
            for(int col: rows){
                System.out.println(col);
            }
        }
    }
}