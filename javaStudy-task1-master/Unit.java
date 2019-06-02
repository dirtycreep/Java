package task1;


public class Unit {

    /** One Static counter for all created units - generate unique Id*/
    private static int unitIdCounter=1;

    /** Store Id for each unit   */
    private int unitId;

    /** Store Unit Name in String   */
    private String unitName;

    /** Store Room Object, where is the current Unit situated*/
    private task1.Room room;

    /** Store unit power in int  */
    private int power;

    /** Store current state for Unit Power - true - if Powered and false if not */
    private boolean isPowerOn;

    /**
     * Constructor - returns new Unit Object
     * @param unitName - String - name for new Unit
     * @param power - power - for new Unit
     * @param room - current Room object
     */
    public Unit (String unitName, int power, task1.Room room){
        unitId = unitIdCounter++;
        this.unitName = unitName;
        this.power = power;
        this.room = room;
    }

    /**
     * Method returns Unit ID number
     * @return - int - unit ID number
     */
    public int getUnitId (){
        return unitId;
    }

    /**
     * Method returns Unit power value
     * @return - int - unit power value
     */
    public int getUnitPower (){
        return power;
    }

    /**
     * Method returns Unit String Name
     * @return - String  - unit Name
     */
    public String getUnitName (){
        return unitName;
    }

    /**
     * Method replace current room Object from current unit with Null value
     * @return nothing
     */
    public void removeRoomFromUnit(){
        room=null;
    }

    /**
     * Method switch currant Unit ON
     * @return nothing
     */
    public void powerOnUnit() {
        this.isPowerOn = true;
    }

    /**
     * Method switch currant Unit OFF
     * @return nothing
     */
    public void powerOffUnit() {
        this.isPowerOn = false;
    }

    /**
     * Method returns the current Unit power status
     * @return true - is unit is powered ON otherwise false
     */
    public boolean isUnitPoweredOn() {
        return isPowerOn;
    }

    /**
     * Overrided method toString - returns text description for Unit object
     * @return - String with the Unit fields
     */
    @Override
    public String toString() {
        return "Unit{" +
                "unitId=" + unitId +
                ", unitName='" + unitName + '\'' +
                ", room=" + room +
                ", power=" + power +
                ", isPowerOn=" + isPowerOn +
                "}";
    }

    /**
     * Overrided method equals for Unit equals check
     * @param o - another Unit Object
     * @return true, if Units are identic, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        if (unitId != unit.unitId) return false;
        if (power != unit.power) return false;
        if (!unitName.equals(unit.unitName)) return false;
        return !(room != null ? !room.equals(unit.room) : unit.room != null);
    }

}
