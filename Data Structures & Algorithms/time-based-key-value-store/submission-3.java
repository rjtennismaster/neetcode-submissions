class TimeMap {
    private record Entry(int timestamp, String value){}
    private Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // binary search for index of timestamp <= prev_timestamp
        List<Entry> list = map.get(key);

        if (list == null) {
            return "";
        }

        int l = 0;
        int r = list.size() - 1;
        String ans = "";

        while (l <= r) {
            int idx = l + (r - l) / 2;
            Entry e = list.get(idx);

            if (e.timestamp() <= timestamp) {
                ans = e.value();
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        }

        return ans;
    }
}
