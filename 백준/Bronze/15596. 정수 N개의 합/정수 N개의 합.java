class Test {
    long sum(int[] a) {
        long sum = 0L;

        for(int i=0; i<a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}