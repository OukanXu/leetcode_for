class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        //判断两个矩形位置关系，就是判断两个中心点的位置关系
        int pointAx = (ax2+ax1)/2;
        int pointAy = (ay2+ay1)/2;

        int pointBx = (bx1+bx2)/2;
        int pointBy = (by1+by2)/2;

        int rangeX = Math.abs(pointAx-pointBx);
        int rangeY = Math.abs(pointAy-pointBy);

        int widthA = ax2-ax1;
        int heightA = ay2-ay1;

        int widthB = bx2-bx1;
        int heightB = by2-by1;

        int rectanA = widthA*heightA;
        int rectanB = widthB*heightB;

        if(rangeX < (widthA+widthB)/2 && rangeY < (heightB+heightA)/2){
            int left = Math.max(ax1,bx1);
            int buttom = Math.max(ay1,by1);
            int right = Math.min(ax2,bx2);
            int top = Math.min(ay2,by2);
            return rectanA+rectanB-(top-buttom)*(right-left);
        }else{
            return rectanA+rectanB;
        }  
    }
}