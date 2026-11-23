class TimeMap {
    private record Entry(int timestamp, String value) {}
    private Map<String, List<Entry>> map;

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

        // find the latest timestamp

        int l = 0;
        int r = list.size() - 1;
        String ans = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;
            Entry e = list.get(mid);

            if (e.timestamp() <= timestamp) {
                ans = e.value();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
