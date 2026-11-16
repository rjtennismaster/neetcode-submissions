class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];

        int top = 0;
        for (int a : asteroids) {
            boolean alive = true;

            while (alive && top > 0 && stack[top - 1] > 0 && a < 0) {
                int posA = stack[top - 1];
                int negA = Math.abs(a);

                if (posA < negA) {
                    top--;
                } else if (posA == negA) {
                    top--;
                    alive = false;
                } else {
                    alive = false;
                }
            }


            if (alive) {
                stack[top++] = a; 
            }
        }

        return Arrays.copyOf(stack, top);
    }
}