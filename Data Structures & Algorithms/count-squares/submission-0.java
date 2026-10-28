class CountSquares {
    public record Point<K, V>(K x, V y) {}
    Map<Point<Integer, Integer>, Integer> ptCount;
    List<Point<Integer, Integer>> pts;

    public CountSquares() {
        ptCount = new HashMap<>();
        pts = new ArrayList<>();
    }

    public void add(int[] point) {
        Point<Integer, Integer> pt = new Point<>(point[0], point[1]);
        ptCount.merge(pt, 1, Integer::sum);
        pts.add(pt);
    }

    public int count(int[] point) {
        // get point in pt format
        int px = point[0], py = point[1];
        // try to see if we can get a diagonal w/ existing points, add to res
        int res = 0;
        for (Point<Integer, Integer> pt : pts) {
            int x = pt.x(), y = pt.y();

            if ((Math.abs(px - x) != Math.abs(py - y)) || x == px || y == py) {
                continue;
            }

            res += ptCount.getOrDefault(new Point<>(x, py), 0)
                * ptCount.getOrDefault(new Point<>(px, y), 0);
        }

        return res;
    }
}
