class MyHashMap {
    private static final int SIZE = 1000;
    private List<int[]>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        List<int[]> bucket = buckets[hash(key)];

        for (int[] pair : bucket) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }

        bucket.add(new int[] {key, value});
    }

    public int get(int key) {
        List<int[]> bucket = buckets[hash(key)];

        for (int[] pair : bucket) {
            if (pair[0] == key) {
                return pair[1];
            }
        }

        return -1;
    }

    public void remove(int key) {
        buckets[hash(key)].removeIf(pair -> pair[0] == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */