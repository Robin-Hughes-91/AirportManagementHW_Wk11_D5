public enum PlaneType {

    BOEING747(3),
    BOEING740(2),
    BOEING748(5);


    private final int value;


    PlaneType(int value){
        this.value = value;
    }


    public int getValue() {
        return this.value;
    }

}
