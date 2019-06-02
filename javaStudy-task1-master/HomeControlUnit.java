package task1;

import java.util.ArrayList;

public class HomeControlUnit {

    private ArrayList<task1.Room> rooms;

    public HomeControlUnit (){
        rooms = new ArrayList<>();
    }

    /** Method for adding new room into rooms array
     * @param roomName
     * @return nothing
     * @throws "IllegalArgumentException" in case room existing
     */
    public void addNewRoom(String roomName){
        if (roomName==null || roomName =="") {
            System.out.println("Room name can't be empty or null");
            return;
        }
        if (findRoom(roomName)!=null) throw new IllegalArgumentException("Room already Exists");
        rooms.add(new task1.Room(roomName));
        System.out.println("Room was added");
    }

    /** This method add new Unit,
     * @param unitName - Name for New unit in not Null string with the length>0
     * @param unitPower - Power for Unit - should be positive integer
     * @param roomName - Name of Existing Room - Room shood exists
     * @return nothing
     */
    public void addNewUnit(String unitName, int unitPower, String roomName ){
        if (unitName==null || unitName =="") {
            System.out.println("Unit Name can't be empty or null");
            return;
        } else {
            if (unitPower<=0) {
                System.out.println("Unit Power need to be positive value");
                return;
            }
        }
        task1.Room tempRoom = findRoom(roomName);
        if (tempRoom==null) {
            System.out.println("Room was not find");
            return;
        }
        task1.Unit tempUnit = new task1.Unit(unitName, unitPower, tempRoom);
        tempRoom.assignUnitToRoom(tempUnit);
        System.out.println("Unit was added");
    }

    /**
     * Method for deleting unit
     * @param unitId - Integer  positive value - unique value for each unit
     * @return nothing
     */
    public void deleteUnit (int unitId){
       if (unitId<=0){
           System.out.println("Unit index can be only positive");
           return;
       }
        for (task1.Room room : rooms) {
            for (task1.Unit unit :room.getRoomUnits()){
                if (unit.getUnitId()==unitId){
                    unit.removeRoomFromUnit();
                    room.deleteUnit(unit);
                    System.out.println("Unit was deleted");
                    return;
                }
            }
        }
        System.out.println("Unit wasn't found");
    }

    /**
     * Method is switching unit ON
     * @param unitId - Integer  positive value - unique value for each unit
     */
    public void powerOnUnit (int unitId){
        if (unitId<=0){
            System.out.println("Unit index can be only positive");
            return;
        }
        task1.Unit opUnit = getOneUnit(unitId); // use private method for unit receiving
        if (opUnit!=null) {
            opUnit.powerOnUnit();
            System.out.println("Unit was powerON");
            return;
        } else System.out.println("Unit wasn't found");
    }

    /**
     * Method is switching unit OFF
     * @param unitId - Integer  positive value - unique value for each unit
     */
    public void powerOffUnit (int unitId){
        if (unitId<=0){
            System.out.println("Unit index can be only positive");
            return;
        }
        task1.Unit opUnit = getOneUnit(unitId); // use private method for unit receiving
        if (opUnit!=null) {
            opUnit.powerOffUnit();
            System.out.println("Unit was powerOFF");
            return;
        } else System.out.println("Unit wasn't found");
    }

    /**
     * Method just prints into console all registered units in the system
     */
    public void printAllUnits(){
       for (task1.Unit unit : getAllUnits()) System.out.println(unit);
    }

    /**
     * Method prints only powered ON units into console with sorting by power consumption decrement
     */
    public void printAllSortedUnits(){
        System.out.println("Was powered On sorted list by power decrement");
        ArrayList<task1.Unit> units = getAllUnits(); // use private method for all units receiving
        units.sort(new task1.UnitPowerComparator()); // use comparator by power parametr
        for (task1.Unit unit : units){
            if (unit.isUnitPoweredOn())System.out.println(unit);
        }
    }
    /**
     * Method prints only powered ON units into console with sorting by power consumption decrement
     * and printing total power consumption
     */
    public void showActualPower(){
        int totalPower = 0;
        ArrayList<task1.Unit> units = getAllUnits();
        for (task1.Unit unit : units){
            if (unit.isUnitPoweredOn()) totalPower=totalPower+unit.getUnitPower();
        }
        printAllSortedUnits(); // prints only powered ON units
        System.out.println();
        System.out.println("TOTAL POWER CONSUMPTION IS: "+totalPower+"  wats.");

    }

    /**
     * This method finds and prints into console all units, which name consists some chars or whole word
     * @param unitName - String with part or whole unit Name
     */
    public void findUnit(String unitName){
        ArrayList<task1.Unit> units = getAllUnits();
        System.out.println("Was found the next units with name like:");
        for (task1.Unit unit : units){
            if (unit.getUnitName().contains(unitName) || unit.getUnitName().equalsIgnoreCase(unitName))
                System.out.println(unit);
        }
    }

    /**
     *This private method return all units from all rooms
     * @return - ArrayList of Units
     */
    private ArrayList<task1.Unit> getAllUnits(){
        ArrayList<task1.Unit> units = new ArrayList<>();
        for (task1.Room room : rooms) {
            for (task1.Unit unit : room.getRoomUnits()) {
                units.add(unit);
            }
        }
        return units;
    }

    /**
     * This private method finds unit by Id in all rooms
     * @param unitId - Integer  positive value - unique value for each unit
     * @return - Unit Object or NULL if Object wasn't found
     */
    private task1.Unit getOneUnit(int unitId){
        for (task1.Room room : rooms) {
            for (task1.Unit unit : room.getRoomUnits()) {
                if (unit.getUnitId()==unitId) return unit;
            }
        }
        return null;
    }

    /**
     * This private method finds room by String with it's name
     * @param roomName - String - Name of Room
     * @return - finded Room Object or NULL if Object wasn't found
     */
    private task1.Room findRoom(String roomName){
        for (task1.Room elem : rooms){
            if (elem.getRoomName().equalsIgnoreCase(roomName)) return elem;
        }
        return null;
    }


}
