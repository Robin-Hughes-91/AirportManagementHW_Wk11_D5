public enum PlaneType {

    BOEING747(4),
    BOEING740(1),
    BOEING748(5);


    private final int value;


    PlaneType(int value){
        this.value = value;
    }


    public int getValue() {
        return this.value;
    }

}
