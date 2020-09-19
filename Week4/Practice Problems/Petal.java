public class Petal {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        double[] x = new double[N + 1];
        double[] y = new double[N + 1];       
        for(int i=0; i<=N; i++){
            double theta = i*2*Math.PI/N;
            double r = Math.sin(n*theta);
            x[i] = r*Math.cos(theta);
            y[i] = r*Math.sin(theta);
        }
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        for (int i = 0; i < N; i++)
            StdDraw.line(x[i], y[i], x[i + 1], y[i + 1]);
    }
}