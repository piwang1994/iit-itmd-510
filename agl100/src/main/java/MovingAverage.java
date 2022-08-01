class MovingAverage {

    int sum;
    int eleSize;
    int size;
    int[] arr;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size=size;
        this.arr=new int[size];

    }

    public double next(int val) {
        eleSize++;
        if(eleSize>size){
            sum-=arr[(eleSize-1)/size];
        }

        sum+=val;
        return 1.0*sum/(Math.min(size, eleSize));

    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */