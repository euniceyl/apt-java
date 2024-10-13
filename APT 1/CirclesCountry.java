public class CirclesCountry {
    public static void main(String[] args) {
        CirclesCountry abc = new CirclesCountry();
        int[] x = {-107,-38,140,148,-198,172,-179,148,176,153,-56,-187};
        int[] y = {175,-115,23,-2,-49,-151,-52,42,0,68,109,-174};
        int[] r = {135,42,70,39,89,39,43,150,10,120,16,8};
        int x1 = 102;
        int y1 = 16;
        int x2 = 19;
        int y2 = -108;
        int output = abc.leastBorders(x, y, r, x1, y1, x2, y2);
        System.out.println(output);
    }

    public boolean isInside(int x, int y, int cx, int cy, int r) {
                double dist = (x-cx)*(x-cx) + (y-cy)*(y-cy);
                double radSquared = r*r;
           return dist < radSquared;
        }

    public int leastBorders(int[] x, int[] y, int[] r, 
                            int x1, int y1, int x2, int y2) {
        int crosses = 0;
        for(int k=0; k < x.length; k+= 1){
                if (isInside(x1,y1,x[k],y[k],r[k]) &&
              ! isInside(x2,y2,x[k],y[k],r[k])) {
                        crosses += 1;
                }
                else if (! isInside(x1,y1,x[k],y[k],r[k]) &&
              isInside(x2,y2,x[k],y[k],r[k])) {
                crosses += 1;
              }
        }
        return crosses;
    }
 }