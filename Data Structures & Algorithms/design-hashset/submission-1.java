class MyHashSet {
    private static final int SIZE = 1000;
    private List<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        List<Integer> bucket = buckets[hash(key)];

        if (!bucket.contains(key)) {
            bucket.add(key);
        } 
    }
    
    public void remove(int key) {
        List<Integer> bucket = buckets[hash(key)];
        bucket.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return buckets[hash(key)].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */