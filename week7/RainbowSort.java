public class RainbowSortSolution {
    //My initial solution of rainbow sort
    public int[] rainbowSort(int[] array) {
        if(array == null || array.length == 0) {
            return new int[0];
        }

        int a = 0, b = 0, c = array.length - 1;
        while(b < c) {
            while(a < c && array[a] == -1) a++;
            if(b < a)
                b = a;
            while(b < c && array[b] == 0) b++;
            while(b < c && array[c] == 1) c--;

            if(b <= c) {
                if(array[b] == -1) {
                    array[b] = array[a];
                    array[a] = -1;
                    a++;
                }
                else if(array[b] == 1) {
                    array[b] = array[c];
                    array[c] = 1;
                    c--;
                }
            }
        }
        return array;
    }
}
