
public class HashTable {
    private int[] table;
    private int c1, c2, c3;
    private int delMarker = -1;
    private int tableSize;

    public HashTable(int n) {
        // TODO: fill your code
        tableSize = n;
    }

    public void create(int c1, int c2, int c3) {
        // TODO: fill your code
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        table = new int[tableSize];
        for(int i = 0; i < tableSize; i++) table[i] = 0;
    }

    public void insert(int key) {
        // TODO: fill your code
        int pos, i = 0;
        do {
            pos = quadProb(key, i);
            i++;
        }while(table[pos] != 0 && table[pos] != delMarker);
        table[pos] = key;
        System.out.printf("INSERT: %d, INDEX: %d\n", key, pos);
    }

    public void delete(int key) {
        // TODO: fill your code
        int pos, i = 0;
        do{
            pos = quadProb(key, i);
            if(table[pos] == 0) {
                System.out.printf("Failed to find %d\n", key);
                return;
            }
            i++;
        }while(table[pos] != key);
        table[pos] = delMarker;
        System.out.printf("DELETE: %d, INDEX: %d\n", key, pos);
    }

    public void search(int key) {
        // TODO: fill your code
        int pos, i = 0;
        do{
            pos = quadProb(key, i);
            if(table[pos] == 0) {
                System.out.printf("Failed to find %d\n", key);
                return;
            }
            i++;
        }while(table[pos] != key);
        System.out.printf("SEARCH: %d, INDEX: %d\n", key, pos);
    }

    public void maxProbe() {
        // TODO: fill your code
        int ret = 1, count = 0;
        int pos;
        for(int i = 0; i < tableSize; i++) {
            count = 0;
            do{
                pos = quadProb(i, count);
                count++;
            }while(table[pos] != 0 && table[pos] != delMarker);
            if(count > ret) ret = count;
        }
        System.out.printf("Maximum number of probes: %d\n", ret);
    }

    private int quadProb(int k, int i) {
        // TODO: fill your code
        return (k%tableSize + c1*i*i + c2*i + c3)%tableSize;
    }
}
