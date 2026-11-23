class TimeMap {
    private record Entry(int timestamp, String value) {};
    Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Entry> list = map.get(key);
        if (list == null) {
            return "";
        }

        // binary search on the index where timestamp <= prev_timestamp
        int l = 0;
        int r = list.size() - 1;
        String ans = "";
        
        while (l <= r) {
            int index = l + (r - l) / 2;
            Entry e = list.get(index);

            if (e.timestamp() <= timestamp) {
                ans = e.value();
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        
        return ans;
    }
}
